package com.test.demo.dao;

import java.util.List;
import java.util.Map;

import com.test.demo.bean.LotteryDataTodayBean;
import com.test.demo.bean.LotteryNumSortBean;



/**
 * 数据库接口
 * @author dell
 *
 */
public interface LotterDataDao {

	
	/**
	 * 保存数据到数据库中 
	 * @param map
	 * @return
	 */
	public Integer saveLotterData(Map map) throws Exception; 
	
	/**
	 * 根据条件查询需要的信息
	 * @param map
	 * @return
	 */
	public List<LotteryDataTodayBean>  getLotterData(Map map) throws Exception;
	
	/**
	 * 保存排序号的数据
	 * @throws Exception
	 */
	public void saveLotterNumSort(LotteryNumSortBean bean) throws Exception;
	
}
