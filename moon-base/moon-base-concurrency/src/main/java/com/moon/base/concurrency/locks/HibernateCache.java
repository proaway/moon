package com.moon.base.concurrency.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 〈功能简述〉<br>
 * 〈模拟Hibernate的缓存〉
 *
 * @author TobiasCui
 * @create 2018/11/19
 * @since 1.0.0
 */
public class HibernateCache {
	private static Map<String, Object> cache = new HashMap<>();
	private ReadWriteLock rwLock = new ReentrantReadWriteLock();

	private Object getData(String key) {
		/** 上读锁 */
		rwLock.readLock().lock();
		Object value = null;
		/** 从缓存中读取数据 */
		try {
			value = cache.get(key);
			if (value == null) {
				System.out.println("缓存中没有数据，查询数据库");
				/** 如果缓存中没有数据，关闭读锁 */
				rwLock.readLock().unlock();
				/** 直接上写锁 */
				rwLock.writeLock().lock();
				try {
					if (value == null) {
						/** 模拟一线程去数据库中取数据 */
						value = "hello";
						cache.put(key, value);
					}
				} finally {
					rwLock.writeLock().unlock();
				}
			}
		} finally {
			try {
				rwLock.readLock().unlock();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}
		return value;
	}

	public static void main(String[] args) {
		System.out.println(new HibernateCache().getData("123"));
		System.out.println(new HibernateCache().getData("123"));
	}
}
