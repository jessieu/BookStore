package com.bookstore.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaDAO<E> {
	private static EntityManagerFactory entityManagerFactory;
	
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
	}

	public JpaDAO() {
	}
	
	public E create(E entity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		if (entity != null) {
			entityManager.getTransaction().begin();
			
			entityManager.persist(entity);
			entityManager.flush();
			entityManager.refresh(entity);
			
			entityManager.getTransaction().commit();
		}
		entityManager.close();
		return entity;
		
	}
	public E update(E entity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		entity = entityManager.merge(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
		return entity;
		
	}
	public E get(Class<E> type, Object id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		E entity = entityManager.find(type, id);
		if (entity != null) {
			entityManager.refresh(entity);
		}
		entityManager.close();
		return entity;
	}
	
	public E delete(Class<E> type, Object id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		E entity = entityManager.getReference(type, id);
		
		entityManager.remove(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
		return entity;
		
	}
	
	public List<E> findWithNamedQuery(String queryName){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		List<E> result = query.getResultList();
		entityManager.close();
		return result;
		
	}
	
	public List<E> findWithNamedQuery(String queryName, int firstResult, int maxResult){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		query.setFirstResult(0);
		query.setMaxResults(4);
		
		List<E> result = query.getResultList();
		entityManager.close();
		return result; 
	}
	
	public List<E> findWithNamedQuery(String queryName, String paramName, Object paramVal){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		query.setParameter(paramName, paramVal);
		List<E> result = query.getResultList();
		entityManager.close();
		return result;
		
	}
	
	public List<E> findWithNamedQuery(String queryName, Map<String, Object> parameters){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		Set<Entry<String, Object>> setParameters = parameters.entrySet();
		
		for (Entry<String, Object> entry : setParameters) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		
		List<E> result = query.getResultList();
		entityManager.close();
		return result;
		
	}
	
	public long countWithNamedQuery(String queryName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		long result = (long) query.getSingleResult();
		entityManager.close();
		return result;
	}
	
	public long countWithNamedQuery(String queryName, String paramName, Object parameters) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		query.setParameter(paramName, parameters);
		long result = (long) query.getSingleResult();
		entityManager.close();
		return result;
	}
	
	public void close() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
	}

}
