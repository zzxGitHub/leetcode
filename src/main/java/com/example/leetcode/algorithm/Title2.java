package com.example.leetcode.algorithm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Title1
 * @Description 两数相加
 * @Author zzx
 * @Date 2020/10/5 9:05
 * @Version 1.0
 */
public class Title2 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		node2.next = node3;
		node1.next = node2;

		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(6);
		ListNode node6 = new ListNode(4);
		node5.next = node6;
		node4.next = node5;

		Title2 sl = new Title2();
		ListNode node = sl.addTwoNumbers(node1, node4);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		List<Integer> l1List = new ArrayList<>();
		List<Integer> l2List = new ArrayList<>();
		ListNode head, tail;
		head = l1;
		while (head != null) {
			l1List.add(head.val);
			head = head.next;
		}
		tail = l2;
		while (tail != null) {
			l2List.add(tail.val);
			tail = tail.next;
		}
		StringBuilder a = new StringBuilder();
		for (int i = l1List.size() - 1; i >= 0; i--) {
			a.append(l1List.get(i));
		}
		StringBuilder b = new StringBuilder();
		for (int i = l2List.size() - 1; i >= 0; i--) {
			b.append(l2List.get(i));
		}
		BigDecimal c = new BigDecimal(a.toString()).add(new BigDecimal(b.toString()));
		System.out.println(c);
		String result = c.toString();
		char[] aaa = result.toCharArray();
		List<ListNode> nodeList = new ArrayList<>();
		for (int i = aaa.length - 1; i >= 0; i--) {
			ListNode resultNode = new ListNode();
			resultNode.val = Integer.parseInt(String.valueOf(aaa[i]));
			nodeList.add(resultNode);
		}
		for (int i = 0; i < nodeList.size() - 1; i++) {
			nodeList.get(i).next = nodeList.get(i + 1);
		}
		return nodeList.get(0);
	}
}


class ListNode {
	int val;
	ListNode next;

	ListNode() {}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
