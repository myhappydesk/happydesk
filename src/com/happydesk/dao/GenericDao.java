package com.happydesk.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.orm.jpa.support.JpaDaoSupport;

import com.happydesk.domain.Domain;
import com.happydesk.util.Filter;
import com.happydesk.util.HappyDeskException;


public class GenericDao<K, E extends Domain<?>> extends JpaDaoSupport implements Serializable
{
	private static final long serialVersionUID = 1L;

	
	protected JpaTemplate getJpaTemplateEx() throws HappyDeskException{
		JpaTemplate template = null;
		try {
			template = getJpaTemplate();
		} catch (Exception e) {
			throw new HappyDeskException("failed to acquire JpaTemplate.", e);
		}

		if (template == null) {
			throw new HappyDeskException("failed to acquire JpaTemplate.");
		}

		return template;
	}

	public EntityManager getEntityManager() {

		EntityManagerFactory emf = getJpaTemplate().getEntityManagerFactory();
		EntityManager em = EntityManagerFactoryUtils
				.getTransactionalEntityManager(emf);
		if (em == null) {
			//System.out.println("Warning: got entity manager from jpatemplate. if not on http listener this means we are not using transactions!");
			em = getJpaTemplate().getEntityManager();
		}
		if(em == null){
			//need to create a brand new entity manager
			em = emf.createEntityManager();
		}
		return em;
	}

	public int executeUpdateNative(String query) throws HappyDeskException
	{
		return executeUpdateNative(query, null);
	}

	public int executeUpdateNative(String query, List<Object> params) throws HappyDeskException
	{
		Query jpaQuery = getEntityManager().createNativeQuery(query);
		for (int i = 0; i < params.size(); i++)
		{
			jpaQuery.setParameter(i + 1, params.get(i));
		}
		return jpaQuery.executeUpdate();
	}

	public E findById(K id, Class<E> klass) throws HappyDeskException
	{
		return getEntityManager().find(klass, id); // class is keyword
	}
	
	public E findById(String id, Class<E> klass) throws HappyDeskException
	{
		return getEntityManager().find(klass, id); // class is keyword
	}

	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String name) throws HappyDeskException
	{
		Query query = getEntityManager().createNamedQuery(name);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String name, int first, int pageSize) throws HappyDeskException
	{
		Query query = getEntityManager().createNamedQuery(name);
		query.setFirstResult(first);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String name, Map<String, Object> params) throws HappyDeskException
	{
		Query query = getEntityManager().createNamedQuery(name);

		for (Entry<String, Object> param : params.entrySet())
		{
			query.setParameter(param.getKey(), param.getValue());
		}

		return query.getResultList();
	}

	public Object findNumberByNamedQuery(String name, Map<String, Object> params) throws HappyDeskException {
		Query query = getEntityManager().createNamedQuery(name);

		for (Entry<String, Object> param : params.entrySet())
		{
			query.setParameter(param.getKey(), param.getValue());
		}
		
		return (Long)query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String name, Map<String, Object> params, int first, 
			int pageSize) throws HappyDeskException
	{
		Query query = getEntityManager().createNamedQuery(name);

		for (Entry<String, Object> param : params.entrySet())
		{
			query.setParameter(param.getKey(), param.getValue());
		}

		query.setFirstResult(first);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String name, String param, Object value) throws HappyDeskException
	{
		Query query = null;
		try {
			query = getEntityManager().createNamedQuery(name);
			query.setParameter(param, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String name, String param, Object value, int first, 
			int pageSize) throws HappyDeskException
	{
		Query query = getEntityManager().createNamedQuery(name);
		query.setParameter(param, value);

		query.setFirstResult(first);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name) throws HappyDeskException
	{
		Query query = getEntityManager().createNamedQuery(name);
		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name, int first, int pageSize) throws HappyDeskException
	{
		Query query = getEntityManager().createNamedQuery(name);

		query.setFirstResult(first);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name, Map<String, Object> params) throws HappyDeskException
	{
		Query query = getEntityManager().createNamedQuery(name);

		for (Entry<String, Object> param : params.entrySet())
		{
			query.setParameter(param.getKey(), param.getValue());
		}

		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name, Map<String, Object> params, int first, int pageSize)  throws HappyDeskException
	{
		Query query = getEntityManager().createNamedQuery(name);

		for (Entry<String, Object> param : params.entrySet())
		{
			query.setParameter(param.getKey(), param.getValue());
		}

		query.setFirstResult(first);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name, String param, Object value) throws HappyDeskException
	{
		Query query = getEntityManager().createNamedQuery(name);
		query.setParameter(param, value);
		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name, String param, Object value, int first, int pageSize) throws HappyDeskException
	{
		Query query = getEntityManager().createNamedQuery(name);
		query.setParameter(param, value);

		query.setFirstResult(first);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	public List<? extends Object> findByNativeQuery(String qry) throws HappyDeskException
	{
		return findByNativeQuery(qry, null);
	}

	@SuppressWarnings("unchecked")
	public List<? extends Object> findByNativeQuery(String qry, List<Object> params) throws HappyDeskException
	{
		Query query = getEntityManager().createNativeQuery(qry);
		if (params != null && params.size() > 0)
		{
			for (int i = 0; i < params.size(); i++)
			{
				query.setParameter(i + 1, params.get(i));
			}
		}
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<E> findBySortAndFilter(int first, int pageSize, String sortField, boolean sortOrder, List<Filter> filters, int rowCount[], String className, String baseQuery,
			Map<String, Object> additionalParams, String countQuery)  throws HappyDeskException
	{
		StringBuilder query = new StringBuilder();
		boolean where = false;
		boolean whereTemp = false;

		int baseQueryFromIndex = baseQuery.toLowerCase().indexOf("from");
		if (countQuery != null)
		{
			query.append(countQuery);
			where = countQuery.toLowerCase().indexOf("where") > -1;
		}
		else
		{
			query.append("Select count(distinct ");
			query.append(className);
			query.append(" ) ");
			query.append(baseQuery.substring(baseQueryFromIndex));
			where = baseQuery.toLowerCase().indexOf("where") > -1;
		}

		whereTemp = where;

		for (Filter filter : filters)
		{
			if (filter.getValue() == null || filter.getValue() == "")
			{
				continue;
			}

			if (!where)
			{
				query.append(" where ");
				where = true;
			}
			else
			{
				query.append(" and ");
			}
			query.append(className);
			query.append(".");
			query.append(filter.getName());

			switch (filter.getType())
			{
				case Contains:
				case StartsWith:
					query.append(" like :");
					break;
				case Equals:
					query.append(" = :");
					break;
			}

			query.append(filter.getName().replace('.', '_'));
		}

		Query jpaQuery = getEntityManager().createQuery(query.toString());
		for (Filter filter : filters)
		{
			if (filter.getValue() == null || filter.getValue() == "")
			{
				continue;
			}

			String name = filter.getName().replace('.', '_');
			switch (filter.getType())
			{
				case Contains:
					jpaQuery.setParameter(name, "%" + filter.getValue() + "%");
					break;
				case StartsWith:
					jpaQuery.setParameter(name, filter.getValue() + "%");
					break;
				case Equals:
					jpaQuery.setParameter(name, filter.getValue());
					break;
			}
		}

		if (additionalParams != null && additionalParams.size() > 0)
		{
			for (Entry<String, Object> param : additionalParams.entrySet())
			{
				jpaQuery.setParameter(param.getKey(), param.getValue());
			}
		}
		rowCount[0] = ((Long) jpaQuery.getSingleResult()).intValue();

		if (rowCount[0] == 0)
		{
			return new ArrayList<E>();
		}

		where = whereTemp;

		query.setLength(0);
		query.append(baseQuery);

		for (Filter filter : filters)
		{
			if (filter.getValue() == null || filter.getValue() == "")
			{
				continue;
			}

			if (!where)
			{
				query.append(" where ");
				where = true;
			}
			else
			{
				query.append(" and ");
			}
			query.append(className);
			query.append(".");
			query.append(filter.getName());

			switch (filter.getType())
			{
				case Contains:
				case StartsWith:
					query.append(" like :");
					break;
				case Equals:
					query.append(" = :");
					break;
			}

			query.append(filter.getName().replace('.', '_'));
		}

		if (sortField != null)
		{
			query.append(" order by ").append(className).append(".");
			query.append(sortField);
			query.append(sortOrder ? " asc " : " desc ");
		}

		jpaQuery = getEntityManager().createQuery(query.toString());
		for (Filter filter : filters)
		{
			if (filter.getValue() == null || filter.getValue() == "")
			{
				continue;
			}

			String name = filter.getName().replace('.', '_');

			switch (filter.getType())
			{
				case Contains:
					jpaQuery.setParameter(name, "%" + filter.getValue() + "%");
					break;
				case StartsWith:
					jpaQuery.setParameter(name, filter.getValue() + "%");
					break;
				case Equals:
					jpaQuery.setParameter(name, filter.getValue());
					break;
			}
		}

		if (additionalParams != null && additionalParams.size() > 0)
		{
			for (Entry<String, Object> param : additionalParams.entrySet())
			{
				jpaQuery.setParameter(param.getKey(), param.getValue());
			}
		}

		jpaQuery.setFirstResult(first);
		jpaQuery.setMaxResults(pageSize);

		return jpaQuery.getResultList();
	}

	public void flush() throws HappyDeskException
	{
		getEntityManager().flush();
	}

	public E merge(E entity) throws HappyDeskException
	{
		/*if(entity.getClass().getName().equalsIgnoreCase(User.class.getName())) {
			updateElasticUser(entity);
		}
		if(entity.getClass().getName().equalsIgnoreCase(ExotelDetail.class.getName())) {
			updateElasticExotel(entity);
		}*/
		/*if(entity.getClass().getName().equalsIgnoreCase(Complaint.class.getName())) {
			updateElasticComplaint(entity);
		}*/
		
		return getEntityManager().merge(entity);
	}

	public void persist(E entity) throws HappyDeskException
	{
		getEntityManager().persist(entity);
		/*if(entity.getClass().getName().equalsIgnoreCase(User.class.getName())) {
			insertElasticUser(entity);
		}
		if(entity.getClass().getName().equalsIgnoreCase(ExotelDetail.class.getName())) {
			insertElasticExotel(entity);
		}*/
		/*if(entity.getClass().getName().equalsIgnoreCase(Complaint.class.getName())) {
			insertElasticComplaint(entity);
		}*/
		
	}
 
	/*public void saveOrUpdate(E entity) throws AkoshaException
	{
		getEntityManager().
	}
	*/
	public void refresh(E entity) throws HappyDeskException
	{
		getEntityManager().refresh(entity);
	}

	public void remove(E entity) throws HappyDeskException
	{
		getEntityManager().remove(entity);
	}
	
	//added by Prashant on 22-11-2011
	
	public Object findSingleResult(String name)throws HappyDeskException{
		//Query jpaQuery = getEntityManager().createQuery(query);
		Query jpaQuery = getEntityManager().createNamedQuery(name);
		return ((Object) jpaQuery.getSingleResult());
	}
	
	public Object findSingleResult(String name, Map<String, Object> params) throws HappyDeskException {
		Query query = getEntityManager().createNamedQuery(name);
		for (Entry<String, Object> param : params.entrySet())
		{
			query.setParameter(param.getKey(), param.getValue());
		}
		return (Object)query.getSingleResult();
	}
	
	public int executeUpdate(String query, Map<String, Object> params) throws HappyDeskException {
		Query jpaQuery = getEntityManager().createQuery(query);
		if(params != null){
			for (Entry<String, Object> param : params.entrySet())
			{
				jpaQuery.setParameter(param.getKey(), param.getValue());
			}
		}
		return jpaQuery.executeUpdate();
		
	}
	
	public int executeUpdate(String query) throws HappyDeskException {
		return executeUpdate(query, null);
	}
	
	public int executeUpdateByNamedQuery(String name) throws HappyDeskException {
		Query query = getEntityManager().createNamedQuery(name);
		return query.executeUpdate();
	}
	
	public int executeUpdateByNamedQuery(String name, Map<String, Object> params) throws HappyDeskException {
		Query jpaQuery = getEntityManager().createNamedQuery(name);
		if(params != null){
			for (Entry<String, Object> param : params.entrySet())
			{
				jpaQuery.setParameter(param.getKey(), param.getValue());
			}
			return jpaQuery.executeUpdate();
		}
		return  executeUpdateByNamedQuery(name);
	}

 //Moved by Manoj from complaintDao on 21/06/2013
	public Long findTotalPagesByFilters(StringBuilder countQuery , Map<String, Object> params) throws HappyDeskException{
		Query jpaCountQuery = getEntityManager().createQuery(countQuery.toString());
		if(params!=null){
		for (Entry<String, Object> param : params.entrySet())
		{
			jpaCountQuery.setParameter(param.getKey(), param.getValue());
		}
		}
		return  (Long)jpaCountQuery.getSingleResult();
	}
	
	
	/*
	 * Code to update elastic search on Update/Insert. Done to make search real time.
	 * 
	 */
	/*public void updateElasticUser(E entity) {
		try {
				TransportClient client =  (TransportClient) ElasticSearchUtility.getInstance();
				
				BulkRequestBuilder bulkRequest = client.prepareBulk();
				
				User user = (User)entity;
				
				bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.USER_INDEX, ElasticSearchConstants.USER_INDEX_TYPE, String.valueOf(user.getId())).setScript("ctx._source.name=\"" + user.getName() + "\"", ScriptType.INLINE));
				bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.USER_INDEX, ElasticSearchConstants.USER_INDEX_TYPE, String.valueOf(user.getId())).setScript("ctx._source.mobile=\"" + user.getMobile() + "\"", ScriptType.INLINE));
				bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.USER_INDEX, ElasticSearchConstants.USER_INDEX_TYPE, String.valueOf(user.getId())).setScript("ctx._source.password=\"" + user.getPassword() + "\"", ScriptType.INLINE));
				bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.USER_INDEX, ElasticSearchConstants.USER_INDEX_TYPE, String.valueOf(user.getId())).setScript("ctx._source.user_type=\"" + user.getUserType() + "\"", ScriptType.INLINE));
				bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.USER_INDEX, ElasticSearchConstants.USER_INDEX_TYPE, String.valueOf(user.getId())).setScript("ctx._source.email=\"" + user.getEmail() + "\"", ScriptType.INLINE));
				bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.USER_INDEX, ElasticSearchConstants.USER_INDEX_TYPE, String.valueOf(user.getId())).setScript("ctx._source.updated_by=\"" + user.getUpdatedBy() + "\"", ScriptType.INLINE));
				bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.USER_INDEX, ElasticSearchConstants.USER_INDEX_TYPE, String.valueOf(user.getId())).setScript("ctx._source.status=\"" + user.getStatus() + "\"", ScriptType.INLINE));
				bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.USER_INDEX, ElasticSearchConstants.USER_INDEX_TYPE, String.valueOf(user.getId())).setScript("ctx._source.user_access_token=\"" + user.getAccessToken() + "\"", ScriptType.INLINE));
				bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.USER_INDEX, ElasticSearchConstants.USER_INDEX_TYPE, String.valueOf(user.getId())).setScript("ctx._source.created_at=\"" + user.getCreatedAt() + "\"", ScriptType.INLINE));
				bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.USER_INDEX, ElasticSearchConstants.USER_INDEX_TYPE, String.valueOf(user.getId())).setScript("ctx._source.updated_at=\"" + user.getUpdatedAt() + "\"", ScriptType.INLINE));
				
				bulkRequest.execute().actionGet();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}*/
	
/*	public void insertElasticUser(E entity) {
		try {
			TransportClient client =  (TransportClient) ElasticSearchUtility.getInstance();
			
			User user = (User)entity;
			
			Map<String, Object> obj = new HashMap<String, Object>();
			obj.put("id", user.getId());
			obj.put("name", user.getName());
			obj.put("mobile", user.getMobile());
			obj.put("password", user.getPassword());
			obj.put("user_type", user.getUserType());
			obj.put("email", user.getEmail());
			obj.put("updated_by", user.getUpdatedBy());
			obj.put("status", user.getStatus());
			obj.put("user_access_token", user.getAccessToken());
			obj.put("created_at", user.getCreatedAt());
			obj.put("updated_at", user.getUpdatedAt());
			
			//obj.put("author", author);
			client.prepareIndex(ElasticSearchConstants.USER_INDEX, ElasticSearchConstants.USER_INDEX_TYPE, String.valueOf(user.getId())).setSource(obj).execute().actionGet();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}*/
	
	/*public void insertElasticExotel(E entity) {
		try {
			TransportClient client =  (TransportClient) ElasticSearchUtility.getInstance();
			
			ExotelDetail exotelDetail = (ExotelDetail)entity;
			
			Map<String, Object> obj = new HashMap<String, Object>();
			obj.put("id", exotelDetail.getId());
			obj.put("user_id", exotelDetail.getUser().getId());
			obj.put("callSid", exotelDetail.getCallSId());
			obj.put("to_phone", exotelDetail.getToPhone());
			obj.put("from_phone", exotelDetail.getFromPhone());
			obj.put("status", exotelDetail.getStatus());
			obj.put("start_time", exotelDetail.getStartTime());
			obj.put("end_time", exotelDetail.getEndTime());
			obj.put("created_at", exotelDetail.getCreatedAt());
			obj.put("recording_url", exotelDetail.getRecordingUrl());
			obj.put("exoteldetail_type", exotelDetail.getExotelDetailType());
			obj.put("duration", exotelDetail.getDuration());
			obj.put("complaint_id", exotelDetail.getComplaint().getId());
			obj.put("date_updated", exotelDetail.getDateUpdate());
			obj.put("price", exotelDetail.getPrice());
			obj.put("status_updated", exotelDetail.getStatus_updated());
			
			client.prepareIndex(ElasticSearchConstants.EXOTEL_INDEX, ElasticSearchConstants.EXOTEL_INDEX_TYPE, String.valueOf(exotelDetail.getId())).setSource(obj).execute().actionGet();

					} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	public void updateElasticExotel(E entity) {
		try {
			TransportClient client =  (TransportClient) ElasticSearchUtility.getInstance();
			
			BulkRequestBuilder bulkRequest = client.prepareBulk();
			ExotelDetail exotel = (ExotelDetail)entity;
			
			bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.EXOTEL_INDEX, ElasticSearchConstants.EXOTEL_INDEX_TYPE,String.valueOf(exotel.getId())).setScript("ctx._source.user_id=\"" + exotel.getUser().getId() + "\"", ScriptType.INLINE));
			bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.EXOTEL_INDEX, ElasticSearchConstants.EXOTEL_INDEX_TYPE,String.valueOf(exotel.getId())).setScript("ctx._source.callSid=\"" + exotel.getCallSId() + "\"", ScriptType.INLINE));
			bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.EXOTEL_INDEX, ElasticSearchConstants.EXOTEL_INDEX_TYPE,String.valueOf(exotel.getId())).setScript("ctx._source.to_phone=\"" + exotel.getToPhone() + "\"", ScriptType.INLINE));
			bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.EXOTEL_INDEX, ElasticSearchConstants.EXOTEL_INDEX_TYPE,String.valueOf(exotel.getId())).setScript("ctx._source.from_phone=\"" + exotel.getFromPhone() + "\"", ScriptType.INLINE));
			bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.EXOTEL_INDEX, ElasticSearchConstants.EXOTEL_INDEX_TYPE,String.valueOf(exotel.getId())).setScript("ctx._source.status=\"" + exotel.getStatus() + "\"", ScriptType.INLINE));
			bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.EXOTEL_INDEX, ElasticSearchConstants.EXOTEL_INDEX_TYPE,String.valueOf(exotel.getId())).setScript("ctx._source.start_time=\"" + exotel.getStartTime() + "\"", ScriptType.INLINE));
			bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.EXOTEL_INDEX, ElasticSearchConstants.EXOTEL_INDEX_TYPE,String.valueOf(exotel.getId())).setScript("ctx._source.end_time=\"" + exotel.getEndTime() + "\"", ScriptType.INLINE));
			bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.EXOTEL_INDEX, ElasticSearchConstants.EXOTEL_INDEX_TYPE,String.valueOf(exotel.getId())).setScript("ctx._source.created_at=\"" + exotel.getCreatedAt() + "\"", ScriptType.INLINE));
			bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.EXOTEL_INDEX, ElasticSearchConstants.EXOTEL_INDEX_TYPE,String.valueOf(exotel.getId())).setScript("ctx._source.recording_url=\"" + exotel.getRecordingUrl() + "\"", ScriptType.INLINE));
			bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.EXOTEL_INDEX, ElasticSearchConstants.EXOTEL_INDEX_TYPE,String.valueOf(exotel.getId())).setScript("ctx._source.exoteldetail_type=\"" + exotel.getExotelDetailType() + "\"", ScriptType.INLINE));
			bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.EXOTEL_INDEX, ElasticSearchConstants.EXOTEL_INDEX_TYPE,String.valueOf(exotel.getId())).setScript("ctx._source.duration=\"" + exotel.getDuration() + "\"", ScriptType.INLINE));
			bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.EXOTEL_INDEX, ElasticSearchConstants.EXOTEL_INDEX_TYPE,String.valueOf(exotel.getId())).setScript("ctx._source.complaint_id=\"" + exotel.getComplaint().getId() + "\"", ScriptType.INLINE));
			bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.EXOTEL_INDEX, ElasticSearchConstants.EXOTEL_INDEX_TYPE,String.valueOf(exotel.getId())).setScript("ctx._source.date_updated=\"" + exotel.getDateUpdate() + "\"", ScriptType.INLINE));
			bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.EXOTEL_INDEX, ElasticSearchConstants.EXOTEL_INDEX_TYPE,String.valueOf(exotel.getId())).setScript("ctx._source.price=\"" + exotel.getPrice() + "\"", ScriptType.INLINE));
			bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.EXOTEL_INDEX, ElasticSearchConstants.EXOTEL_INDEX_TYPE,String.valueOf(exotel.getId())).setScript("ctx._source.status_updated=\"" + exotel.getStatus_updated() + "\"", ScriptType.INLINE));
			
			bulkRequest.execute().actionGet();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void insertElasticComplaint(E entity) {
		try {

			TransportClient client =  (TransportClient) ElasticSearchUtility.getInstance();
			
			Complaint complaint = (Complaint)entity;
			
			Map<String, Object> obj = new HashMap<String, Object>();
			obj.put("id", complaint.getId());
			obj.put("user_id", complaint.getUser().getId());
			obj.put("company_id", complaint.getCompany().getId());
			obj.put("product_type_id", complaint.getProductType().getId());
			obj.put("complaint_category_id", complaint.getComplaintCategory());
			obj.put("low_amount_filter_status", complaint.getLowAmountFilterStatus());
			obj.put("created_at", complaint.getCreatedAt());
			obj.put("source", complaint.getSource());
			
			//obj.put("author", author);
			client.prepareIndex(ElasticSearchConstants.COMPLAINT_INDEX, ElasticSearchConstants.COMPLAINT_INDEX_TYPE, String.valueOf(complaint.getId())).setSource(obj).execute().actionGet();
	
			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	public void updateElasticComplaint(E entity) {
		try {
			TransportClient client =  (TransportClient) ElasticSearchUtility.getInstance();
			
			BulkRequestBuilder bulkRequest = client.prepareBulk();
			
			Complaint complaint = (Complaint)entity;
			
			bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.COMPLAINT_INDEX, ElasticSearchConstants.COMPLAINT_INDEX_TYPE, String.valueOf(complaint.getId())).setScript("ctx._source.id=\"" + complaint.getId() + "\"", ScriptType.INLINE));
			bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.COMPLAINT_INDEX, ElasticSearchConstants.COMPLAINT_INDEX_TYPE, String.valueOf(complaint.getId())).setScript("ctx._source.user_id=\"" + complaint.getUser().getId() + "\"", ScriptType.INLINE));
			bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.COMPLAINT_INDEX, ElasticSearchConstants.COMPLAINT_INDEX_TYPE, String.valueOf(complaint.getId())).setScript("ctx._source.company_id=\"" + complaint.getCompany().getId() + "\"", ScriptType.INLINE));
			bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.COMPLAINT_INDEX, ElasticSearchConstants.COMPLAINT_INDEX_TYPE, String.valueOf(complaint.getId())).setScript("ctx._source.product_type_id=\"" + complaint.getProductType().getId() + "\"", ScriptType.INLINE));
			bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.COMPLAINT_INDEX, ElasticSearchConstants.COMPLAINT_INDEX_TYPE, String.valueOf(complaint.getId())).setScript("ctx._source.complaint_category_id=\"" + complaint.getComplaintCategory().getId() + "\"", ScriptType.INLINE));
			bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.COMPLAINT_INDEX, ElasticSearchConstants.COMPLAINT_INDEX_TYPE, String.valueOf(complaint.getId())).setScript("ctx._source.low_amount_filter_status=\"" + complaint.getLowAmountFilterStatus() + "\"", ScriptType.INLINE));
			bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.COMPLAINT_INDEX, ElasticSearchConstants.COMPLAINT_INDEX_TYPE, String.valueOf(complaint.getId())).setScript("ctx._source.created_at=\"" + complaint.getCreatedAt() + "\"", ScriptType.INLINE));
			bulkRequest.add(client.prepareUpdate(ElasticSearchConstants.COMPLAINT_INDEX, ElasticSearchConstants.COMPLAINT_INDEX_TYPE, String.valueOf(complaint.getId())).setScript("ctx._source.updated_at=\"" + complaint.getSource() + "\"", ScriptType.INLINE));
			
			bulkRequest.execute().actionGet();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}*/
	
}