package com.moon.base.concurrency.thread;

public class NumPrinters {
    private volatile static boolean flag = false;
    private volatile static int num = 1;
    private static int max = 100;
    private static Object lock = new Object();

    public static void main(String[] args) {
        Thread printer1 = new Thread("printer1") {
            @Override
            public void run() {
                while (num <= max) {
                    synchronized (lock) {
                        if (!flag && num <= max) {
                            System.out.println(Thread.currentThread().getName() + ":" + num);
                            num++;
                            flag = true;
                        } else {
                            lock.notifyAll();
                            if (num < max) {
                                try {
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        };
        Thread printer2 = new Thread("printer2") {
            @Override
            public void run() {
                while (num <= max) {
                    synchronized (lock) {
                        if (flag && num <= max) {
                            System.out.println(Thread.currentThread().getName() + ":" + num);
                            num++;
                            flag = false;
                        } else {
                            lock.notifyAll();
                            if (num <= max) {
                                try {
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        };
        printer1.start();
        printer2.start();
    }
}
