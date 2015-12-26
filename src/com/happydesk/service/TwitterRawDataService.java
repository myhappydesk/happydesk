/**
 * 
 */
package com.happydesk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happydesk.dao.TwitterRawDataDAO;
import com.happydesk.entity.TwitterRawData;

/**
 * @author Om Yadav
 *
 *Twitter Raw Data Service 
 */

@Service
public class TwitterRawDataService{

	@Autowired
	private TwitterRawDataDAO twitterRawDataDAO;
	
	public void saveOrUpdateRawData(TwitterRawData twitterRawData){
		if(twitterRawData != null){
			if(twitterRawData.getId() != null){
				twitterRawDataDAO.merge(twitterRawData);
			}else{
				twitterRawDataDAO.persist(twitterRawData);
			}
		}
	}
	
	public TwitterRawData findTwitterRawDataByResourceId(Long resourceId){
		return twitterRawDataDAO.findTwitterRawDataByResourceId(resourceId);
		
	}
	
	public void processTwitterDMRawData(){
		
	}
	
}
