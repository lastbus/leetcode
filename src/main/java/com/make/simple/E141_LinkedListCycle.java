package com.make.simple;

/**
 * @author make
 * @create 2021-04-06
 */
public class E141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode quick = head;
        while (slow != null && quick != null) {
            slow = slow.next;
            quick = quick.next;
            if (quick == null) {
                return false;
            }
            quick = quick.next;
            if (quick == slow) return true;
        }
        return false;
    }

}
