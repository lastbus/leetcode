package com.make.codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * @author make
 * @create 2022-04-25
 */
public class M146_LRUCache {

    private final Node head;
    private final Node tail;
    private final int capacity;
    private final Map<Integer, Node> nodeMap = new HashMap<>();



    public M146_LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }



    public int get(int i) {
        Node n = nodeMap.get(i);
        if (n == null) {
            return -1;
        }
        deleteNode(n);
        addNodeToHead(n);

        return n.value;
    }



    public void put(int key, int value) {
        Node n = nodeMap.get(key);
        Node tmp = new Node(key, value);
        nodeMap.put(key, tmp);
        if (n == null) {
            addNodeToHead(tmp);
        } else {
            deleteNode(tmp);
            addNodeToHead(tmp);
        }
        if (nodeMap.size() > capacity) {
            // delete tail node
            nodeMap.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
    }


    private void deleteNode(Node node) {
        if (node == null || node == head || node == tail) return;

        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }


    private void addNodeToHead(Node node) {
        if (node == null || node == head || node == tail) return;

        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }



    class Node {

        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }


}
