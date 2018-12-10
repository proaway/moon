package com.moon.base.concurrency.juc.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 〈功能简述〉<br>
 * 〈原子性操作〉
 *
 * @author TobiasCui
 * @create 2018/11/19
 * @since 1.0.0
 */
public class AtomicIntegerExample {
    public static int clientTotal=50000;
    public static int threadTotal=200;
    public static AtomicInteger count=new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool(); // 获取线程池
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int i = 0; i < clientTotal; i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(count.get());
    }

    private static void add(){
        count.incrementAndGet();
    }
}