package com.make.simple;

/**
 * @author make
 * @create 2021-04-06
 */
public class E206_ReverseLinkedList {

    // 迭代
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    // 递归
    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }

    public ListNode reverse(ListNode pre, ListNode head) {
        if (head == null) return null;
        if (head.next == null) {
            head.next = pre;
            return head;
        }
        ListNode tmp = head.next;
        head.next = pre;
        return reverse(head, tmp);
    }

    // 递归，官方答案，简介一点
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


}
