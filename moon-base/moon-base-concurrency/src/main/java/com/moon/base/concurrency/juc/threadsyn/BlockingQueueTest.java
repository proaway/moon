package com.moon.base.concurrency.juc.threadsyn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author TobiasCui
 * @date 2018年12月7日 下午1:41:03
 * 
 */
public class BlockingQueueTest {
	public static void main(String[] args) throws Exception {
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);
		for (int i = 0; i < 1; i++) {
			new Thread(new Producer(queue)).start();
		}
		for (int i = 0; i < 6; i++) {
			new Thread(new Consumer(queue)).start();
		}
	}
}

/**
 * 生产者
 */
class Producer implements Runnable {
	private final BlockingQueue<String> blockingQueue;

	public Producer(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	public String getProducer() {
		SimpleDateFormat dfdate = new SimpleDateFormat("HH:mm:ss");
		return dfdate.format(new Date());
	}

	@Override
	public void run() {
		while (true) {
			/** 生产blockingQueue.offer/put */
			try {
				TimeUnit.SECONDS.sleep(5L);
				String producer = getProducer();
				System.err.println(Thread.currentThread().getName() + "生产:" + producer + "-" + System.nanoTime());
				blockingQueue.put(producer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

/**
 * 消费者
 */
class Consumer implements Runnable {
	private final BlockingQueue<String> blockingQueue;

	public Consumer(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while (true) {
			/** 消费消息 */
			try {
				TimeUnit.SECONDS.sleep(1L);
				System.out.println(Thread.currentThread().getName() + "消费-准备:" + "-" + System.nanoTime());
				System.out.println(Thread.currentThread().getName() + "消费-开始:" + blockingQueue.take() + "-" + System.nanoTime());
				System.out.println(Thread.currentThread().getName() + "消费-完成:" + "-" + System.nanoTime());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}