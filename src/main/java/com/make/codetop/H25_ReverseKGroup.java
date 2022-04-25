package com.make.codetop;

/**
 * @author make
 * @create 2022-04-25
 */
public class H25_ReverseKGroup {


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = head;
        ListNode pre = dummyHead;

        int c = 0;
        while (cur != null) {
            c++;
            if (c == k) {
                ListNode next = cur.next;

                cur.next = null;
                reverseLink(head, head.next);

                pre.next = cur;
                head.next = next;

                pre = head;
                head = next;
                cur = next;

                c = 0;
            } else {
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }


    public ListNode reverseLink(ListNode pre, ListNode cur) {
        if (cur == null) return pre;
        ListNode next = cur.next;
        cur.next = pre;
        return reverseLink(cur, next);
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
