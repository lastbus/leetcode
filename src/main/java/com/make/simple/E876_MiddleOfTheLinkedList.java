package com.make.simple;

/**
 * @author make
 * @create 2021-04-07
 */
public class E876_MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
