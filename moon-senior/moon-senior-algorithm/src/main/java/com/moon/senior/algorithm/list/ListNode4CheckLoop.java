package com.moon.senior.algorithm.list;

import java.util.HashMap;

/**
 * 单链表中是否有环
 * 
 * @author Tobias
 * @date 2019年2月19日 上午12:07:57
 * 
 * @param <T>
 */
public class ListNode4CheckLoop<T> {

	/**
	 * 单链表节点
	 */
	private static class SingleNode<T> {
		public SingleNode<T> next;
		public T data;

		public SingleNode(T data) {
			this.data = data;
		}

		public T getNextNodeData() {
			return next != null ? next.data : null;
		}
	}

	/**
	 * 判断是否有环：快慢指针法
	 */
	public static boolean hasLoopV1(SingleNode headNode) {

		if (headNode == null) {
			return false;
		}

		SingleNode p = headNode;
		SingleNode q = headNode.next;
		// 快指针未能遍历完所有节点
		while (q != null && q.next != null) {
			p = p.next; // 遍历一个节点
			q = q.next.next; // 遍历两个个节点
			// 已到链表末尾
			if (q == null) {
				return false;
			} else if (p == q) {
				// 快慢指针相遇，存在环
				return true;
			}
		}
		return false;
	}

	// 保存足迹信息
	private static HashMap<SingleNode, Integer> nodeMap = new HashMap<>();

	/**
	 * 判断是否有环 足迹法
	 */
	public static boolean hasLoopV2(SingleNode node, int index) {
		if (node == null || node.next == null) {
			return false;
		}
		if (nodeMap.containsKey(node)) {
			return true;
		} else {
			nodeMap.put(node, index);
			return hasLoopV2(node.next, ++index);
		}
	}

}
