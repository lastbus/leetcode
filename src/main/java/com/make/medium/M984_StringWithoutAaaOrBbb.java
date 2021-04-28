package com.make.medium;

/**
 * @author make
 * @create 2021-04-28
 */
public class M984_StringWithoutAaaOrBbb {

    public String strWithout3a3b(int a, int b) {
        StringBuilder ans = new StringBuilder();

        while (a > 0 || b > 0) {
            boolean writeA = false;
            int L = ans.length();
            if (L >= 2 && ans.charAt(L-1) == ans.charAt(L-2)) {
                if (ans.charAt(L-1) == 'b')
                    writeA = true;
            } else {
                if (a >= b)
                    writeA = true;
            }

            if (writeA) {
                a--;
                ans.append('a');
            } else {
                b--;
                ans.append('b');
            }
        }

        return ans.toString();
    }

}
