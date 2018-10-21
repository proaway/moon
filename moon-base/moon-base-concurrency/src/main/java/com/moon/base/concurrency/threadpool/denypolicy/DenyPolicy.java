package com.moon.base.concurrency.threadpool.denypolicy;

import com.moon.base.concurrency.threadpool.ThreadPool;

/**
 * Queue中runnable到上限时的拒绝策略
 * 
 * @author Tobias
 * @date 2018年10月21日 下午11:18:52
 * 
 */
public interface DenyPolicy {
	/**
	 * 拒绝策略
	 * 
	 * @author Tobias
	 * @date 2018年10月21日 下午11:31:07
	 * 
	 * @param runnable
	 * @param threadPool
	 */
	void reject(Runnable runnable, ThreadPool threadPool);
}
