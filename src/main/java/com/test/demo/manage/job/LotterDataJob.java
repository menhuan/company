package com.test.demo.manage.job;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.demo.manage.service.LotterDataService;

/**
 *实现彩票数据的job 
 * @author dell
 *
 */
@Component
public class LotterDataJob implements Runnable{
	
	/**
	 * 日志
	 */
	private Logger logger=org.slf4j.LoggerFactory.getLogger(LotterDataJob.class);
	
	/**
	 * 彩票service
	 */
	@Autowired
	private LotterDataService   lotterDataService; 
	
	/**
	 * 这里面写运行的内容
	 */
	@Override
	public void run() {

		logger.info("彩赚-----进入彩票数据获取-----");
		
		List list=lotterDataService.getLotterData();
		
		if(list.size()>0){
			Integer num;
			try {
				num = lotterDataService.saveLotterData(list);
				if(num<=0){
					logger.error("彩赚-----保存数据出错-----");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		logger.info("彩赚-----彩票数据获取保存结束-----");
		
	}


	
	
}
