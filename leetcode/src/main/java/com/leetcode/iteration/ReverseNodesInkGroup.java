package com.leetcode.iteration;

/**
 * @author lifewikllbebest@163.com
 * 
 * @title:Given a linked list, reverse the nodes of a linked list k at a time
 *              and return its modified list.
 * @url:https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 *
 */
public class ReverseNodesInkGroup {

	/**
	 * 使用迭代的方式
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode curr = head;
		int count = 0;
		while (null != curr && count != k) {
			curr = curr.next;
			count++;
		}
		// 如果小于直接返回
		if (k == count) {
			// 迭代方法看剩余节点是否需要反转
			reverseKGroup(curr, k);
			while (count-- > 0) {
				ListNode tmp = head.next;
				head.next = curr;
				curr = head;
				head = tmp;
			}
			head = curr;
		}
		return head;
	}


	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
