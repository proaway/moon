package com.moon.base.concurrency.thread;

import java.util.stream.IntStream;

/**
 * yield只是一个提醒：愿意放弃cpu资源，cpu不紧张时会忽略这个提醒
 * 
 * @author Tobias
 *
 */
public class ThreadYield {

	public static void main(String[] args) {
		IntStream.range(0, 20).mapToObj(ThreadYield::create).forEach(Thread::start);
	}

	private static Thread create(int index) {
		return new Thread(() -> {
			if (index == 10) {
				Thread.yield();
			}
			System.out.println(index);
		});
	}

}
