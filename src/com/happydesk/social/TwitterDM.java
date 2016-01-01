package com.happydesk.social;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.happydesk.util.ConfigProperties;

import twitter4j.DirectMessage;
import twitter4j.Paging;
import twitter4j.RateLimitStatus;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;



public class TwitterDM {

	@Autowired
	private ConfigProperties config;
	
	private static final Logger logger =  LoggerFactory.getLogger(TwitterDM.class);
	private final String TWITTER_ACCESS_KEY = config.getTwitterAccessKey();
	private final String TWITTER_ACCESS_SECRET = config.getTwitterAccessSecret();
	private final String TWITTER_CONSUMER_KEY = config.getTwitterConsumerKey();
	private final String TWITTER_CONSUMER_SECRET = config.getTwitterConsumerSecret();
	private final String TWITTER_CALLBACK_URL = config.getTwitterCallbackURL();

			
	public String populateTwitterDM() throws Exception{
	    	ConfigurationBuilder builder = new ConfigurationBuilder();
	     	builder.setOAuthAccessToken(TWITTER_ACCESS_KEY);
	     	builder.setOAuthAccessTokenSecret(TWITTER_ACCESS_SECRET);
	     	builder.setOAuthConsumerKey(TWITTER_CONSUMER_KEY);
	     	builder.setOAuthConsumerSecret(TWITTER_CONSUMER_SECRET);
	     	Configuration configuration = builder.build();
	     	TwitterFactory factory = new TwitterFactory(configuration);
	    	Twitter twitter = factory.getInstance();
	    	
	    	int pages = 0 ;
	    	
	    	Paging paging = new Paging();
    		RateLimitStatus rateLimit=twitter.getRateLimitStatus().get("/direct_messages");
    		pages=rateLimit.getRemaining();
    		paging = new Paging(1, 20);
    		logger.info("Rate limit :"+rateLimit);
	    	
	    	try {
	    		List<DirectMessage> messages;
	    		if(pages!=0){
		    		do {
		                messages = twitter.getDirectMessages(paging);
		                if(messages.size()>0){
		                	for(int i=messages.size()-1;i>=0;i--){
			                	DirectMessage message = messages.get(i);
			                	System.out.println("Message Data : "+ message.toString());
			                }
			                if(messages.size()==20)
			                	paging.setPage(paging.getPage() + 1);
			                else
			                	
			                	break;
		                }else{
		                	
		                	break;
		                }
		            } while (paging.getPage() < pages);
	    		}
	    		else
	    			logger.info("Rate limit exceeded ");
	           } catch (TwitterException twitterException) {
	        	   twitterException.printStackTrace();
	        	   logger.error("Failed to get messages: " + twitterException.getMessage());
	        }
		return null;
		}
	
	
	
	public static void main(String[] args) throws Exception {
		new TwitterDM().populateTwitterDM();
	}
}
