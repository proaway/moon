package com.moon.base.concurrency.threadpool;

public class DefaultThreadFactory implements ThreadFactory {

	@Override
	public Thread createThread(Runnable runnable) {
		return new Thread();
	}

}
