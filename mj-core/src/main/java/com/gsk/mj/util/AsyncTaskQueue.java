package com.gsk.mj.util;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ConcurrentLinkedQueue;


/**
 * 异步操作类，用于异步执行数据库操作
 *
 * @author  
 * @date 2016年6月30日 下午6:23:47 
 * @version V1.0
 */
public class AsyncTaskQueue {

	@Autowired
	ExecutorServiceManager executorServiceManager;

	private ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<Runnable>();
	private volatile boolean processingCompleted = true;
	
	public void addTask(Runnable... tasks){
		for(Runnable task:tasks){
			queue.offer(task);
		}
		if(processingCompleted){
			processingCompleted = false;
			executorServiceManager.getExecutorServiceForDB().execute(new Runnable() {
				
				@Override
				public void run() {
					executeQueueTask();
				}
			});
		}
	}
	
	private void executeQueueTask(){
		while(true){
			Runnable task = queue.poll();
			if(task == null){
				processingCompleted = true;
				break;
			}else{
				task.run();
			}
		}
	}
}
