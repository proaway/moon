package com.moon.senior.algorithm.list;

public class ListNode4Merge {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
		if (listNode1 == null)
			return listNode2;
		if (listNode2 == null)
			return listNode1;

		ListNode head = null;
		if (listNode1.val <= listNode2.val) {
			head = listNode1;
			head.next = mergeTwoLists(listNode1.next, listNode2);
		} else {
			head = listNode2;
			head.next = mergeTwoLists(listNode1, listNode2.next);
		}
		return head;
	}

	public ListNode mergeTwoLists2(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null)
			return head1 == null ? head2 : head1;

		ListNode head = head1.val < head2.val ? head1 : head2;
		ListNode cur1 = head == head1 ? head1 : head2;
		ListNode cur2 = head == head1 ? head2 : head1;
		ListNode pre = null, next = null;

		while (cur1 != null && cur2 != null) {
			if (cur1.val <= cur2.val) {
				pre = cur1;
				cur1 = cur1.next;
			} else {
				next = cur2.next;
				pre.next = cur2;
				cur2.next = cur1;
				pre = cur2;
				cur2 = next;
			}
		}
		pre.next = cur1 == null ? cur2 : cur1;
		return head;
	}

}
