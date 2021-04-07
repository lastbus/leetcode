package com.make.simple;

import java.util.ArrayList;
import java.util.List;

public class E1290_ConvertBinaryNumberInALinkedListToInteger {


    // my solution, sb
    public int getDecimalValue(ListNode head) {
        if (head == null) return 0;
        List<Integer> list = new ArrayList<Integer>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int v = 0;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            v +=  (1 << (size - i - 1)) * list.get(i);
        }
        return v;
    }


    // official solution
    public int getDecimalValue2(ListNode head) {
        if (head == null) return 0;
        List<Integer> list = new ArrayList<Integer>();
        ListNode cur = head;
        int v = 0;
        while (cur != null) {
            v += cur.val + v;
            cur = cur.next;
        }
        return v;
    }


}
