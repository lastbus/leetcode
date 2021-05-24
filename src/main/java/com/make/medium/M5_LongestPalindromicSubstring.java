package com.make.medium;

/**
 * @author make
 * @create 2021-05-24
 */
public class M5_LongestPalindromicSubstring {

    // over time limit
    public String longestPalindrome(String s) {
        String tmp = null;
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (isHuiWen(s, i, j) && (j - i + 1) > size) {
                    size = j - i + 1;
                    tmp = s.substring(i, j + 1);
                }
            }
        }
        return tmp;
    }

    public boolean isHuiWen(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

}
