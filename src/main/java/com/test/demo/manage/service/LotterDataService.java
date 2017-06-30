package com.test.demo.manage.service;

import java.util.List;
import java.util.Map;

/**
 * 彩票数据service接口
 * 1 得有一个查询 到数据的接口方法
 * 2保存到数据库的方法
 * @author dell
 *
 */
public interface LotterDataService {

	
	/**
	 * 查询到彩票数据 
	 * @return
	 */
	public List<Map> getLotterData();
	 
	
	/**
	 * 保存数据到数据库中 
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	public Integer saveLotterData(List<Map> map) throws Exception; 
	
	/**
	 * 排序数字
	 */
	public void  sortNum() throws Exception;
	
}
