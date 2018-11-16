package com.moon.base.basic.map;

import java.util.HashMap;

/**
 * JDK7 HashMap在并发时出现问题：
 * <p>
 * 1、数据丢失； <br/>
 * 2、死循环；<br/>
 * 结果：<br/>
 * 单线程时：0:null; 1:5=C, 0:null, 3:3-A -> 7=B <br/>
 * 多线程时：<br/>
 * 有可能是：0:null; 1:5=C, 0:null, 3:3=A <br/>
 * 有可能是：0:null; 1:5=C, 0:null, 3:7=B <br/>
 * 
 * @author TobiasCui
 * @date 2018年11月6日 上午11:53:47
 * 
 */
public class HashMap7 {

	private static HashMap<Integer, String> map = new HashMap<>(2, 0.75f); // capacity默认16，此处设置2

	public static void main(String[] args) {
		map.put(5, "C");
		new Thread("Thread1") {
			@Override
			public void run() {
				map.put(7, "B");
				System.out.println(map); // 0:null; 1:5=C, 0:null, 3:7=B
			}
		}.start();
		new Thread("Thread2") {
			@Override
			public void run() {
				map.put(3, "A");
				System.out.println(map); // 单线程时：0:null; 1:5=C, 0:null, 3:3-A ->
											// 7=B
				// 多线程时：0:null; 1:5=C, 0:null, 3:3=A
			}
		}.start();

		System.out.println(map);
	}

}
