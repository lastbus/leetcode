package com.make.simple;

/**
 * @author make
 * @create 2021-04-09
 */
public class E1160_FindWordsThatCanBeFormedByCharacters {

    public int countCharacters(String[] words, String chars) {
        if (words == null || words.length == 0 || chars == null || chars.length() == 0) return 0;
        int s = 0;
        for (String word : words) {
            boolean found = true;
            String charsTmp = chars;
            for (int i = 0; i < word.length(); i++) {
                if (charsTmp.indexOf(word.charAt(i)) == -1) {
                    found = false;
                    break;
                }
                charsTmp = charsTmp.replaceFirst(String.valueOf(word.charAt(i)), "");
            }
            if (found) s += word.length();
        }
        return s;
    }

}
