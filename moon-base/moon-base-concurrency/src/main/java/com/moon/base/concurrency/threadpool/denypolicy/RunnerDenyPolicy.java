package com.moon.base.concurrency.threadpool.denypolicy;

import com.moon.base.concurrency.threadpool.ThreadPool;

/**
 * 拒绝策略：直接在提交者所在的线程中执行任务
 * 
 * @author Tobias
 * @date 2018年10月21日 下午11:39:55
 * 
 */
public class RunnerDenyPolicy implements DenyPolicy {

	@Override
	public void reject(Runnable runnable, ThreadPool threadPool) {
		if (!threadPool.isShutdown()) {
			runnable.run();
		}
	}

}
