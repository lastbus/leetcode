package com.make.codetop;

import java.util.HashSet;
import java.util.Set;

/**
 * @author make
 * @create 2022-04-25
 */
public class M3LengthOfLongestSubstring {


    public int lengthOfLongestSubstring_1(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLength = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int j = i;
            Set<Character> set = new HashSet<>();
            while (j < n && ! set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            }
            maxLength = Math.max(maxLength, set.size());
        }

        return maxLength;
    }


    public int lengthOfLongestSubstring_2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int n = s.length();
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && ! set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
            }
            maxLength = Math.max(maxLength, j - i);
            set.remove(s.charAt(i));
        }
        return maxLength;
    }




    public static void main(String[] args) {


    }

}
