package com.moon.base.concurrency.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {
	private static ThreadLocal<Byte[]> threadLocal = new ThreadLocal<Byte[]>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newCachedThreadPool();

		executor.submit(() -> {
			for (int i = 0;; i++) {
				threadLocal.set(new Byte[1024 * 1024]);
				Byte[] string = threadLocal.get();
				System.out.println(string);
			}
		});

		executor.shutdown();
	}

}
