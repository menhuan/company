package com.test.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 一个数据显示问题   关于map的
 * @author dell
 *
 */
public class MapBug {

	
	/**
	 * 测试案例1
	 */
	
	public static void main(String[] args) {
		new MapBug().testSet();
	}
	public void testMap(){
		List list=new ArrayList();
		Map map=new HashMap();
		/**
		 * 一个问题
		 */
		map.put("name", "fengqi");
		list.add(map);
	//	map.clear();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).toString());
		}
		
		map.put("name", "wangqi");
		list.add(map);
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).toString());
		}
	
	}
	public void testSet(){
		Set set=new HashSet();
		Map map=new HashMap();
		set.add("one");
		map.put("list1", set);
		System.out.println(map.get("list1").toString());
		set.clear();
		set.add("two");
		map.put("list1", set);
		System.out.println(map.get("list1").toString());
	}
}
