package com.moon.base.concurrency.thread.close;

import java.util.concurrent.TimeUnit;

/**
 * 捕获中断信号，进行关闭线程
 * 
 * @author TobiasCui
 * @date 2018年10月18日 下午3:34:32
 * 
 */
public class FlagThreadExit {

	static class MyTask extends Thread {
		private volatile boolean closed = false;

		public void close(boolean closed) {
			System.out.println("thread will exit");
			this.closed = closed;
			this.interrupt();
		}

		@Override
		public void run() {
			while (!closed && !isInterrupted()) {
			}
			System.out.println("thread is exiting");
		}

	}

	public static void main(String[] args) throws InterruptedException {
		MyTask task = new MyTask();
		task.start();
		System.out.println("thread is working");
		TimeUnit.SECONDS.sleep(4);
		task.close(true);
	}
}
