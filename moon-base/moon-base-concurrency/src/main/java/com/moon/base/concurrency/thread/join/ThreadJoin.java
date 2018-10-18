package com.moon.base.concurrency.thread.join;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 线程A执行join，会使当前主线程进入等待状态（blocked）状态，一直等到线程A结束生命周期
 * 
 * @author TobiasCui
 * @date 2018年10月18日 上午9:57:52
 * 
 */
public class ThreadJoin {

	public static void main(String[] args) throws InterruptedException {
		List<Thread> threads = IntStream.range(1, 4).mapToObj(ThreadJoin::create).collect(toList());
		System.out.println(threads.size());
		threads.forEach(Thread::start);

		for (Thread thread : threads) {
			thread.join();
		}

		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + "#" + i);
			shortSleep();
		}

	}

	private static Thread create(int seq) {
		return new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + "#" + i);
				shortSleep();
			}
		}, String.valueOf(seq));
	}

	private static void shortSleep() {
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
