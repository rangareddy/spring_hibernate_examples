package com.ranga.util;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * @author Ranga Reddy
 * @version 1.0
 * @since 25 July, 2015
 */
public class MyJdbcTemplate {

	protected JdbcTemplate jdbcTemplate;	

	public MyJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);		
	}

	/**
	 * This method is used to create the data with out passing any parameter
	 * values.
	 * 
	 * @param query
	 * @return number of rows created
	 */
	public int create(String query) {
		return updateQuery(query, null);
	}

	/**
	 * This method is used to update the data with out passing any parameter
	 * values.
	 * 
	 * @param query
	 * @return number of rows update
	 */
	public int update(String sql) {
		return updateQuery(sql, null);
	}

	/**
	 * This method is used to delete the data with out passing any parameter
	 * values.
	 * 
	 * @param query
	 * @return number of rows deleted
	 */
	public int delete(String sql) {
		return updateQuery(sql, null);
	}

	/**
	 * This method is used to create the data with passing parameter values.
	 * 
	 * @param query
	 * @return number of rows created
	 */
	public int create(String sql, Object[] params) {
		return updateQuery(sql, params);
	}
	
	/**
	 * This method is used to create the data with passing named parameters.
	 * 
	 * @param query
	 * @return number of rows created
	 */
	public int create(String sql, Map<String,Object> paramMap) {
		return updateNamedQuery(sql, paramMap);
	}
	
	/**
	 * This method is used to update the data with passing named parameters.
	 * 
	 * @param query
	 * @return number of rows created
	 */
	public int update(String sql, Map<String,Object> paramMap) {
		return updateNamedQuery(sql, paramMap);
	}
	
	/**
	 * This method is used to delete the data with passing named parameters.
	 * 
	 * @param query
	 * @return number of rows created
	 */
	public int delete(String sql, Map<String,Object> paramMap) {
		return updateNamedQuery(sql, paramMap);
	}

	/** 
	 * This is the generic method to create, update, delete the data using named parameters
	 * @param sql
	 * @param paramMap
	 * @return number of rows created
	 */
	private int updateNamedQuery(String sql, Map<String, Object> paramMap) {	
		int rowsUpdated = 0;
		if(paramMap == null || paramMap.isEmpty()) {
			rowsUpdated = updateQuery(sql, null);
		} 
		return rowsUpdated;
	}

	/**
	 * This method is used to update the data with passing parameter values.
	 * 
	 * @param query
	 * @return number of rows updated
	 */
	public int update(String sql, Object[] params) {
		return updateQuery(sql, params);
	}

	/**
	 * This method is used to delete the data with passing parameter values.
	 * 
	 * @param query
	 * @return number of rows deleted
	 */
	public int delete(String sql, Object param) {
		Object[] params = new Object[] { param };
		return updateQuery(sql, params);
	}

	/**
	 * This method is used to execute multiple sql statements
	 * @param quries
	 * @return number of rows updated
	 */
	public int[] batchUpdate(List<String> quries) {		
		int[] rowsUpdated = this.jdbcTemplate.batchUpdate(quries.toArray(new String[0]));
		return rowsUpdated;
	}

	/**
	 * This is the common method for create, update, delete the data with or
	 * with out passing values.
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	private int updateQuery(String sql, Object[] params) {		
		int rowsUpdated = 0;
		if (params == null || params.length == 0) {
			rowsUpdated = this.jdbcTemplate.update(sql);
		} else {
			rowsUpdated = this.jdbcTemplate.update(sql, params);
		}
		return rowsUpdated;
	}

	/**
	 * This method executes the query.
	 * 
	 * @param sql
	 */
	public void query(String sql) {
		this.jdbcTemplate.queryForObject(sql, Integer.class);
	}

	/**
	 * This method is used to get the list of values with the help of row mapper
	 * 
	 * @param sql
	 * @param mapper
	 * @return list of values
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getObjectList(String sql, RowMapper<T> mapper) {
		List<T> resutls = Collections.EMPTY_LIST;
		resutls = this.jdbcTemplate.query(sql, mapper);
		return resutls;
	}

	/**
	 * This method is used to get the list of values with max rows
	 * 
	 * @param sql
	 * @param mapper
	 * @return list of values
	 */
	public <T> List<T> getObjectList(String sql, Object[] params,
			RowMapper<T> mapper, int maxRows) {
		List<T> resutls = null;		
		this.jdbcTemplate.setMaxRows(maxRows);
		resutls = this.jdbcTemplate.query(sql, params, mapper);
		return resutls;
	}

	/**
	 * This method is used for getting the Object.
	 * 
	 * @param sql
	 * @param params
	 * @param mapper
	 * @return the object
	 */
	public <T> T getObject(String sql, Object[] params, RowMapper<T> mapper) {
		T object = null;
		object = this.jdbcTemplate.queryForObject(sql, params, mapper);
		return object;
	}

	/**
	 * This is the generic method for getting the Object like Integer, Float,
	 * Double etc
	 * 
	 * @param sql
	 * @param params
	 * @param claz
	 * @return
	 */

	public <T> T getObject(String sql, Class<T> claz) {
		return queryForObject(sql, null, claz);
	}

	/**
	 * This is the generic method for getting the Object like Integer, Float,
	 * Double etc
	 * 
	 * @param sql
	 * @param params
	 * @param claz
	 * @return
	 */
	private <T> T queryForObject(String sql, Object[] params, Class<T> claz) {		
		T object = null;
		if (params == null || params.length == 0) {
			object = this.jdbcTemplate.queryForObject(sql, claz);
		} else {
			object = this.jdbcTemplate.queryForObject(sql, params, claz);
		}
		return object;
	}

	/**
	 * 
	 * @param sql
	 * @param requiredClazzType
	 * @param params
	 * @return
	 */
	public <T> T getObject(String sql, Class<T> claz, Object[] params) {
		T object = null;
		object = this.jdbcTemplate.queryForObject(sql, params, claz);
		return object;
	}
}