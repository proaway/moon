package com.moon.base.concurrency.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * 进入阻塞状态的线程，调用interrupt方法，会立即打断阻塞，就会抛出interruptException的异常，但不会使线程结束。
 * 
 * @author Tobias
 *
 */
public class ThreadIsInterrupt {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				while (true) {

				}
			}
		};
		t1.start();
		TimeUnit.MILLISECONDS.sleep(2);
		System.out.println(Thread.currentThread().getId() + ":" + t1.isInterrupted());
		t1.interrupt();
		System.out.println(Thread.currentThread().getId() + ":" + t1.isInterrupted());
		TimeUnit.SECONDS.sleep(10);
	}
}
