package com.make.medium;

/**
 * @author make
 * @create 2021-04-08
 */
public class M148_SortList {

    // my solution, over time limit
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }

        for (int i = 0; i < size - 1; i++) {
            ListNode cur2 = dummyHead.next;
            ListNode pre2 = dummyHead;
            for (int j = 0; j < size - 1 - i; j++) {
                if (cur2 == null || cur2.next == null) break;
                if (cur2.val > cur2.next.val) {
                    pre2.next = cur2.next;
                    cur2.next = cur2.next.next;
                    pre2.next.next = cur2;
                    pre2 = pre2.next;
                } else {
                    pre2 = cur2;
                    cur2 = cur2.next;
                }
            }
        }
        return dummyHead.next;
    }

}
