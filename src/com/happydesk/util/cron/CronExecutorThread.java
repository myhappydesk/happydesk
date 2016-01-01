package com.happydesk.util.cron;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.happydesk.entity.CronJobsData;
import com.happydesk.service.CronJobsDataService;
import com.happydesk.util.HappyDeskException;
import com.happydesk.util.HappyDeskUtils;

@Component
public class CronExecutorThread implements ApplicationListener<ContextRefreshedEvent> {
	private static final Logger logger = Logger.getLogger(CronExecutorThread.class.getName());
	private static volatile boolean isContextLoaded = false;

	@Autowired
	ServletContext application;

	@Autowired
	private CronJobsDataService cronJobsDataService;

	@SuppressWarnings("unchecked")
	private void initCronTrigger(){
		try {
			List<CronJobsData> cronsList = cronJobsDataService.findAllCronsData();
			Scheduler scheduler = new StdSchedulerFactory("/quartz.properties").getScheduler();
			scheduler.start();
			for (CronJobsData cronJobsData : cronsList) {
				if (cronJobsData.getJobTimeExpression() != null && cronJobsData.getJobTimeExpression().length() > 0) {
					Class<? extends Job> jobClass = (Class<? extends Job>) Class.forName(cronJobsData.getJobClassName());
					boolean validcronJob = cronJobsDataService.isValidCronJob(cronJobsData);
					if(!validcronJob) {
						JobKey jobKey = JobKey.jobKey("Job_" + cronJobsData.getJobName(),
								"Group_" + HappyDeskUtils.getMachineIPAddress());
						if (scheduler.checkExists(jobKey)) {
							scheduler.deleteJob(jobKey); 
							logger.info("Successfully deleted job with job key :"+jobKey);
						}
					 }else if (validcronJob) {
						Trigger newTrigger = TriggerBuilder.newTrigger()
								.withIdentity("Trigger_" + cronJobsData.getJobName(),
										"Group_" + HappyDeskUtils.getMachineIPAddress())
								.withSchedule(CronScheduleBuilder.cronSchedule(cronJobsData.getJobTimeExpression())
										.withMisfireHandlingInstructionDoNothing())
								.build();
						TriggerKey oldTriggerKey = TriggerKey.triggerKey("Trigger_" + cronJobsData.getJobName(),
								"Group_" + HappyDeskUtils.getMachineIPAddress());
						if (scheduler.checkExists(oldTriggerKey)) {
							scheduler.rescheduleJob(oldTriggerKey, newTrigger);
							logger.info("Rescheduled Job with job name: "+ cronJobsData.getJobName());
						} else {
							JobDetail job = JobBuilder.newJob(jobClass).withIdentity("Job_" + cronJobsData.getJobName(),
									"Group_" + HappyDeskUtils.getMachineIPAddress()).build();
							scheduler.scheduleJob(job, newTrigger);
							logger.info("New Job created with job description: "+ job.getDescription());
						}
					}
				}
			}
			logCronTriggerTime(scheduler);
		} catch (Exception e) {
			logger.error("Error ocurred during job execution. Error Message: " + ExceptionUtils.getFullStackTrace(e));
		}
	}

	private void logCronTriggerTime(Scheduler scheduler) throws SchedulerException, HappyDeskException {
		logger.info("Scheduler started with " + scheduler.getMetaData().getThreadPoolSize()
				+ " threads in the  " + scheduler.getMetaData().getThreadPoolClass() + " pool.");
		for (String groupName : scheduler.getJobGroupNames()) {
			for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
				String jobName = jobKey.getName();
				List<? extends Trigger> triggers = (List<? extends Trigger>) scheduler.getTriggersOfJob(jobKey);
				Date nextFireTime = triggers.get(0).getNextFireTime();
				logger.info(" IP Address : " + HappyDeskUtils.getMachineIPAddress());
				logger.info(" Cron Job Name : " + jobName + " Next Execution Time : " + nextFireTime);
			}
		}
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		synchronized (CronExecutorThread.class) {
			if (isContextLoaded){
				logger.info("Cron Trigger Context has been already initialized.");
				return;
			}
			
			initCronTrigger();
			isContextLoaded = true;
		}
	}
}