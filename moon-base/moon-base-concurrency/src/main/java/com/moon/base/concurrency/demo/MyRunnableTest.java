package com.moon.base.concurrency.demo;

public class MyRunnableTest {

	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			MyRunnable runnable = new MyRunnable(i);
			runnable.run();
		}
	}
}
