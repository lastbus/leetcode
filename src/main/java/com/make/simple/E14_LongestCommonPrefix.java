package com.make.simple;

/**
 * @author make
 * @create 2019-12-28
 */
public class E14_LongestCommonPrefix {

    /**
     * this one is faster than the other
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String first = strs[0];
        int position = 0;
        boolean stop = false;
        int length = first.length();
        for (int i = 0; i < length; i++) {
            char alpha = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != alpha) {
                    stop = true;
                    break;
                }
            }
            if (stop) {
                break;
            }
            position = i + 1;
        }
        return first.substring(0, position);
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String first = strs[0];
        String commonPrefix = "";
        boolean stop = false;
        int length = first.length();
        for (int i = 1; i <= length; i++) {
            String prefix = first.substring(0, i);
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(prefix)) {
                    stop = true;
                    break;
                }
            }
            if (stop) {
                break;
            }
            commonPrefix = prefix;
        }

        return commonPrefix;
    }

}
