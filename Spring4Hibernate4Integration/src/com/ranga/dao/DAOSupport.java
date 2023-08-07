/**
 * 
 */
package com.ranga.dao;

import java.util.List;

/**
 * DAOSupport.java
 * @author ranga
 * Mar 22, 2014
 */
public interface DAOSupport<T> {
	public long create(T object);
	public T fetchByid(long id);
	public List<T> fetchAll();
	public T fetchByName(String name);
	public T update(T object);
	public void delete(long id);
}