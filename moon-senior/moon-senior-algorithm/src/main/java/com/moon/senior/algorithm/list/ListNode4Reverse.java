package com.moon.senior.algorithm.list;

/**
 * 反转单链表
 * 
 * @author Tobias
 * @date 2019年2月19日 上午12:07:31
 * 
 */
public class ListNode4Reverse {
	int val;
	ListNode4Reverse next;

	ListNode4Reverse(int x) {
		val = x;
		next = null;
	}

	/**
	 * 1.就地反转法
	 */
	public ListNode4Reverse reverseList1(ListNode4Reverse head) {
		if (head == null)
			return head;
		ListNode4Reverse tmp = new ListNode4Reverse(-1);
		tmp.next = head;
		ListNode4Reverse prev = tmp.next;
		ListNode4Reverse pCur = prev.next;
		while (pCur != null) {
			prev.next = pCur.next;
			pCur.next = tmp.next;
			tmp.next = pCur;
			pCur = prev.next;
		}
		return tmp.next;
	}

	/**
	 * 2.新建链表,头节点插入法
	 */
	public ListNode4Reverse reverseList2(ListNode4Reverse head) {
		ListNode4Reverse dummy = new ListNode4Reverse(-1);
		ListNode4Reverse pCur = head;
		while (pCur != null) {
			ListNode4Reverse pNex = pCur.next;
			pCur.next = dummy.next;
			dummy.next = pCur;
			pCur = pNex;
		}
		return dummy.next;
	}
}
