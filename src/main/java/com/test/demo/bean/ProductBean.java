package com.test.demo.bean;

import java.util.List;
import java.util.Map;

/**
 * 生成bean
 * @author dell
 *
 */
public class ProductBean {
	 
	/**
	 * 包名
	 */
	private String packageName;
	 
	 /**
	  * bean的名字
	  */
	private String className;
	
	/**
	 * 列的内容
	 */
	private List<Map>  column;

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<Map> getColumn() {
		return column;
	}

	public void setColumn(List<Map> column) {
		this.column = column;
	}
	 
}
