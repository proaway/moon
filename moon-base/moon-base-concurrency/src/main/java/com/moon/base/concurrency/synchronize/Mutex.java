package com.moon.base.concurrency.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * synchronized关键字提供一种互斥机制：monitor锁，对应monitor enter和monitor exit
 * 
 * @author TobiasCui
 * @date 2018年10月18日 下午6:00:43
 * 
 */
public class Mutex {
	private final static Object MUTEX = new Object();

	public void accessResource() {
		synchronized (MUTEX) {
			try {
				System.out.println("Mutex synchronized code block:" + System.currentTimeMillis());
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		final Mutex mutex = new Mutex();
		for (int i = 0; i < 5; i++) {
			new Thread() {
				@Override
				public void run() {
					mutex.accessResource();
				}
			}.start();
		}
	}

}
