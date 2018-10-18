package com.moon.base.concurrency.thread.join;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 模拟多线程异步调用其他系统，待每个系统返回结果后，汇总返回
 * 
 * @author TobiasCui
 * @date 2018年10月18日 下午3:27:58
 * 
 */
public class FlightQueryMain {

	public static void main(String[] args) throws InterruptedException {
		List<String> results = search("北京", "上海");
		System.out.println("++++++++++++++++++输出结果+++++++++++++++++");
		for (String string : results) {
			System.out.println(string);
		}
		TimeUnit.MINUTES.sleep(1);
	}

	/**
	 * 模拟调用其他系统的接口
	 * 
	 * @author TobiasCui
	 * @date 2018年10月18日 下午3:19:31
	 * 
	 * @param origin
	 * @param destination
	 * @return
	 * @throws InterruptedException
	 */
	private static List<String> search(String origin, String destination) throws InterruptedException {
		List<String> results = new ArrayList<>();
		/** 1、创建线程（开始创建访问其他服务的连接） */
		List<FlightQueryTask> tasks = createTask(origin, destination);

		List<Thread> threads = new ArrayList<>();
		/** 2、分别启动每个线程（开始调用其他服务的接口） */
		for (FlightQueryTask flightQueryTask : tasks) {
			Thread thread = new Thread(flightQueryTask);
			threads.add(thread);
			thread.start();
		}
		/** 3、所有线程启动后，分别调用每个线程的join，阻塞当前的线程（main-线程），等待每个服务器返回的结果 */
		for (Thread thread : threads) {
			thread.join();
		}
		/** 此时main-线程阻塞，等待各个线程的结果（等待线程生命周期结束） */

		/** 4、所有线程结束后，获取每个线程返回的结果 */
		for (FlightQueryTask flightQueryTask : tasks) {
			List<String> result = flightQueryTask.get();
			results.addAll(result);
		}
		return results;
	}

	/**
	 * 创建线程（开始创建访问其他服务的连接）
	 * 
	 * @author TobiasCui
	 * @date 2018年10月18日 下午3:23:56
	 * 
	 * @param origin
	 * @param destination
	 * @return
	 */
	private static List<FlightQueryTask> createTask(String origin, String destination) {
		List<FlightQueryTask> tasks = new ArrayList<>();
		String airline1 = "南航";
		String airline2 = "海航";
		String airline3 = "东方";
		FlightQueryTask task1 = new FlightQueryTask(airline1, origin, destination);
		FlightQueryTask task2 = new FlightQueryTask(airline2, origin, destination);
		FlightQueryTask task3 = new FlightQueryTask(airline3, origin, destination);
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);
		return tasks;
	}

}
