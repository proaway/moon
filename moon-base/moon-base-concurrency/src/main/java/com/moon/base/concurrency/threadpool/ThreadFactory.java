package com.moon.base.concurrency.threadpool;

/**
 * 创建线程的工厂
 * 
 * @author Tobias
 * @date 2018年10月21日 下午11:18:52
 * 
 */
public interface ThreadFactory {
	/**
	 * 创建线程
	 * 
	 * @author Tobias
	 * @date 2018年10月21日 下午11:29:19
	 * 
	 * @param runnable
	 * @return
	 */
	Thread createThread(Runnable runnable);

}
