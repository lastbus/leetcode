package com.make.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author make
 * @create 2021-04-30
 */
public class M155_MinStack {

    Deque<Integer> stack1 = new LinkedList<Integer>();
    Deque<Integer> stack2 = new LinkedList<Integer>();

    /** initialize your data structure here. */
    public M155_MinStack() {

    }

    public void push(int val) {
        stack1.push(val);
        Integer min = stack2.peek();
        if (min == null) {
            stack2.push(val);
        } else {
            stack2.push(min < val ? min : val);
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }

}
