package com.bookstore.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class JpaDAO<E> {
	private static EntityManagerFactory entityManagerFactory;
	
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		
	}

	public JpaDAO() {
		super();

	}
	
	public E create(E entity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			
			entityManager.getTransaction().begin();		
			
			entityManager.persist(entity);
			entityManager.flush();
			entityManager.refresh(entity);
			
			entityManager.getTransaction().commit();
			
			return entity;
		}
		finally {
			entityManager.close();
		}
		
	}
	
	public E update(E entity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entity = entityManager.merge(entity);
			entityManager.getTransaction().commit();
			
			return entity;
		}
		finally {
			entityManager.close();
		}
		
	}
	
	public E find(Class<E> type, Object id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			E entity  = entityManager.find(type, id);
			if(entity != null) {
				entityManager.refresh(entity);
			}
			
			return entity;
		}
		finally {
			entityManager.close();
		}
		
	}
	
	public void delete(Class<E> type, Object id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Object reference = entityManager.getReference(type, id);
			entityManager.remove(reference);
			entityManager.getTransaction().commit();
			
		}
		finally {
			entityManager.close();
		}
		
	}
	
	public List<E> findWithNamedQuery(String queryName){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.clear(); 
			Query query = entityManager.createNamedQuery(queryName);
			
			return query.getResultList();
		}
		finally {
			entityManager.close();
		}
		
	}
	
	public long countWithNamedQuery(String queryName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			Query query = entityManager.createNamedQuery(queryName);
			
			return (long) query.getSingleResult();
		}
		finally {
			entityManager.close();
		}
		
	}
	
	public List<E> findWithNamedQuery(String queryName, String paramName, Object paramValue) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			Query query = entityManager.createNamedQuery(queryName);
			query.setParameter(paramName, paramValue);
			
			return query.getResultList();
		}
		finally {
			entityManager.close();
		}
		
	}
	
	public List<E> findWithNamedQuery(String queryName, Map<String, Object> queryParameters) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			Query query = entityManager.createNamedQuery(queryName);
			Set<Entry<String, Object>> rawParameters = queryParameters.entrySet();
			
			for(Entry<String, Object> param: rawParameters) {
				query.setParameter(param.getKey(), param.getValue());
			}
			return query.getResultList();
		}
		finally {
			entityManager.close();
		}
		
		
		
	}
	
	public List<E> findWithNamedQuery(String queryName, int firstResult, int maxResults) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			Query query = entityManager.createNamedQuery(queryName);
			query.setFirstResult(firstResult);
			query.setMaxResults(maxResults);
			List<E> results = query.getResultList();
			
			return results;
		}
		finally {
			entityManager.close();
		}
		
	}
	
	public void close() {
		if(entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		
	}
	
}
