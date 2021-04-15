package com.make.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author make
 * @create 2021-04-15
 */
public class M820_ShortEncodingOfWords {

    public int minimumLengthEncoding(String[] words) {
        Set<String> good = new HashSet<String>(Arrays.asList(words));
        for (String word: words) {
            for (int k = 1; k < word.length(); ++k) {
                good.remove(word.substring(k));
            }
        }

        int ans = 0;
        for (String word: good) {
            ans += word.length() + 1;
        }
        return ans;
    }


}
