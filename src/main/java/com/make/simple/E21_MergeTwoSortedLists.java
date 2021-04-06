package com.make.simple;

/**
 * @author make
 * @create 2019-12-28
 */
public class E21_MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode l3 = head;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                l3.next = l2;
                break;
            } else if (l2 == null) {
                l3.next = l1;
                break;
            } else if (l1.val <= l2.val) {
                l3.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                l3.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        return head.next;
    }


    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (h1 != null || h2 != null) {
            if (h1 == null) {
                tmp.next = h2;
                break;
            }
            if (h2 == null) {
                tmp.next = h1;
                break;
            }
            if (h1.val <= h2.val) {
                tmp.next = h1;
                h1 = h1.next;
            } else {
                tmp.next = h2;
                h2 = h2.next;
            }
            tmp = tmp.next;
        }
        return newHead.next;
    }

}
