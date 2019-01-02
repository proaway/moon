package com.moon.base.concurrency.juc.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newCachedThreadPool();
		Future<String> future = executor.submit(() -> {
			System.out.println("task is starting");
			Thread.sleep(10000);
			return "return task";
		});

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("do something else");
		try {
			String string = future.get();
			System.out.println(string);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		executor.shutdown();

	}

}
