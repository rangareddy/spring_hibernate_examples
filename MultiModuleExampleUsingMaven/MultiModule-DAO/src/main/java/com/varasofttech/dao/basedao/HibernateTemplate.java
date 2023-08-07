package com.varasofttech.dao.basedao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Ranga Reddy
 * @version 1.0
 * @date Jan 25 2015	
 */
 
@Repository
public class HibernateTemplate {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public HibernateTemplate() {
		
	}
	
	protected Session getCurrentSession(){
	    return sessionFactory.getCurrentSession();
	}

	public <T> Serializable save(final T entity) {
		return getCurrentSession().save(entity);			
	}
	
	public <T> T update(final T entity) {
		getCurrentSession().update(entity);
		return entity;
	}
	
	public <T> T saveOrUpdate(final T entity) {
		getCurrentSession().saveOrUpdate(entity);
		return entity;		
	}
	
	public <T> void delete(final T entity) {
		getCurrentSession().delete(entity);
	}
	
	public <T> void delete(final Class<T> entityClass, Serializable id) {
		final T entity = get(entityClass, id);
		delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(final Class<T> entityClass, Serializable id) {
		return (T) getCurrentSession().get(entityClass, id);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T load(final Class<T> entityClass, Serializable id) {
		return (T) getCurrentSession().load(entityClass, id);
	}
	
	@SuppressWarnings("rawtypes")
	public Object getResult(final String queryName,final Map<String, Object> paramNames, final QueryType queryType) {
		List data = getResultList(queryName, paramNames, queryType);
		if(!(data.isEmpty())) {
			return data.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public List getResultList(final String queryName,final Map<String, Object> paramNames, final QueryType queryType) {
		Query query = null;
		Session session = getCurrentSession();
		if(queryType == QueryType.HibernateQuery) {
			query = session.createQuery(queryName);
		} else if(queryType == QueryType.NativeQuery) {
			query = session.createSQLQuery(queryName);
		} else if(queryType == QueryType.NamedQuery) {
			query = session.getNamedQuery(queryName);
		}
		if(paramNames != null && !paramNames.isEmpty()) {
			for(Map.Entry<String, Object> data : paramNames.entrySet()) {
				query.setParameter(data.getKey(), data.getValue());
			}
		}
		return query.list();
	}
	
}
