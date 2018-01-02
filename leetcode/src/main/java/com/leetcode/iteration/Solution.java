package com.leetcode.iteration;

/**
 * @author lifewikllbebest@163.com
 * 
 * @title:Given a linked list, swap every two adjacent nodes and return its
 *              head.
 * @url:https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 */
public class Solution {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode next = head.next;
		head.next = swapPairs(head.next.next);
        next.next = head;
		return next;
	}

}
