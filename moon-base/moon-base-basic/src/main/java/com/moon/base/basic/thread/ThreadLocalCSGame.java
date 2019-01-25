package com.moon.base.basic.thread;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalCSGame {
	private static final Integer BULLET_NUMBER = 1500;
	private static final Integer KILLED_ENEMISE = 0;
	private static final Integer LIFE_VALUE = 10;
	private static final Integer TOTAL_PLAYERS = 10;

	/**
	 * ThreadLocalRandom是JDK
	 * 7之后提供并发产生随机数，能够解决多个线程发生的竞争争夺。ThreadLocalRandom不是直接用new实例化，而是第一次使用其静态方法current()。
	 */
	private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

	/** 初始化子弹数 */
	private static final ThreadLocal<Integer> BULLET_NUMBER_THREADLOCAL = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return BULLET_NUMBER;
		}
	};
	/** 初始化杀人数 */
	private static final ThreadLocal<Integer> KILLED_ENEMISE_THREADLOCAL = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return KILLED_ENEMISE;
		}
	};
	/** 初始化生命值 */
	private static final ThreadLocal<Integer> LIFE_VALUE_THREADLOCAL = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return LIFE_VALUE;
		}
	};

	/** 定义每位队员 */

	private static class Player extends Thread {
		@Override
		public void run() {
			Integer bullets = BULLET_NUMBER_THREADLOCAL.get() - RANDOM.nextInt(BULLET_NUMBER);
			Integer killEnemies = KILLED_ENEMISE_THREADLOCAL.get() + RANDOM.nextInt(TOTAL_PLAYERS / 2);
			Integer lifeValue = LIFE_VALUE_THREADLOCAL.get() - RANDOM.nextInt(LIFE_VALUE);

			System.out.println(getName() + ":bullets=" + bullets);
			System.out.println(getName() + ":killEnemies=" + killEnemies);
			System.out.println(getName() + ":lifeValue=" + lifeValue);

			BULLET_NUMBER_THREADLOCAL.remove();
			KILLED_ENEMISE_THREADLOCAL.remove();
			LIFE_VALUE_THREADLOCAL.remove();
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < TOTAL_PLAYERS; i++) {
			new Player().start();
		}
	}

}
