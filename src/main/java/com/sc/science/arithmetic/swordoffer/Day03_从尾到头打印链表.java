package com.sc.science.arithmetic.swordoffer;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述:
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList
 * @auth:senssic
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public class Day03_从尾到头打印链表 {

    static ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode.next!= null){
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        listNode1.next=new ListNode(2);
        listNode1.next.next=new ListNode(3);
        listNode1.next.next.next=new ListNode(4);
        listNode1.next.next.next.next=new ListNode(5);

       List<Integer> list= printListFromTailToHead(listNode1);
        System.out.println("-->" + JSON.toJSONString(list));




    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}