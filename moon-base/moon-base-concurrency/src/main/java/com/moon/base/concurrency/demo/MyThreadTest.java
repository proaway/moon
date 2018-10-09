package com.moon.base.concurrency.demo;

public class MyThreadTest {

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		Thread t1 = new Thread(myThread, "t1");
		Thread t2 = new Thread(myThread, "t2");
		Thread t3 = new Thread(myThread, "t3");
		Thread t4 = new Thread(myThread, "t4");
		Thread t5 = new Thread(myThread, "t5");
		Thread t6 = new Thread(myThread, "t6");
		Thread t7 = new Thread(myThread, "t7");
		//myThread.start();
		myThread.run();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
	}
}
