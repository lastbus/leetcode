package com.make.hard;

/**
 * @author make
 * @create 2021-04-10
 */
public class H1392_LongestHappyPrefix {

    // my solution, over time limit
    public String longestPrefix(String s) {
        if (s == null) return "";
        int head = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(head) == s.charAt(i)) {
                head++;
                int j = i + 1;
                for (; j < s.length(); j++) {
                    if (s.charAt(head) != s.charAt(j)) break;
                    head++;
                }
                if (j == s.length()) {
                    break;
                } else {
                    head = 0;
                }
            } else {
                head = s.charAt(0) == s.charAt(i) ? 1 : 0;
            }
        }
        return s.substring(0, head);
    }

    public static void main(String[] args) {
        H1392_LongestHappyPrefix happyPrefix = new H1392_LongestHappyPrefix();
        System.out.println(happyPrefix.longestPrefix("level"));
    }
}
