package com.happydesk.util.cron;

import javax.servlet.ServletContext;


import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;


@DisallowConcurrentExecution
public class FacebookCron implements Job, ServletContextAware{
	
	
	//private SocialComplaintAction socialComplaintAction;
	@Autowired
	private ServletContext application;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		
		
	}

	@Override
	public void setServletContext(ServletContext application) {
		this.setApplication(application);
		
	}

	public ServletContext getApplication() {
		return application;
	}

	public void setApplication(ServletContext application) {
		this.application = application;
	}
	
	

}

