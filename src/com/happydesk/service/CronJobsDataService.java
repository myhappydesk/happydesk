package com.happydesk.service;

import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happydesk.dao.CronJobsDataDAO;
import com.happydesk.entity.CronJobsData;
import com.happydesk.util.HappyDeskException;
import com.happydesk.util.HappyDeskUtils;

/**
 * @author Om Yadav 
 * Social Cron Jobs Data Service
 */

@Service
public class CronJobsDataService {

	@Autowired
	private CronJobsDataDAO cronJobsDataDAO;
	private static final Logger log = Logger.getLogger(CronJobsDataService.class);

	public List<CronJobsData> findAllCronsData() {
		return cronJobsDataDAO.findAllCronsData();
	}

	public boolean isValidCronJob(CronJobsData cronJobsData){
		try {
			if (cronJobsData.getStatus() == 1 && cronJobsData.getProcessHost() != null && cronJobsData.getProcessHost()
					.contains(HappyDeskUtils.getMachineIPAddress())) {
				return true;
			}
		} catch (HappyDeskException e) {
			log.error("Error while calling isValidCronJob method. Error Message: "+ExceptionUtils.getMessage(e));
		}
		return false;
	}
}
