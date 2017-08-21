package com.test.demo.bean;

/**
 * 中奖号码排序
 * @author dell
 *
 */
public class LotteryNumSortBean {
	
	 /**
	  * 自增id 
	  */
	 private Integer id ;
	 
	 /**
	  * 最新的开奖期数
	  */
	 private String lastExpert ;
	 
	 /**
	  * 最新的开奖时间
	  */
	 private String lastOpenTime;
	 
	 /**
	  * 最新的开始时间戳
	  */
	 private Integer lastOpenTimeStmap;
	 
	 /**
	  * 彩票中奖次数排序数字
	  */
	 private String lotteryNumSort ;
	 
	 /**
	  * 从0到9 排序的次数
	  */
	 private String lotterNumCount;
	 
	 /**
	  * 几组数据弄得次数
	  */
	 private Integer  someGroupNum ;
	 
	 /**
	  * 创建时间
	  */
	 private Integer createTime ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastExpert() {
		return lastExpert;
	}

	public void setLastExpert(String lastExpert) {
		this.lastExpert = lastExpert;
	}

	public String getLastOpenTime() {
		return lastOpenTime;
	}

	public void setLastOpenTime(String lastOpenTime) {
		this.lastOpenTime = lastOpenTime;
	}

	public Integer getLastOpenTimeStmap() {
		return lastOpenTimeStmap;
	}

	public void setLastOpenTimeStmap(Integer lastOpenTimeStmap) {
		this.lastOpenTimeStmap = lastOpenTimeStmap;
	}

	public String getLotteryNumSort() {
		return lotteryNumSort;
	}

	public void setLotteryNumSort(String lotteryNumSort) {
		this.lotteryNumSort = lotteryNumSort;
	}

	public Integer getSomeGroupNum() {
		return someGroupNum;
	}

	public void setSomeGroupNum(Integer someGroupNum) {
		this.someGroupNum = someGroupNum;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	public String getLotterNumCount() {
		return lotterNumCount;
	}

	public void setLotterNumCount(String lotterNumCount) {
		this.lotterNumCount = lotterNumCount;
	}
	 
}
