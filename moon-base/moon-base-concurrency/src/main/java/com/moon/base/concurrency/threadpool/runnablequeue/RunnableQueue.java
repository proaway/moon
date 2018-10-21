package com.moon.base.concurrency.threadpool.runnablequeue;

/**
 * 任务队列：用于缓存提交到线程池的任务
 * 
 * @author Tobias
 * @date 2018年10月21日 下午11:25:15
 * 
 */
public interface RunnableQueue {
	/**
	 * 新任务进来时，offer到队列中
	 * 
	 * @author Tobias
	 * @date 2018年10月21日 下午11:26:07
	 * 
	 * @param runnable
	 */
	void offer(Runnable runnable);

	/**
	 * 工作线程通过take获取Runnable任务
	 * 
	 * @author Tobias
	 * @date 2018年10月21日 下午11:26:48
	 * 
	 */
	Runnable take() throws InterruptedException;

	/**
	 * 获取任务队列中，任务的数量
	 * 
	 * @author Tobias
	 * @date 2018年10月21日 下午11:27:39
	 * 
	 * @return
	 */
	int size();
}
