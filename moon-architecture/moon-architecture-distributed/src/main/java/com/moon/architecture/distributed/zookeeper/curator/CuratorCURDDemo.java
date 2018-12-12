package com.moon.architecture.distributed.zookeeper.curator;

import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * TODO
 * 
 * @author TobiasCui
 * @date 2018年12月12日 上午10:46:24
 * 
 */
public class CuratorCURDDemo {
	private static final String ZK_ADRESS = "127.0.0.1:2181,127.0.0.1:2181,127.0.0.1:2181";
	private static final String ZK_PATH = "/zktest";
	private static CuratorFramework client = CuratorFrameworkFactory.newClient(ZK_ADRESS, new RetryNTimes(10, 5000));
	static {
		client.start();
		System.out.println("客户端连接zk成功");
	}

	public static void main(String[] args) throws Exception {
		String testNodePath = ZK_PATH + "/test1/test2";
		String forPath = createNode(testNodePath, "123", CreateMode.EPHEMERAL);
		System.out.println(forPath);

		String forPath4;
		String data = getData(testNodePath);
		System.out.println(data);
		List<String> forPath2 = client.getChildren().forPath("/");
		String forPath3 = new String(client.getData().forPath("/"));
		Stat forPath5 = client.setData().forPath(ZK_PATH, "1".getBytes());
		client.delete().forPath(testNodePath);
		List<String> forPath6 = client.getChildren().forPath(ZK_PATH + "/test1");
		for (String string : forPath6) {
			System.out.println(string);
		}
	}

	/**
	 * 创建节点
	 * 
	 * @author TobiasCui
	 * @date 2018年12月12日 上午11:11:47
	 * 
	 * @param path
	 *            路径
	 * @param data
	 *            字符串数据
	 * @param createMode
	 *            CreateMode.PERSISTENT-持久节点（默认）
	 *            CreateMode.PERSISTENT_SEQUENTIAL-持久有序节点
	 *            CreateMode.EPHEMERAL-临时节点
	 *            CreateMode.EPHEMERAL_SEQUENTIAL-临时有序节点
	 * @return
	 * @throws Exception
	 */
	private static String createNode(String path, String data, CreateMode createMode) throws Exception {
		Stat stat = client.checkExists().forPath(path);
		if (stat != null) {
			return path;
		}

		if (createMode == null) {
			createMode = CreateMode.PERSISTENT;
		}
		String forPath = client.create().creatingParentContainersIfNeeded().withMode(createMode).forPath(path, data.getBytes());
		return forPath;
	}

	/**
	 * 获取数据
	 * 
	 * @author TobiasCui
	 * @date 2018年12月12日 上午11:18:34
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	private static String getData(String path) throws Exception {
		Stat stat = client.checkExists().forPath(path);
		if (stat == null) {
			return null;
		}
		String data = new String(client.getData().forPath(path));
		return data;
	}
}
