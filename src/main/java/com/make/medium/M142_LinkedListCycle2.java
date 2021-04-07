package com.make.medium;

/**
 * @author make
 * @create 2021-04-07
 */
public class M142_LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        if (head == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

}
