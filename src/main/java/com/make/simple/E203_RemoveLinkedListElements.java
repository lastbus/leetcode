package com.make.simple;

/**
 * @author make
 * @create 2021-04-07
 */
public class E203_RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = head;
        ListNode pre = dummyHead;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur.next = null;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

}
