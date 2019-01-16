package com.sc.science.arithmetic.swordoffer;

/**
 * 题目描述 输入一个链表，反转链表后，输出新链表的表头。
 *
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Day12_翻转链表 {

    public static ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;


    }

    public static void main(String[] args) {
        ListNode listNode1=new ListNode(5);
        listNode1.next=new ListNode(4);
        listNode1.next.next=new ListNode(3);
        listNode1.next.next.next=new ListNode(2);
        listNode1.next.next.next.next=new ListNode(1);
        System.out.println("-->" +ReverseList(listNode1));
    }
}
