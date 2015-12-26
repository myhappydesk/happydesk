/**
 * 
 */
package com.happydesk.dao;

import java.util.List;

import javax.persistence.Query;

import com.happydesk.entity.TwitterRawData;

/**
 * @author Om Yadav 
 * 
 * For storing Twitter Raw data
 */

public class TwitterRawDataDAO extends GenericDao<Integer, TwitterRawData> {

	private static final long serialVersionUID = -7182474704310999245L;

	@SuppressWarnings("unchecked")
	public TwitterRawData findTwitterRawDataByResourceId(Long resourceId) {
		Query jpaQuery = getEntityManager()
				.createQuery("select twRawData from TwitterRawData twRawData where twRawData.resourceId = :resourceId");
		jpaQuery.setParameter("resourceId", resourceId);
		List<TwitterRawData> list = jpaQuery.getResultList();
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
}
