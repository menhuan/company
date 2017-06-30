package com.test.demo.manage.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.base.BaseCofig;
import com.test.demo.manage.bean.LotteryDataTodayBean;
import com.test.demo.manage.bean.LotteryNumSortBean;
import com.test.demo.manage.dao.LotterDataDao;
import com.test.demo.manage.service.LotterDataService;
import com.test.demo.util.RestHttpClient;

import okhttp3.Request.Builder;

/**
 * 彩票数据实现service
 * @author dell
 *
 */
@Service
public class LotterDataServiceImpl  implements LotterDataService {

	/**
	 * 注入dao
	 */
	@Autowired
	private LotterDataDao  lotterDataDao;
	
	/**
	 * 查询出彩票数据
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> getLotterData() {
		RestHttpClient  rest=new RestHttpClient();
		LinkedHashMap  map=new LinkedHashMap<>();
		List list=new ArrayList<Map>();
		try {
			map=(LinkedHashMap) rest.doGetMap("http://f.apiplus.net/cqssc-1.json");
			list=(List<Map>) map.get("data");	
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 目的： 将彩票数据保存到数据库中
	 * 1. 首先根据map中的数据查一下是否有重复的数据
	 * 2. 没有重复数据 则插入 有重复数据那么不插入重新获取
	 * @throws Exception 
	 */
	@Override
	public Integer saveLotterData(List<Map> map) throws Exception {
		
		Integer num=0;
		for(Map data:map){
			String timeStmap= ObjectUtils.toString(data.get("opentimestamp")) ;
			
			if(timeStmap!=""){
				//插入之前需要查询下
				List<LotteryDataTodayBean> bean=lotterDataDao.getLotterData(data);
				if(bean==null || bean.size()==0){
					num=lotterDataDao.saveLotterData(data);
				}
			}
		}
		return num;
	}

	/**
	 * 排序数字
	 * 1首先获得需要查询的组数 的数据
	 * 2 然后根据进行比对记录各个的次数  并且按照0-9顺序记录
	 * 3 按照进行排序 从小到大的殊勋
	 * @throws Exception 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void sortNum() throws Exception {
		
		Map map=new HashMap();
		map.put("group",BaseCofig.LOTTER_GROUP_NUM );
		List<LotteryDataTodayBean> list=lotterDataDao.getLotterData(map);
		
		//初始化 刚开始的次数为0 
		int  num0=0;
		int  num1=0;
		int  num2=0;
		int  num3=0;
		int  num4=0;
		int  num5=0;
		int  num6=0;
		int  num7=0;
		int  num8=0;
		int  num9=0;
		
		if(list.size()>0){
			for(LotteryDataTodayBean bean:list){
				String openCode=bean.getOpenCode();
				String[] codes=openCode.split(",");
				for(int index=0; index <= codes.length;index++){
					if(num0==Integer.parseInt(codes[0])){
						num0+=1;
					}
					if(num1==Integer.parseInt(codes[0])){
						num1+=1;
					}
					if(num2==Integer.parseInt(codes[0])){
						num2+=1;
					}
					if(num3==Integer.parseInt(codes[0])){
						num3+=1;
					}
					if(num4==Integer.parseInt(codes[0])){
						num4+=1;
					}
					if(num5==Integer.parseInt(codes[0])){
						num5+=1;
					}
					if(num6==Integer.parseInt(codes[0])){
						num6+=1;
					}
					if(num7==Integer.parseInt(codes[0])){
						num7+=1;
					}
					if(num8==Integer.parseInt(codes[0])){
						num8+=1;
					}
					if(num9==Integer.parseInt(codes[0])){
						num9+=1;
					}
				}
			}
		}
		
		List listSort=new ArrayList<Integer>();
		listSort.add(num0);
		listSort.add(num1);
		listSort.add(num2);
		listSort.add(num3);
		listSort.add(num4);
		listSort.add(num5);
		listSort.add(num6);
		listSort.add(num7);
		listSort.add(num8);
		listSort.add(num9);
		Collections.sort(listSort);
		
		StringBuilder builder=new StringBuilder(); 
		for(int index=0;index<listSort.size();index++){
			builder.append(listSort.get(index).toString()+",");
		}
		String  lotteryNumSort =builder.substring(0, builder.length()-1);
	
		StringBuilder lotterNumCount=new StringBuilder();
		lotterNumCount.append(num0+","+num1+","+num2+","+num3+","+num4+","+
		","+num5+","+num6+","+num7+","+num8+","+num9);
		
		LotteryNumSortBean  bean=new LotteryNumSortBean();
		bean.setLastExpert(list.get(0).getExpect());
		bean.setLastOpenTime(list.get(0).getOpenTime());
		bean.setLastOpenTimeStmap(list.get(0).getOpenTimeStamp());
		bean.setLotterNumCount(lotterNumCount.toString());
		bean.setSomeGroupNum(BaseCofig.LOTTER_GROUP_NUM);
		bean.setLotteryNumSort(lotteryNumSort);
		
		lotterDataDao.saveLotterNumSort(bean);
	}
	

}
