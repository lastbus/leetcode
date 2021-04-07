package com.make.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author make
 * @create 2021-04-07
 */
public class E234_PalindromeLinkedList {

    // my solution, over time limit
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        ListNode cur = head;
        for (int i = 0; i < length / 2; i++) {
            tail = head;
            int k = length - i - 1;
            while (k-- > 0) tail = tail.next;
            if (cur.val != tail.val) return false;
            cur = cur.next;
        }
        return true;
    }


    // 官方答案，时间复杂度： O(n)
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;
        List<Integer> list = new ArrayList<Integer>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        int font = 0;
        int back = list.size() - 1;
        while (font < back) {
            if (list.get(font) != list.get(back)) return false;
            font++;
            back--;
        }
        return true;
    }
}
