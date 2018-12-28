package com.moon.senior.algorithm.search;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BasicSearch {
	public static void main(String[] args) throws InterruptedException {
		ThreadMXBean mbean = ManagementFactory.getThreadMXBean();
		Runnable dlCheck = new Runnable() {
			@Override
			public void run() {
				long[] threadIds = mbean.findDeadlockedThreads();
				if (threadIds != null) {
					ThreadInfo[] threadInfos = mbean.getThreadInfo(threadIds);
					System.out.println("Detected deadlock threads:");
					for (ThreadInfo threadInfo : threadInfos) {
						System.out.println(threadInfo.getThreadName());
					}
				}
			}
		};
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		// 稍等 5 秒，然后每 10 秒进行一次死锁扫描
		scheduler.scheduleAtFixedRate(dlCheck, 5L, 10L, TimeUnit.SECONDS);
		// 死锁样例代码…
	}

	/**
	 * low、high、mid 都是指数组下标，其中 low 和 high 表示当前查找的区间范围，初始 low=0， high=n-1。mid 表示
	 * [low, high] 的中间位置。
	 * 
	 * 我们通过对比 a[mid] 与 value 的大小，来更新接下来要查找的区间范围，直到找到或者区间缩小为 0，就退出。
	 * 
	 * @author TobiasCui
	 * @date 2018年12月26日 下午12:10:00
	 * 
	 * @param a
	 * @param n
	 * @param value
	 * @return
	 */
	public int bsearch(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == value) {
				return mid;
			} else if (a[mid] < value) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	/**
	 * 二分查找的递归实现
	 * 
	 * @author TobiasCui
	 * @date 2018年12月26日 下午12:11:03
	 * 
	 * @param a
	 * @param n
	 * @param val
	 * @return
	 */
	public int bsearch2(int[] a, int n, int val) {
		return bsearchInternally(a, 0, n - 1, val);
	}

	private int bsearchInternally(int[] a, int low, int high, int value) {
		if (low > high)
			return -1;
		int mid = low + ((high - low) >> 1);
		if (a[mid] == value) {
			return mid;
		} else if (a[mid] < value) {
			return bsearchInternally(a, mid + 1, high, value);
		} else {
			return bsearchInternally(a, low, mid - 1, value);
		}
	}

}
