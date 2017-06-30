package com.test.demo.task;

import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import com.test.demo.manage.job.LotterDataJob;

/**
 * 任务service
 * @author dell
 *
 */
@Component("task")
public class Task {

	
	private TaskExecutor task;
	
	
	public Task(TaskExecutor task){
		this.task=task;
	}
	
	/**
	 * 执行任务
	 */
	public void performTask(){
		
		/**
		 * 写死了 job  如果多的话需要 写成别的方式  代理的方式 或者解析类的方式 
		 */
		task.execute(new LotterDataJob());
		
	}
}
