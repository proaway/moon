package com.moon.base.concurrency.threadpool;

/**
 * 线程池接口
 * 
 * @author Tobias
 * @date 2018年10月21日 下午11:18:52
 * 
 */
public interface ThreadPool {

	/**
	 * 提交任务到线程池
	 * 
	 * @author Tobias
	 * @date 2018年10月21日 下午11:19:51
	 * 
	 * @param runnable
	 */
	void execute(Runnable runnable);

	/**
	 * 关闭线程池
	 * 
	 * @author Tobias
	 * @date 2018年10月21日 下午11:20:34
	 * 
	 */
	void shutdown();

	/**
	 * 获取线程池的初始线程数
	 * 
	 * @author Tobias
	 * @date 2018年10月21日 下午11:20:52
	 * 
	 */
	int getInitSize();

	/**
	 * 获取线程池的最大线程数
	 * 
	 * @author Tobias
	 * @date 2018年10月21日 下午11:21:07
	 * 
	 */
	int getMaxSize();

	/**
	 * 获取线程池的核心线程数
	 * 
	 * @author Tobias
	 * @date 2018年10月21日 下午11:21:46
	 * 
	 */
	int getCoreSize();

	/**
	 * 获取线程池中，用于缓存任务队列的大小
	 * 
	 * @author Tobias
	 * @date 2018年10月21日 下午11:22:50
	 * 
	 * @return
	 */
	int getQueueSize();

	/**
	 * 获取线程池的活跃线程数
	 * 
	 * @author Tobias
	 * @date 2018年10月21日 下午11:23:31
	 * 
	 * @return
	 */
	int getActiveSize();

	/**
	 * 查看线程池是否已经被shutdown
	 * 
	 * @author Tobias
	 * @date 2018年10月21日 下午11:24:11
	 * 
	 * @return
	 */
	boolean isShutdown();

}
