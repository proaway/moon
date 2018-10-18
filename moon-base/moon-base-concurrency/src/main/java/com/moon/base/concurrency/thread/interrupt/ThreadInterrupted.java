package com.moon.base.concurrency.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * interrupted是个静态方法 <br>
 * 第一次调用interrupted方法会返回true，并且立即擦除interrupt标识，以后再次调用该方法，都返回false
 * 
 * @author Tobias
 *
 */
public class ThreadInterrupted {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				while (true) {
					System.out.println(Thread.interrupted());
				}
			}
		};
		t1.setDaemon(true);
		t1.start();
		TimeUnit.MILLISECONDS.sleep(2);
		t1.interrupt();
	}
}
