package com.sc.science.arithmetic.swordoffer;

/**
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Day11_链表中倒数第K个结点 {

    public static ListNode FindKthToTail(ListNode head, int k) {
        ListNode pre = null, p = null;
        //两个指针都指向头结点
        p = head;
        pre = head;
        //记录k值
        int a = k;
        //记录节点的个数
        int count = 0;
        //p指针先跑，并且记录节点数，当p指针跑了k-1个节点后，pre指针开始跑，
        //当p指针跑到最后时，pre所指指针就是倒数第k个节点
        while (p != null) {
            p = p.next;
            count++;
            if (k < 1) {
                pre = pre.next;
            }
            k--;
        }
        //如果节点个数小于所求的倒数第k个节点，则返回空
        if (count < a) return null;
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode1=new ListNode(5);
        listNode1.next=new ListNode(4);
        listNode1.next.next=new ListNode(3);
        listNode1.next.next.next=new ListNode(2);
        listNode1.next.next.next.next=new ListNode(1);

        System.out.println("-->" +FindKthToTail(listNode1,2));

    }
}
