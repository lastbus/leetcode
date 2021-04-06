package com.make.medium;

/**
 * @author make
 * @create 2021-04-04
 */
public class M707_DesignLinkedList {

    public static void main(String[] args) {

        //["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex",
        // "deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
        //[[],[7],[2],[1],[3,0],
        // [2],[6],[4],[4],[4],[5,0],[6]]
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(7); // 7
        list.addAtHead(2); // 2 7
        list.addAtHead(1); // 1 2 7
        list.addAtIndex(3, 0); // 1 2 7 0
        list.deleteAtIndex(2);  // 1 2 0
        list.addAtHead(6); // 6 1 2 0
        list.addAtTail(4); // 6 1 2 0 4
        System.out.println(list.get(4));
        list.addAtHead(4);
        list.addAtIndex(5,0);
        list.addAtHead(6);


//        System.out.println(list.size);

    }

    static class MyLinkedList {

        Node head;
        Node tail;
        int size;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            head = new Node(-1);
            tail = new Node(-1);

            head.pre = null;
            head.next = tail;

            tail.pre = head;
            tail.next = null;
            size = 0;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if (index > size - 1 || index < 0) return -1;
            int i = 0;
            Node tmp = head;
            while (i <= index || i < size) {
                tmp = tmp.next;
                if (i == index) return tmp.val;
                i++;
            }
            return -1;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            Node node = new Node(val, head, head.next);
            head.next.pre = node;
            head.next = node;
            size++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            Node node = new Node(val, tail.pre, tail);
            node.pre.next = node;
            tail.pre = node;
            size++;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index > size || index < 0) return;
            int i = 0;
            Node tmp = head;
            while (i < index) {
                tmp = tmp.next;
                i++;
            }
            Node node = new Node(val, tmp, tmp.next);
            tmp.next.pre = node;
            tmp.next = node;
            size++;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index >= size || index < 0) return;
            int i = 0;
            Node tmp = head;
            while (i <= index) {
                tmp = tmp.next;
                i++;
            }
            Node pre = tmp.pre;
            Node next = tmp.next;
            pre.next = next;
            next.pre = pre;
            tmp.pre = null;
            tmp.next = null;
            size--;
        }

        class Node {
            int val;
            Node pre;
            Node next;
            Node() {};
            Node(int val) {
                this.val = val;
            };
            Node(int val, Node pre, Node next) {
                this.val = val;
                this.pre = pre;
                this.next = next;
            }
        }
    }

}
