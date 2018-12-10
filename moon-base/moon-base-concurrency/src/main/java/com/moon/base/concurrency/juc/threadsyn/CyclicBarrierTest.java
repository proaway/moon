package com.moon.base.concurrency.juc.threadsyn;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 栅栏用于等待其它线程，且会阻塞自己当前线程； 所有线程必须同时到达栅栏位置后，才能继续执行；
 * 
 * @author TobiasCui
 * @date 2018年12月7日 下午1:41:03
 * 
 */
public class CyclicBarrierTest {
	public static void main(String[] args) {
		int count = 3;
		CyclicBarrier semaphore = new CyclicBarrier(count, new Runnable() {

			@Override
			public void run() {
				try {
					System.err.println(Thread.currentThread().getName() + " 所有线程到达栅栏处，优先执行的任务:" + System.nanoTime());
					TimeUnit.MILLISECONDS.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		ExecutorService es = Executors.newFixedThreadPool(count);

		for (int i = 0; i < count; i++) {
			es.execute(new CyclicBarrierTask(semaphore, (i + 1) * 1000));
		}
	}
}

class CyclicBarrierTask implements Runnable {
	private CyclicBarrier cyclicBarrier;
	private int sleepTime;

	public CyclicBarrierTask(CyclicBarrier cyclicBarrier, int sleepTime) {
		this.cyclicBarrier = cyclicBarrier;
		this.sleepTime = sleepTime;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + "开始:" + System.nanoTime());
			TimeUnit.MILLISECONDS.sleep(sleepTime);
			System.out.println(Thread.currentThread().getName() + "到达栅栏处等待其他线程到达:" + System.nanoTime());
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " 所有线程到达栅栏处，继续执行各自线程任务:" + System.nanoTime());

		try {
			TimeUnit.MILLISECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + "结束:" + System.nanoTime());
	}
}
