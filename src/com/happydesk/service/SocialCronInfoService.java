package com.happydesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happydesk.dao.SocialCronInfoDAO;
import com.happydesk.entity.SocialCronData;

 
/**
 * @author Om Yadav
 * Social Cron Info Service 
 */

@Service
public class SocialCronInfoService {

	@Autowired
	private SocialCronInfoDAO socialCronInfoDAO;
	
	public List<SocialCronData> findScialCronInfoByCompanyIdAndIP(Integer cronType, String ipAddress){
		return socialCronInfoDAO.findScialCronInfoByCompanyIdAndIP(cronType, ipAddress);
	}
}
