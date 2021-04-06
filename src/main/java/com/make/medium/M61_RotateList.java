package com.make.medium;

/**
 * @author make
 * @create 2021-04-06
 */
public class M61_RotateList {

    // 自己的解答，太 low
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) return head;
        int length = 0;
        ListNode h = head;
        while (h != null) {
            length++;
            h = h.next;
        }
        h = head;
        for (int i = 1; i <= k % length; i++) {
            ListNode tail = h;
            ListNode pre = null;
            while (tail.next != null) {
                pre = tail;
                tail = tail.next;
            }
            pre.next = null;
            tail.next = h;
            h = tail;
        }
        return h;
    }


    // 将链表拼成环，然后在合适的地方断开
    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) return head;
        int length = 1;
        ListNode curr = head;
        while (curr.next != null) {
            length++;
            curr = curr.next;
        }
        int skip = length - (k % length);
        curr.next = head;
        while (skip-- > 0) {
            curr = curr.next;
        }
        ListNode tmp = curr.next;
        curr.next = null;
        return tmp;
    }

}
