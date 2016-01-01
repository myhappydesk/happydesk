/**
 * 
 */
package com.happydesk.dao;

import java.util.List;

import javax.persistence.Query;

import com.happydesk.entity.SocialCronData;

/**
 * @author Om Yadav 
 * DAO  for Social Cron Info data
 */

public class SocialCronInfoDAO extends GenericDao<Integer, SocialCronData> {


	private static final long serialVersionUID = 665413470983982687L;

	@SuppressWarnings("unchecked")
	public List<SocialCronData> findScialCronInfoByCompanyIdAndIP(Integer cronType, String ipAddress) {
		Query jpaQuery = getEntityManager()
				.createQuery("select socialInfo from SocialCronData socialInfo where socialInfo.socialCronType = :cronType and socialCronType.ipAddress = :ipAddress");
		jpaQuery.setParameter("cronType", cronType);
		jpaQuery.setParameter("ipAddress", ipAddress);
		return (List<SocialCronData>)  jpaQuery.getResultList();
	}
	
}
