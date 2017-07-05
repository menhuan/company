package com.test.demo.mybaits.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.mybaits.dao.ProductTableDao;

/**
 * 生成javaBean实体类
 * @author dell
 *
 */
@Service
public class ProductTableService {

	/**
	 * 查询表名
	 */
//	String  tableSql="select table_name from information_schema.tables where TABLE_SCHEMA='com_study'";
	
	/**
	 * 查询表中列的内容
	 */
//	String colunSql="select * from information_schema.COLUMNS where table_name='cz_lottery_data_today'";
	
		@Autowired
		private ProductTableDao  productTableDao;
		
		/**
		 * 存放bean的路径
		 */
		private static final String PATH=System.getProperty("user.dir")+"/src/main/java/com/test/demo/bean/";
	
		/**
		 * 引入的包名
		 */
		private static final String PACKAGENAME="package com.test.demo.bean"+"/n";
		
		/**
		 * 字段类型
		 */
		private static final String BEANTYPE="  private  " ;
		
		/**
		 *分号 
		 */
		private static final String SEMICOLON=";";
		
		/**
		 * 空格
		 */
		private static final String SPACE="  ";
		
		/**
		 * 换两行
		 */
		private static final String  LINE="/n/n";
		
		/**
		 * 类类型
		 */
		private static final String CLASSTYPE="public class ";
		
		/**
		 * 生产bean
		 */
		@SuppressWarnings({ "rawtypes", "unchecked", "deprecation", "unused" })
		public void ProduceBean(){
			
			StringBuffer  buffer=new StringBuffer();
			
			buffer.append(PACKAGENAME);
			
			Map map= new  HashMap();
			map.put("tableSchema", "com_study");
			
			List<Map> list=productTableDao.selectTable(map);
			
			for(Map table:list){
				
				String className= this.trance(ObjectUtils.toString(
						table.get("tableName")), true);
				
				buffer.append(CLASSTYPE +className+"{" +LINE);
				
				List<Map> column=productTableDao.selectColum(table);
				
				for(Map columnMap:column){
					
					String columnName=this.trance(ObjectUtils.toString(columnMap.get("COLUMNNAME")),false);
					String dateType=ObjectUtils.toString(columnMap.get("DATA_TYPE"));
					String columnComment=ObjectUtils.toString(columnMap.get("COLUMN_COMMENT"));
					buffer.append(BEANTYPE+dateType+ columnName +SEMICOLON);
					
				}
				
				File file=new File(PATH+className+".java");
				if(!file.exists()){
		             try {
						file.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
		         }
				
			 try {
				PrintWriter  pw=new PrintWriter(file);
				pw.write(buffer.toString());
				pw.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				
			}
			
			
		}
		
		/**
		 * 将数据库和表名称坐下转换
		 * @param content 需要转换的内容
		 * @param isDelete  是否删除前面的统一命名字段  如果没有前面的统一字段命名 那么默认是不删除false
		 * @return
		 */
	    public String trance(String content,boolean isDelete){
	    	StringBuffer  buffer=new StringBuffer();
	    	String[] contents=content.split("_");
	    	int index=0;
	    	
	    	if(isDelete){
	    		index+=1;
	    		for(;index<contents.length;index++){
	    			Character.isUpperCase( contents[index].charAt(0)); 
	    			buffer.append(contents[index]);
	    		}
	    	}else{
	    		for(;index<contents.length;index++){
	    			Character.isUpperCase( contents[index].charAt(0)); 
	    			buffer.append(contents[index]);
	    		}
	    	}
	    	
	    	return  buffer.append("Bean").toString();
	    	
	    }
	    
	    /**
	     * 转换类型  
	     * @param  需要转换的类型
	     * @return
	     */
	    public String tranceType(String type){

	    	if(type.contains("int")){
	    		return "Integer";
	    	}else	if(type.contains("float")|| type.contains("double") || type.contains("decimal")){
	    		return "BigDecimal" ;
	    	}else {
	    		return "String" +SPACE;
	    	}
	    }

}
