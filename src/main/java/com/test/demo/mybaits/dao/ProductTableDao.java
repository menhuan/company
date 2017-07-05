package com.test.demo.mybaits.dao;

import java.util.List;
import java.util.Map;

/**
 * 产生dao
 * @author dell
 *
 */
public interface ProductTableDao {

	
	/**
	 * 查询数据库相关的内容
	 * @param map
	 * @return
	 */
	public List<Map> selectTable(Map map);
	
	/**
	 * 查询表的内容
	 * @param map
	 * @return
	 */
	public List<Map> selectColum(Map map);
}
