package com.make.everyday;

/**
 * @author make
 * @create 2021-05-12
 */
public class M1310_XorQueriesOfSubarray {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int xor = 0;
            for (int j = q[0]; j <= q[1]; j++) {
                xor ^= arr[j];
            }
            res[i] = xor;
        }
        return res;
    }

}
