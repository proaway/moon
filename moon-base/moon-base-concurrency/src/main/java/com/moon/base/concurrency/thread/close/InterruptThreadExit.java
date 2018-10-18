package com.moon.base.concurrency.thread.close;

import java.util.concurrent.TimeUnit;

/**
 * 捕获中断信号，进行关闭线程
 * 
 * @author TobiasCui
 * @date 2018年10月18日 下午3:34:32
 * 
 */
public class InterruptThreadExit {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread() {
			@Override
			public void run() {
				while (!isInterrupted()) {
				}
				System.out.println("thread is exiting");
			}
		};

		thread.start();
		System.out.println("thread is working");
		TimeUnit.SECONDS.sleep(4);
		System.out.println("thread will exit");
		thread.interrupt();
		System.out.println("thread exited");
	}
}
