package com.make.codetop;

/**
 * @author make
 * @create 2022-04-25
 */
public class E206_ReverseList {


    // 循环
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
        ListNode next = head.next;
        ListNode prev = null;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = cur;
            cur.next = prev;
            prev = cur;
            cur = next;
            next = tmp;
        }

        return cur;
    }


    // 递归
    public ListNode reverseList_2(ListNode head) {
        if (head == null) return head;
        return reverseTwoNode(null, head);
    }

    private ListNode reverseTwoNode(ListNode pre, ListNode cur) {
        ListNode next = cur.next;
        cur.next = pre;
        if (next == null) {
            return cur;
        }
        return reverseTwoNode(cur, next);
    }






    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
