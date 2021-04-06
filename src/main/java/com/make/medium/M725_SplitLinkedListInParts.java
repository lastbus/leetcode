package com.make.medium;

/**
 * @author make
 * @create 2021-04-06
 */
public class M725_SplitLinkedListInParts {

    // 自己写的，错误
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        if (root == null) return res;
        int size = 0;
        ListNode cur = root;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        int upper = (int) Math.ceil((double) size / k);
        int low = (int) Math.floor((double) size / k);
        low = low == 0 ? 1 : low;
        int count = 0;
        cur = root;
        for (int i = 0; i < k; i++) {
            int n = ((size - count) / upper >= 1 && (size - count) / low != 0 ) ? upper : low;
            count += n;
            ListNode head = new ListNode(-1);
            ListNode list = head;
            while (n-- > 0 && cur != null) {
                ListNode node = new ListNode(cur.val);
                list.next = node;
                list = node;
                cur = cur.next;
            }
            res[i] = head.next;
            if (cur == null) break;
        }
        return res;
    }

    // 看参考答案写的
    public ListNode[] splitListToParts2(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        if (root == null) return res;
        int size = 0;
        ListNode cur = root;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        int width = size / k, rem = size % k;
        cur = root;
        for (int i = 0; i < k; i++) {
            ListNode head = new ListNode(-1), list = head;
            int n = i < rem ? width + 1 : width;
            while (n-- > 0 && cur != null) {
                ListNode node = new ListNode(cur.val);
                list.next = node;
                list = node;
                cur = cur.next;
            }
            res[i] = head.next;
            if (cur == null) break;
        }
        return res;
    }


}
