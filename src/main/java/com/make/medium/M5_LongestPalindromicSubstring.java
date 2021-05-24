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

    public String longestPalindrome2(String s) {
        int maxLength = 1;
        int start = 0;

        char[] array = s.toCharArray();
        int n = array.length;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int L = 2; L <= n; L++) {
            for (int i = 0; i < n; i++) {
                // L = j - i + 1
                int j = L + i - 1;
                if (j >= n) break;
                if (array[i] != array[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && L > maxLength) {
                    maxLength = j - i + 1;
                    start = i;
                }
            }

        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        String s = "aaaa";
        M5_LongestPalindromicSubstring m5 = new M5_LongestPalindromicSubstring();
        System.out.println(m5.longestPalindrome2(s));
    }
}
