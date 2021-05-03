package com.make.medium;

import java.util.Arrays;

/**
 * @author make
 * @create 2021-05-03
 */
public class M945_MinimumIncrementToMakeArrayUnique {

    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int ans = 0, taken = 0;

        for (int i = 1; i < A.length; ++i) {
            if (A[i - 1] == A[i]) {
                taken++;
                ans -= A[i];
            } else {
                int give = Math.min(taken, A[i] - A[i - 1] - 1);
                ans += give * (give + 1) / 2 + give * A[i - 1];
                taken -= give;
            }
        }

        if (A.length > 0) {
            ans += taken * (taken + 1) / 2 + taken * A[A.length - 1];
        }

        return ans;
    }

}
