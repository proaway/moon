package com.moon.base.concurrency.demo;

/**
 * Thread() <br/>
 * Thread(Runnable) <br/>
 * Thread(Runnable, String) <br/>
 * Thread(Runnable, AccessControlContext) <br/>
 * Thread(String) <br/>
 * Thread(ThreadGroup, Runnable) <br/>
 * Thread(ThreadGroup, Runnable, String) <br/>
 * Thread(ThreadGroup, Runnable, String, long) <br/>
 * Thread(ThreadGroup, String)
 * 
 * @author TobiasCui
 * @date 2018年10月8日 下午4:50:16
 * 
 */
public class MyThread extends Thread {
	private int i = 10;

	@Override
	public void run() {
		super.run();
		--i;
		System.out.println(this.currentThread().getName() + ":" + i);
	}

}
