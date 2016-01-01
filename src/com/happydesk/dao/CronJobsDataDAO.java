package com.happydesk.dao;

import java.util.List;

import javax.persistence.Query;

import com.happydesk.entity.CronJobsData;

public class CronJobsDataDAO extends GenericDao<Integer, CronJobsData> {

	/**
	 * @author Om Yadav
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public List<CronJobsData> findAllCronsData() {
		Query jpaQuery = getEntityManager()
				.createQuery("select cronData from CronJobsData cronData");
		List<CronJobsData> cronsList = jpaQuery.getResultList();
		return cronsList;
	}

}
