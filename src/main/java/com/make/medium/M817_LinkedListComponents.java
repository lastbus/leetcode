package com.make.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author make
 * @create 2021-04-06
 */
public class M817_LinkedListComponents {

    public static void main(String[] args) {

        M817_LinkedListComponents listComponents = new M817_LinkedListComponents();

        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;

        int[] g = {0, 1, 3};
        System.out.println(listComponents.numComponents(node0, g));

    }

    public int numComponents(ListNode head, int[] G) {
        if (head == null || G.length == 0) return 0;
        Map<Integer, Boolean> gMap = new HashMap<Integer, Boolean>();
        for (int g : G) gMap.put(g, true);

        ListNode h = head;
        int sign = -1;
        int c = 0;
        while (h != null) {
            if (gMap.containsKey(h.val)) {
                sign = 1;
            } else {
                if (sign == 1) c++;
                sign = 0;
            }
            h = h.next;
        }
        if (sign == 1) c++;
        return c;
    }
}
