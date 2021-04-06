package com.make.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author make
 * @create 2021-04-01
 */
public class M146_LruCache {

    public static void main(String[] args) {
        LRUCache2 lruCache = new LRUCache2(2);
        lruCache.put(1, 0);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

        test1();


    }

    public static void test1() {
        LRUCache2 lruCache = new LRUCache2(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        System.out.println("====");
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
    }
}


class LRUCache {
    private Map<Integer, Node> cache;
    private int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        cache = new ConcurrentHashMap<Integer, Node>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            if (node != head) {
                Node tmp = head;
                if (node == tail) {
                    tail = node.pre;
                }
                if (node.pre != null) {
                    node.pre.next = node.next;
                }
                if (node.next != null) {
                    node.next.pre = node.pre;
                }
                head = node;
                node.pre = null;
                node.next = tmp;
                tmp.pre = node;
            }
            return node.value;
        }
    }

    public void put(int key, int value) {

        Node oldNode = cache.get(key);
        if (cache.size() + 1 > capacity && oldNode == null) {
            cache.remove(tail.key);
            tail = tail.pre;
            if (tail != null) {
                tail.next = null;
            }
        }

        Node node = new Node(key, value);
        cache.put(key, node);

        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        node.next = head;
        head.pre = node;
        head = node;

        if (oldNode != null) {
            removeNode(oldNode);
        }
    }


    private void removeNode(Node node) {
        if (node == null) return;
        if (tail == node) {
            tail = tail.pre;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            node.pre.next = node.next;
            if (node.next != null) {
                node.next.pre = node.pre;
                node.next = null;
                node.pre = null;
            }
        }
    }

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}


class LRUCache2 {
    private Map<Integer, DeLinkedNode> cache = new HashMap<>();
    private DeLinkedNode head;
    private DeLinkedNode tail;
    private int capacity;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        head = new DeLinkedNode();
        tail = new DeLinkedNode();
        head.next = tail;
        head.pre = null;
        tail.pre = head;
        tail.next = null;
    }

    public int get(int key) {
        DeLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {

        DeLinkedNode oldNode = cache.get(key);

        if (oldNode == null) { // not found
            DeLinkedNode node = new DeLinkedNode(key, value);
            cache.put(key, node);
            addNode(node);
            if (cache.size() > capacity) {
                // remove tail
                DeLinkedNode tail = popTail();
                // remove node
                cache.remove(tail.key);
            }

        } else {
            oldNode.value = value;
            moveToHead(oldNode);
        }

    }

    class DeLinkedNode {
        int key;
        int value;
        DeLinkedNode pre;
        DeLinkedNode next;

        public DeLinkedNode() {}

        public DeLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void addNode(DeLinkedNode node) {
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DeLinkedNode node) {
        DeLinkedNode pre = node.pre;
        DeLinkedNode next = node.next;

        pre.next = next;
        next.pre = pre;
    }

    private void moveToHead(DeLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private DeLinkedNode popTail() {
        DeLinkedNode t = tail.pre;
        removeNode(t);
        return t;
    }

}
