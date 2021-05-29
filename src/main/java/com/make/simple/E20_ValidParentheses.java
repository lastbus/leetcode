package com.make.simple;

import java.util.*;

/**
 * @author make
 * @create 2019-12-28
 */
public class E20_ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    char h1 = stack.isEmpty() ? ' ' : stack.pop();
                    if (h1 != '(') {
                        return false;
                    }
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '}':
                    char h2 = stack.isEmpty() ? ' ' : stack.pop();
                    if (h2 != '{') {
                        return false;
                    }
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ']':
                    char h3 = stack.isEmpty() ? ' ' : stack.pop();
                    if (h3 != '[') {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }


}
