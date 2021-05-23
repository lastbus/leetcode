package com.make.interview;

/**
 * @author make
 * @create 2021-05-23
 */
public class SortedMergeLcci {

    public void merge(int[] A, int m, int[] B, int n) {
        if (n == 0) return;
        int[] res = new int[m + n];
        int i = 0, j = 0, cur = 0;
        while (i < m || j < n) {
            if (i == m) {
                res[cur++] = B[j++];
            } else if (j == n) {
                res[cur++] = A[i++];
            } else if (A[i] <= B[j]) {
                res[cur++] = A[i++];
            } else {
                res[cur++] = B[j++];
            }
        }
        for (int index = 0; index < m + n; index++) {
            A[index] = res[index];
        }
    }

}
