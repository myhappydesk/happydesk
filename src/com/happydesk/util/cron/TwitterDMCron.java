package com.happydesk.util.cron;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.happydesk.entity.Company;
import com.happydesk.entity.LastAPICallData;
import com.happydesk.entity.SocialCronData;
import com.happydesk.service.LastAPICallDataService;
import com.happydesk.service.SocialCronInfoService;
import com.happydesk.social.SocialCronType;
import com.happydesk.util.ConfigProperties;
import com.happydesk.util.HappyDeskUtils;

import twitter4j.DirectMessage;
import twitter4j.Paging;
import twitter4j.RateLimitStatus;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

@DisallowConcurrentExecution
public class TwitterDMCron implements Job, ServletContextAware {
	private final Logger twitterDMCronLogger = Logger.getLogger("TwitterDMCron");

	@Autowired
	private ConfigProperties config;
	@Autowired
	private SocialCronInfoService socialCronInfoService;
	@Autowired
	LastAPICallDataService lastAPICallDataService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		try {
			List<SocialCronData> twitterDMCronsInfoList = socialCronInfoService
					.findScialCronInfoByCompanyIdAndIP(SocialCronType.TwitterDM.getValue(),
							HappyDeskUtils.getMachineIPAddress());

			if (twitterDMCronsInfoList != null && twitterDMCronsInfoList.size() > 0) {
				for (SocialCronData socialCronData : twitterDMCronsInfoList) {
					processTwitterDM(socialCronData.getCompany().getId());
				}
			}
		} catch (Exception exception) {
			twitterDMCronLogger.error(
					"Error while executing Twitter DM Cron. Error Message: " + ExceptionUtils.getStackTrace(exception));
		}
	}

	public void processTwitterDM(Integer companyId){
		// Twitter Configuration 
    	ConfigurationBuilder builder = new ConfigurationBuilder();
     	builder.setOAuthAccessToken(config.getTwitterAccessKey());
     	builder.setOAuthAccessTokenSecret(config.getTwitterAccessSecret());
     	builder.setOAuthConsumerKey(config.getTwitterConsumerKey());
     	builder.setOAuthConsumerSecret(config.getTwitterConsumerSecret());
     	Configuration configuration = builder.build();
     	TwitterFactory factory = new TwitterFactory(configuration);
    	Twitter twitter = factory.getInstance();
    	
    	long lastResourceId = 0;
    	int totalNumberOfPages = 0 ;
    	
    	LastAPICallData lastAPICallData = lastAPICallDataService.findLastAPICallInfoByCompanyIdAndCronType(companyId, SocialCronType.TwitterDM.getValue());
    	
    	if(lastAPICallData != null && lastAPICallData.getLastResourceId() != null){
    		lastResourceId = lastAPICallData.getLastResourceId();
    	}
    	
    	try {
	    	Paging paging = new Paging();
	    	if(lastResourceId > 0){
	    		RateLimitStatus rateLimitStatus = twitter.getRateLimitStatus().get("/direct_messages");
	    		totalNumberOfPages = rateLimitStatus.getRemaining();
	    		paging = new Paging(1, lastResourceId);
	    	}else{
	    		totalNumberOfPages = 1;
	    		paging = new Paging(1);
	    	}
	    	
			
			if (totalNumberOfPages == 0) {
				twitterDMCronLogger.info("Rate limit exceeded for company with Id: " + companyId);
				return;
			}

			DirectMessage message = null;
			do {
				List<DirectMessage> listOfMessages = twitter.getDirectMessages(paging);
				if (listOfMessages == null || listOfMessages.size() == 0) break;
				for (int i = listOfMessages.size() - 1; i >= 0; i--){
					 message = listOfMessages.get(i);
					// TODO Logic to process Twitter DM Messages
					System.out.println("Messages received. Resource Text: "+message.getText());
				 }
				
				if(listOfMessages.size() == 20)
					paging.setPage(paging.getPage() + 1);
				else
					break;
			} while (paging.getPage() < totalNumberOfPages);

			if (message != null) {
				Company company = null;
				//company = companyService.findCompnayById(compnayId);
				lastAPICallDataService.saveOrUpdateAPICallData(lastAPICallData, message, company);
			}
		}catch (TwitterException twitterException) {
			twitterDMCronLogger.error("Error occured while processing Twitter DM Message. Error Message: "
					+ ExceptionUtils.getStackTrace(twitterException));
        }
	}

	@Override
	public void setServletContext(ServletContext arg0) { }

}
