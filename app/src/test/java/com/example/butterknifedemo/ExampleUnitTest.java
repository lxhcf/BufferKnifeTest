package com.example.butterknifedemo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void myTest(){
//        @FruitName("Apple")String appleName;
//        int sum=1+2;
//        System.out.println(sum);
//        @Add(ele1=10f,ele2=1000f)
//                public double ele;



        ListNode listNode1=new ListNode(1);
        listNode1.next=new ListNode(2);
        listNode1.next.next=new ListNode(3);
        listNode1.next.next.next=new ListNode(4);
        listNode1.next.next.next.next=new ListNode(5);

//        ListNode next=listNode1.next;
//        for(int i=0;i<4;i++){
//            listNode1.next=new ListNode(i+2);
////           System.out.println(listNode1.next.value);
//            listNode1.next=listNode1.next.next;
//        }

//      ListNode listNode=remoeNthFromEnd(listNode1,3);

              ListNode listNode=reverseList(listNode1);

        for (int i=0;i<3;i++){
            System.out.println(listNode.value);
            listNode=listNode.next;

        }






    }

    /**
     * 删除链表倒数第n个结点:leetcode第19题
     * @param head
     * @param n
     * @return
     */
    public ListNode remoeNthFromEnd(ListNode head,int n){

        /**
         * 第一步,定义快慢指针
         */
        ListNode fast=head;
        ListNode slow=head;

        /**
         * 第二步,让快指针先走n步
         */
        for (int i=0;i<n;i++){
            fast=fast.next;
        }
        /**
         * 第三步,如果快指针越界了,那就变动头指针的值
         */
        if(fast==null){
            head=head.next;
            return head;
        }

        /**
         * 第四步,让快慢指针同步移动,直到快指针到末尾
         */
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        /**
         * 第五步,让慢指针后一个元素指向待删元素后一个结点
         */
        slow.next=slow.next.next;
        return head;
    }

    /**
     * 反转单链表
     */
    public ListNode reverseList(ListNode head) {
        /**
         * 判断链表为空或只有一个结点,那就不用反转直接输出头节点
         */
        if(head==null || head.next==null)
        {
            return head;
        }

        /**
         * 定义前后,现有结点;
         */
        ListNode preNode=null;
        ListNode cueNode=head;
        ListNode nextNode=null;
        /**
         * 如果现在的结点不为空,
         * 1)后结点 = 当前结点的后一个
         * 2)当前结点的后一个结点 = 前一个结点
         * 3)前一个结点=现在这个结点
         * 4)现在这个结点 = 下一个结点
         */
        while (cueNode!=null){
            nextNode=cueNode.next;
            cueNode.next=preNode;
            preNode=cueNode;
            cueNode=nextNode;
        }
        return  preNode;
    }

    public class ListNode{
        int value;
        ListNode next;
        ListNode(int x){
            value=x;
        }
    }
}