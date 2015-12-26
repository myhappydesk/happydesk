package com.happydesk.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.orm.jpa.EntityManagerFactoryUtils;

import com.happydesk.entity.BaseEntity;


public class GenericDao<K, E extends BaseEntity<?>> implements Serializable {

	private static final long serialVersionUID = 5614427191507003407L;
	private EntityManagerFactory entityManagerFactory;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    
	/**
	 * @return the entityManagerFactory
	 */
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}


	public EntityManager getEntityManager() {

		EntityManagerFactory entityManagerFactory = getEntityManagerFactory();
		EntityManager entityManager = EntityManagerFactoryUtils.getTransactionalEntityManager(entityManagerFactory);
		
		if (entityManager == null) {
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}

	public int executeUpdateNative(String query) {
		return executeUpdateNative(query, null);
	}

	public int executeUpdateNative(String query, List<Object> params){
		Query jpaQuery = getEntityManager().createNativeQuery(query);
		for (int i = 0; i < params.size(); i++) {
			jpaQuery.setParameter(i + 1, params.get(i));
		}
		return jpaQuery.executeUpdate();
	}

	public E findById(K id, Class<E> klass){
		return getEntityManager().find(klass, id); // class is keyword
	}

	public E findById(String id, Class<E> klass){
		return getEntityManager().find(klass, id); // class is keyword
	}

	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String name){
		Query query = getEntityManager().createNamedQuery(name);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String name, int first, int pageSize){
		Query query = getEntityManager().createNamedQuery(name);
		query.setFirstResult(first);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String name, Map<String, Object> params){
		Query query = getEntityManager().createNamedQuery(name);

		for (Entry<String, Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		return query.getResultList();
	}

	public Object findNumberByNamedQuery(String name, Map<String, Object> params){
		Query query = getEntityManager().createNamedQuery(name);

		for (Entry<String, Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		return (Long) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String name, Map<String, Object> params, int first, int pageSize){
		Query query = getEntityManager().createNamedQuery(name);

		for (Entry<String, Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		query.setFirstResult(first);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String name, String param, Object value){
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
	public List<E> findByNamedQuery(String name, String param, Object value, int first, int pageSize){
		Query query = getEntityManager().createNamedQuery(name);
		query.setParameter(param, value);

		query.setFirstResult(first);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name){
		Query query = getEntityManager().createNamedQuery(name);
		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name, int first, int pageSize){
		Query query = getEntityManager().createNamedQuery(name);

		query.setFirstResult(first);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name, Map<String, Object> params){
		Query query = getEntityManager().createNamedQuery(name);

		for (Entry<String, Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name, Map<String, Object> params, int first, int pageSize){
		Query query = getEntityManager().createNamedQuery(name);

		for (Entry<String, Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		query.setFirstResult(first);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name, String param, Object value){
		Query query = getEntityManager().createNamedQuery(name);
		query.setParameter(param, value);
		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name, String param, Object value, int first, int pageSize){
		Query query = getEntityManager().createNamedQuery(name);
		query.setParameter(param, value);

		query.setFirstResult(first);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	public List<? extends Object> findByNativeQuery(String qry){
		return findByNativeQuery(qry, null);
	}

	@SuppressWarnings("unchecked")
	public List<? extends Object> findByNativeQuery(String qry, List<Object> params){
		Query query = getEntityManager().createNativeQuery(qry);
		if (params != null && params.size() > 0) {
			for (int i = 0; i < params.size(); i++) {
				query.setParameter(i + 1, params.get(i));
			}
		}
		return query.getResultList();
	}


	public void flush(){
		getEntityManager().flush();
	}

	public E merge(E entity){
		return getEntityManager().merge(entity);
	}

	public void persist(E entity) {
		getEntityManager().persist(entity);
	}

	public void refresh(E entity) {
		getEntityManager().refresh(entity);
	}

	public void remove(E entity){
		getEntityManager().remove(entity);
	}

	public Object findSingleResult(String name){
		Query jpaQuery = getEntityManager().createNamedQuery(name);
		return ((Object) jpaQuery.getSingleResult());
	}

	public Object findSingleResult(String name, Map<String, Object> params){
		Query query = getEntityManager().createNamedQuery(name);
		for (Entry<String, Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}
		return (Object) query.getSingleResult();
	}

	public int executeUpdate(String query, Map<String, Object> params){
		Query jpaQuery = getEntityManager().createQuery(query);
		if (params != null) {
			for (Entry<String, Object> param : params.entrySet()) {
				jpaQuery.setParameter(param.getKey(), param.getValue());
			}
		}
		return jpaQuery.executeUpdate();

	}

	public int executeUpdate(String query){
		return executeUpdate(query, null);
	}

	public int executeUpdateByNamedQuery(String name){
		Query query = getEntityManager().createNamedQuery(name);
		return query.executeUpdate();
	}

	public int executeUpdateByNamedQuery(String name, Map<String, Object> params){
		Query jpaQuery = getEntityManager().createNamedQuery(name);
		if (params != null) {
			for (Entry<String, Object> param : params.entrySet()) {
				jpaQuery.setParameter(param.getKey(), param.getValue());
			}
			return jpaQuery.executeUpdate();
		}
		return executeUpdateByNamedQuery(name);
	}

	public Long findTotalPagesByFilters(StringBuilder countQuery, Map<String, Object> params){
		Query jpaCountQuery = getEntityManager().createQuery(countQuery.toString());
		if (params != null) {
			for (Entry<String, Object> param : params.entrySet()) {
				jpaCountQuery.setParameter(param.getKey(), param.getValue());
			}
		}
		return (Long) jpaCountQuery.getSingleResult();
	}

}