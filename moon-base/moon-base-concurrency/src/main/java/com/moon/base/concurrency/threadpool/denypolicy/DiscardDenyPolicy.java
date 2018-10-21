package com.moon.base.concurrency.threadpool.denypolicy;

import com.moon.base.concurrency.threadpool.ThreadPool;

/**
 * 拒绝策略：直接丢弃
 * 
 * @author Tobias
 * @date 2018年10月21日 下午11:34:28
 * 
 */
public class DiscardDenyPolicy implements DenyPolicy {

	@Override
	public void reject(Runnable runnable, ThreadPool threadPool) {

	}

}
