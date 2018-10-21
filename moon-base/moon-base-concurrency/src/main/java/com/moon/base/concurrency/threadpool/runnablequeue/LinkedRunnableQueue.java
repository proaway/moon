package com.moon.base.concurrency.threadpool.runnablequeue;

import java.util.LinkedList;

import com.moon.base.concurrency.threadpool.ThreadFactory;
import com.moon.base.concurrency.threadpool.ThreadPool;
import com.moon.base.concurrency.threadpool.denypolicy.DenyPolicy;

/**
 * 任务队列
 * 
 * @author Tobias
 * @date 2018年10月21日 下午11:57:47
 * 
 */
public class LinkedRunnableQueue implements RunnableQueue {

	/** 提交的Runnable队列的上限 */
	private final int limit;
	/** 提交的Runnable队列达上限时，调用的拒绝策略 */
	private final DenyPolicy denyPolicy;
	/** 双向循环列表，存放Runnable任务 */
	private final LinkedList<Runnable> runnableList = new LinkedList<Runnable>();

	private final ThreadPool threadPool;

	public LinkedRunnableQueue(int limit, DenyPolicy denyPolicy, ThreadPool threadPool) {
		this.limit = limit;
		this.denyPolicy = denyPolicy;
		this.threadPool = threadPool;
	}

	@Override
	public void offer(Runnable runnable) {
		synchronized (runnableList) {
			if (runnableList.size() > limit) {
				denyPolicy.reject(runnable, threadPool);
			} else {
				runnableList.addLast(runnable);
				runnableList.notifyAll();
			}
		}
	}

	@Override
	public Runnable take() throws InterruptedException {
		synchronized (runnableList) {

			while (runnableList.isEmpty()) {
				try {
					runnableList.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
					throw e;
				}
			}
			return runnableList.removeFirst();
		}
	}

	@Override
	public int size() {
		synchronized (runnableList) {
			return runnableList.size();
		}
	}

}
