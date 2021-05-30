package com.make.hard;

/**
 * @author make
 * @create 2021-05-30
 */
public class H25_ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) return head;
        ListNode first = head;
        ListNode second = head;
        int n = k;
        while (first != null && n-- > 0) first = first.next;
        if (n > 0) return head;
        ListNode newHead = reverseLink(second, first);
        second.next = reverseKGroup(first, k);
        return newHead;
    }

    public ListNode reverseLink(ListNode head, ListNode tail) {
        if (head == tail) return head;
        ListNode nextNode = head.next;
        while (nextNode != tail) {
            ListNode tmp = nextNode.next;
            nextNode.next = head;
            head = nextNode;
            nextNode = tmp;
        }
        return head;
    }

}
