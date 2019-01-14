package com.sc.science.arithmetic.swordoffer;

/**
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Day13_合并两个排序的链表 {

    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode listOne1=new ListNode(2);
        listOne1.next=new ListNode(3);
        listOne1.next.next=new ListNode(7);
        listOne1.next.next.next=new ListNode(20);
        listOne1.next.next.next.next=new ListNode(100);


        ListNode listTwo1=new ListNode(2);
        listTwo1.next=new ListNode(4);
        listTwo1.next.next=new ListNode(17);
        listTwo1.next.next.next=new ListNode(20);
        listTwo1.next.next.next.next=new ListNode(90);

        ListNode listNode=Merge(listOne1,listTwo1);
        while (listNode!=null){
            System.out.println("-->" +listNode.val);
            listNode=listNode.next;
        }
    }
}
