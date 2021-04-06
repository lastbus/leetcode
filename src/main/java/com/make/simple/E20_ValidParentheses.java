package com.make.simple;

import java.util.Stack;

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

}
