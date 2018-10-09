package com.moon.base.concurrency.demo;

/**
 * run()
 * 
 * @author TobiasCui
 * @date 2018年10月8日 下午4:54:08
 * 
 */
public class MyRunnable implements Runnable {
	private int i = 0;

	public MyRunnable(int i) {
		this.i = i;
	}

	@Override
	public void run() {
		System.out.println(i);
	}

}
