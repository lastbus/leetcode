package com.make.medium;

/**
 * @author make
 * @create 2021-04-06
 */
public class M92_ReverseLinkedList2 {

    // my solution
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;
        ListNode cur = head;
        ListNode pre = null;
        int pos = 1;
        while (cur != null) {
            if (pos == left) {
                ListNode meetNode = cur;
                ListNode pre2 = cur;
                cur = cur.next;
                pos++;
                while (cur != null) {
                    if (pos == right) {
                        ListNode tmp = cur.next;
                        cur.next = pre2;
                        if (pre != null) {
                            pre.next = cur;
                        } else {
                            head = cur;
                        }
                        meetNode.next = tmp;
                        break;
                    } else {
                        ListNode tmp = cur.next;
                        cur.next = pre2;
                        pre2 = cur;
                        cur = tmp;
                    }
                    pos++;
                }
                break;
            }
            pos++;
            pre = cur;
            cur = cur.next;
        }
        return head;
    }


    // 官方答案，逻辑更清晰
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        reverseLinkedList(leftNode);

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    private void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    // 官方答案，头查法
    public ListNode reverseBetween3(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }

}
