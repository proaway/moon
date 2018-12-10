package com.moon.base.concurrency.juc.threadsyn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 控制同时执行某个指定操作的数量，常用于实现资源池，如数据库连接池，线程池...
 * 以Semaphore为例，其内部维护一组资源，可以通过构造函数指定数目，其它线程在执行的时候，可以通过acquire方法获取资源，有的话，继续执行（使用结束后释放资源），没有资源的话将阻塞直到有其它线程调用release方法释放资源；
 * 
 * @author TobiasCui
 * @date 2018年12月7日 下午1:41:03
 * 
 */
public class SemaphoreTest {
	public static void main(String[] args) {
		int count = 10;
		Semaphore semaphore = new Semaphore(3, true);
		ExecutorService es = Executors.newFixedThreadPool(count);

		for (int i = 0; i < count; i++) {
			es.execute(new ConsumeResourceTask(semaphore, (i + 1) * 1000));
		}
	}
}

class ConsumeResourceTask implements Runnable {
	private Semaphore semaphore;
	private int sleepTime;

	public ConsumeResourceTask(Semaphore semaphore, int sleepTime) {
		this.semaphore = semaphore;
		this.sleepTime = sleepTime;
	}

	@Override
	public void run() {
		try {
			// 获取资源
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName() + "开始占用一个资源:" + System.nanoTime());
			TimeUnit.MILLISECONDS.sleep(sleepTime);
			System.out.println(Thread.currentThread().getName() + "结束释放资源:" + System.nanoTime());
			// 释放资源
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
