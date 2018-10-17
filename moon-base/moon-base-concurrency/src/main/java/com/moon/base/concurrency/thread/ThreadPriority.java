package com.moon.base.concurrency.thread;

/**
 * yield只是一个提醒：愿意放弃cpu资源，cpu不紧张时会忽略这个提醒
 * 
 * @author Tobias
 *
 */
public class ThreadPriority {

	public static void main(String[] args) {
		Thread t0 = new Thread(() -> {
			while (true) {
				System.out.println("t0");
			}
		});

		Thread t1 = new Thread(() -> {
			while (true) {
				System.out.println("t1");
			}
		});

		t0.setPriority(1);
		t1.setPriority(10);
		t0.start();
		t1.start();
	}
}
