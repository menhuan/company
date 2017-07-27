package com.test.demo.manage.bean;

/**
 * 彩票中间今日数据 会有一部分数据延迟
 * @author dell
 * ssssssss
 *
 */
public class LotteryDataTodayBean {

	/**
	 *自增id 
	 */
	private Integer 	 id;
	
	/**
	 * 开奖期数
	 */
	private String   expect;
	
	/**
	 * 开奖号码
	 */
	private String   openCode;
	
	/**
	 * 开奖时间
	 */
	private String   openTime;
	
	/**
	 * 开奖时间戳
	 */
	private Integer  openTimeStamp;
	
	/**
	 * 创建时间
	 */
	private Integer   createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExpect() {
		return expect;
	}

	public void setExpect(String expect) {
		this.expect = expect;
	}

	public String getOpenCode() {
		return openCode;
	}

	public void setOpenCode(String openCode) {
		this.openCode = openCode;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public Integer getOpenTimeStamp() {
		return openTimeStamp;
	}

	public void setOpenTimeStamp(Integer openTimeStamp) {
		this.openTimeStamp = openTimeStamp;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	
	
}
