package com.happydesk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happydesk.dao.LastAPICallDataDAO;
import com.happydesk.entity.Company;
import com.happydesk.entity.LastAPICallData;
import com.happydesk.social.SocialCronType;
import com.happydesk.util.DateUtils;

import twitter4j.DirectMessage;

/**
 * @author Om Yadav 
 * Last API Call Data Service
 */

@Service
public class LastAPICallDataService {

	@Autowired
	private LastAPICallDataDAO lastAPICallDataDAO;

	public LastAPICallData findLastAPICallInfoByCompanyIdAndCronType(Integer companyId, Integer cronType) {
		return lastAPICallDataDAO.findLastAPICallInfoByCompanyIdAndCronType(companyId, cronType);
	}

	@Transactional(rollbackFor = Exception.class)
	public void saveOrUpdateAPICallData(LastAPICallData lastAPICallData, DirectMessage directMessage, Company company) {
		if (lastAPICallData != null) {
			lastAPICallData.setLastResourceId(directMessage.getId());
			lastAPICallData.setLastRequestedDate(DateUtils.getCurrentDateTime());
			lastAPICallData.setUpdatedAt(DateUtils.getCurrentDateTime());
		} else {
			lastAPICallData = new LastAPICallData();
			lastAPICallData.setLastResourceId(directMessage.getId());
			lastAPICallData.setCompany(company);
			lastAPICallData.setResourceType(SocialCronType.TwitterDM.getValue());
			lastAPICallData.setLastRequestedDate(DateUtils.getCurrentDateTime());
			lastAPICallData.setCreatedAt(DateUtils.getCurrentDateTime());
		}
		save(lastAPICallData);
	}

	@Transactional(rollbackFor = Exception.class)
	public void save(LastAPICallData lastAPICallData) {
		if (lastAPICallData != null && lastAPICallData.getId() != null) {
			lastAPICallDataDAO.merge(lastAPICallData);
		} else {
			lastAPICallDataDAO.persist(lastAPICallData);
		}
	}

}
