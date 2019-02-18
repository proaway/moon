package com.moon.senior.algorithm.list;

public class ListNode4RemoveNthFromEnd {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode fast = dummy;
		ListNode slow = dummy;
		while (fast != null && n > -1) {
			fast = fast.next;
			n--;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}

	public ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode pre = head;
		ListNode post = head;
		for (int i = 0; i < n; i++) {
			post = post.next;
		}
		if (post == null) {
			return head.next;
		}
		while (post.next != null) {
			post = post.next;
			pre = pre.next;
		}
		pre.next = pre.next.next;
		return head;
	}
}
