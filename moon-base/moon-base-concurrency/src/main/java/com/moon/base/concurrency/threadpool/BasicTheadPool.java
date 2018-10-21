package com.moon.base.concurrency.threadpool;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import com.moon.base.concurrency.threadpool.denypolicy.DenyPolicy;
import com.moon.base.concurrency.threadpool.denypolicy.DiscardDenyPolicy;
import com.moon.base.concurrency.threadpool.runnablequeue.LinkedRunnableQueue;
import com.moon.base.concurrency.threadpool.runnablequeue.RunnableQueue;

public class BasicTheadPool extends Thread implements ThreadPool {

	private final int initSize;
	private final int maxSize;
	private final int coreSize;
	private int activeSize;
	private final ThreadFactory threadFactory;
	private final RunnableQueue runnableQueue;
	private final Queue<InternalTask> threadQueue = new ArrayDeque<>();
	private final static DenyPolicy DEFAULT_DENY_POLICY = new DiscardDenyPolicy();
	private final static ThreadFactory DEFAULT_THREAD_FACTORY = new DefaultThreadFactory();
	private volatile boolean isShutdown = false;
	private final long keepAliveTime;
	private final TimeUnit timeUnit;

	public BasicTheadPool(int initSize, int maxSize, int coreSize, int queueSize) {
		this(initSize, maxSize, coreSize, DEFAULT_THREAD_FACTORY, queueSize, DEFAULT_DENY_POLICY, 10, TimeUnit.SECONDS);
	}

	public BasicTheadPool(int initSize, int maxSize, int coreSize, ThreadFactory threadFactory, int queueSize, DenyPolicy denyPolicy, long keepAliveTime, TimeUnit timeUnit) {
		this.initSize = initSize;
		this.maxSize = maxSize;
		this.coreSize = coreSize;
		this.threadFactory = threadFactory;
		this.runnableQueue = new LinkedRunnableQueue(queueSize, denyPolicy, this);
		this.keepAliveTime = keepAliveTime;
		this.timeUnit = timeUnit;
		this.init();
	}

	private void init() {
		start();
		for (int i = 0; i < initSize; i++) {
			newThread();
		}
	}

	private void newThread() {
		// TODO
	}

	@Override
	public void execute(Runnable runnable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getInitSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCoreSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getQueueSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getActiveSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isShutdown() {
		// TODO Auto-generated method stub
		return false;
	}

}
