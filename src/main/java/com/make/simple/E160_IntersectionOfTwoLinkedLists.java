package com.make.simple;

/**
 * @author make
 * @create 2021-04-06
 */
public class E160_IntersectionOfTwoLinkedLists {

    // 我的解答
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = length(headA);
        int lengthB = length(headB);

        ListNode tmpA = headA, tmpB = headB;

        if (lengthA > lengthB) {
            int step = lengthA - lengthB;
            while (step > 0) {
                tmpA = tmpA.next;
                step--;
            }
        }

        if (lengthB > lengthA) {
            int step = lengthB - lengthA;
            while (step > 0) {
                tmpB = tmpB.next;
                step--;
            }
        }

        while (tmpA != null || tmpB != null) {
            if (tmpA == tmpB) return tmpA;
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }
        return null;
    }

    public int length(ListNode head) {
        if (head == null) {
            return 0;
        }
        int c = 0;
        ListNode tmp = head;
        while (tmp != null) {
            c++;
            tmp = tmp.next;
        }
        return c;
    }

    // 精选解答，更优
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;
    }

}
