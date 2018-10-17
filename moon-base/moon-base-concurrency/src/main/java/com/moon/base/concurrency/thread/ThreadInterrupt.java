package com.moon.base.concurrency.thread;

import java.util.concurrent.TimeUnit;

/**
 * interrupt方法，是在线程内部打一个interrupt flag为true的标识，如果被线程被中断（打破阻塞）会清除flag标识<br>
 * 进入阻塞状态的线程，调用interrupt方法，会立即打断阻塞，同时清除flag标识，就会抛出interruptException的异常，但不会使线程结束。
 * 
 * @author Tobias
 *
 */
public class ThreadInterrupt {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					TimeUnit.MINUTES.sleep(1);
				} catch (InterruptedException e) {
					System.out.println("be interrupted");
				}
			}
		};
		t1.start();
		System.out.println(Thread.currentThread().getId() + ":" + t1.isInterrupted());
		t1.interrupt();
		TimeUnit.SECONDS.sleep(3);
		System.out.println(Thread.currentThread().getId() + ":" + t1.isInterrupted());
	}
}
