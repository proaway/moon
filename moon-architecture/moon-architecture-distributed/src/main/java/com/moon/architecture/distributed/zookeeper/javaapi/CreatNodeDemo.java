package com.moon.architecture.distributed.zookeeper.javaapi;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class CreatNodeDemo {
	private static final String CONNECTION = "127.0.0.1:2181,127.0.0.1:2181,127.0.0.1:2181";
	private static CountDownLatch countDownLatch = new CountDownLatch(1);
	private static ZooKeeper zookeeper;
	private static Stat stat = new Stat();

	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
		zookeeper = new ZooKeeper(CONNECTION, 5000, newWatcher());
		countDownLatch.await();
		System.out.println(zookeeper.getState());

		/** 创建节点 */
		String result = zookeeper.create("/cuierwei", "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		TimeUnit.SECONDS.sleep(2);
		System.out.println("创建成功：" + result);
		Stat result2 = zookeeper.setData("/cuierwei", "123".getBytes(), -1);
		TimeUnit.SECONDS.sleep(2);
		System.out.println("修改成功：" + result);
	}

	private static Watcher newWatcher() {
		return new Watcher() {

			@Override
			public void process(WatchedEvent watchedEvent) {
				if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
					if (Event.EventType.None == watchedEvent.getType() && null == watchedEvent.getType()) {
						countDownLatch.countDown();
						System.out.println(watchedEvent.getState());
					} else if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
						try {
							System.out.println(watchedEvent.getPath() + "--->" + zookeeper.getData(watchedEvent.getPath(), true, stat));
						} catch (KeeperException e) {
							e.printStackTrace();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged) {

					} else if (watchedEvent.getType() == Event.EventType.NodeCreated) {
						try {
							System.out.println(watchedEvent.getPath() + "--->" + zookeeper.getData(watchedEvent.getPath(), true, stat));
						} catch (KeeperException e) {
							e.printStackTrace();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					} else if (watchedEvent.getType() == Event.EventType.NodeDeleted) {

					}
				}

				System.out.println(watchedEvent.getState());
			}
		};
	}

}
