package com.moon.base.basic.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * JDK8 HashMap在并发时出现问题：
 * <p>
 * 1、数据丢失，不会出现死循环； <br/>
 * 
 * 单线程时：0:null; 1:5=C, 0:null, 3:3-A -> 7=B <br/>
 * 多线程时：<br/>
 * 有可能是：0:null; 1:5=C, 0:null, 3:3=A <br/>
 * 有可能是：0:null; 1:5=C, 0:null, 3:7=B <br/>
 * 
 * @author TobiasCui
 * @date 2018年11月6日 上午11:53:47
 * 
 */
public class HashMap8 {

	public static void main(String[] args) throws InterruptedException {
		HashMap<String, String> map = new HashMap<>(2);
		for (int i = 0; i < 200; i++) {
			new Thread(new Put(map)).start();
		}

		TimeUnit.SECONDS.sleep(1);
		int count = 0;
		for (Map.Entry<String, String> mp : map.entrySet()) {
			count++;
		}
		System.out.println(count);

	}

}

class Put implements Runnable {
	HashMap<String, String> map;

	public Put(HashMap<String, String> map) {
		this.map = map;
	}

	@Override
	public void run() {
		for (int j = 0; j < 200; j++) {
			map.put(Thread.currentThread().getName() + j, "Test");
		}
	}

}
