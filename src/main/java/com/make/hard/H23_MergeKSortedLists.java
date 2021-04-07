package com.make.hard;

/**
 * @author make
 * @create 2021-04-07
 */
public class H23_MergeKSortedLists {

    // my solution
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        if (lists == null || lists.length == 0) return dummyHead.next;
        while (true) {
            int min = -1;
            int index = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && index == -1) {
                    min = lists[i].val;
                    index = i;
                } else if (lists[i] != null && lists[i].val < min) {
                    index = i;
                    min = lists[i].val;
                }
            }
            if (index == -1) break;
            ListNode node = new ListNode(min);
            cur.next = node;
            cur = cur.next;
            lists[index] = lists[index].next;
        }
        return dummyHead.next;
    }


}
