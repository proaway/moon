package com.moon.base.concurrency.threadpool.denypolicy;

import com.moon.base.concurrency.threadpool.ThreadPool;
import com.moon.base.concurrency.threadpool.exception.RunnableDenyException;

/**
 * 拒绝策略：向任务提交者抛出异常
 * 
 * @author Tobias
 * @date 2018年10月21日 下午11:34:46
 * 
 */
public class AbortDenyPolicy implements DenyPolicy {

	@Override
	public void reject(Runnable runnable, ThreadPool threadPool) {
		throw new RunnableDenyException(runnable + "will be abort.");
	}

}
