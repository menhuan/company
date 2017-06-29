package com.test.demo.util;

import java.io.IOException;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * http工具类
 * @author dell
 *
 */
public class RestHttpClient {

	/**
	 * 客户端
	 */
	OkHttpClient client=new OkHttpClient();

//	public static final 
	
	/**
	 * 设置传输模式 string
	 */
	public static final MediaType JSON=
			MediaType.parse("application/json;charset=utf-8");
	/**
	 * get方法
	 * @return
	 * @throws IOException 
	 */
	public Object doGet(String url) throws IOException  {
		
		Request request=new  Request.Builder()
				.url(url).build();
		
		try(Response response=client.newCall(request)
					.execute()){
			return JSONObject.toJSON(response.body().string());
					}
	}
	
	/**
	 * post方法 使用Ｓtring的方式传输数据　如果数据较大应该使用流的方式　
	 * @param url  网址
	 * @param json  传输的数据给url
	 * @return
	 * @throws IOException 
	 */
	public Object doPostＳString(String url,String json) throws IOException {
		
		RequestBody requestBody=RequestBody.create(JSON, json);
		Request request=new Request.Builder()
				.url(url).post(requestBody).build();
		try(Response response=client.newCall(request).execute()){
			return JSONObject.toJSON(response.body().string());
		}
		
	}
	
	/**
	 * 流的方式提交数据post
	 * @return
	 */
	public Object doPostStream(){
		return "";
	}
	
	@Test
	public void test1(){
		String string;
		try {
			string = new RestHttpClient().doGet("http://f.apiplus.net/cqssc.json").toString();
			System.out.println(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
