package com.moon.base.concurrency.juc.threadsyn;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch是一个同步工具类，它允许一个或多个线程一直等待，直到其他线程的操作执行完后（线程不一定结束）再执行。
 * CountDownLatch为例，内部包含一个计数器，一开始初始化为一个整数（事件个数），发生一个事件后，调用countDown方法，计数器减1，await用于等待计数器为0后继续执行当前线程；
 * 
 * @author TobiasCui
 * @date 2018年12月7日 下午12:31:58
 * 
 */
public class CountDownLatchTest {
	public static void main(String[] args) {
		int count = 10;
		CountDownLatch latch = new CountDownLatch(count);

		ExecutorService es = Executors.newFixedThreadPool(count);
		for (int i = 0; i < count; i++) {
			es.execute(new TaskTest(latch, (i + 1) * 1000));
		}

		try {
			System.out.println(Thread.currentThread().getName() + "等待:" + System.nanoTime());
			latch.await();
			System.out.println(Thread.currentThread().getName() + "继续执行:" + System.nanoTime());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			es.shutdown();
		}
	}
}

class TaskTest implements Runnable {
	private CountDownLatch latch;
	private int sleepTime;

	public TaskTest(CountDownLatch latch, int sleepTime) {
		this.latch = latch;
		this.sleepTime = sleepTime;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + "开始:" + System.nanoTime());
			TimeUnit.MILLISECONDS.sleep(sleepTime);
			System.out.println(Thread.currentThread().getName() + "结束:" + System.nanoTime());
			latch.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
