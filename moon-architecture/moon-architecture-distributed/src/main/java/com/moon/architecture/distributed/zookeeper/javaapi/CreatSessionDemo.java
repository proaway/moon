package com.moon.architecture.distributed.zookeeper.javaapi;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class CreatSessionDemo {
	private static final String CONNECTION = "127.0.0.1:2181,127.0.0.1:2181,127.0.0.1:2181";
	private static CountDownLatch countDownLatch = new CountDownLatch(1);

	public static void main(String[] args) throws IOException, InterruptedException {
		ZooKeeper zookeeper = new ZooKeeper(CONNECTION, 5000, new Watcher() {

			@Override
			public void process(WatchedEvent watchedEvent) {
				if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
					countDownLatch.countDown();
				}
				System.out.println(watchedEvent.getState());
			}
		});
		countDownLatch.await();
		System.out.println(zookeeper.getState());
	}

}
