package com.happydesk.dao;

import java.util.List;

import javax.persistence.Query;

import com.happydesk.entity.LastAPICallData;
import com.happydesk.entity.SocialCronData;

/**
 * @author Om Yadav 
 * DAO for Last API Call data 
 */

public class LastAPICallDataDAO extends GenericDao<Integer, LastAPICallData> {

	private static final long serialVersionUID = 2598806068320603997L;

	@SuppressWarnings("unchecked")
	public LastAPICallData findLastAPICallInfoByCompanyIdAndCronType(Integer companyId, Integer cronType) {
		Query jpaQuery = getEntityManager()
				.createQuery("select lastAPICallInfo from LastAPICallData lastAPICallInfo where lastAPICallInfo.resourceType = :cronType and lastAPICallInfo.company.id = :companyId");
		jpaQuery.setParameter("cronType", cronType);
		jpaQuery.setParameter("companyId", companyId);
		List<LastAPICallData> lastAPICallDatalist = (List<LastAPICallData>)  jpaQuery.getResultList();
		if(lastAPICallDatalist != null & lastAPICallDatalist.size()>0){
			lastAPICallDatalist.get(0);
		}
		
		return null;
	}
	
}
