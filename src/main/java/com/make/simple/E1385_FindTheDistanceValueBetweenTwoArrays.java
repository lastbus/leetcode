package com.make.simple;

/**
 * @author make
 * @create 2021-04-21
 */
public class E1385_FindTheDistanceValueBetweenTwoArrays {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int c = 0;
        for (int i = 0; i < arr1.length; i++) {
            boolean f = true;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    f = false;
                    break;
                }
            }
            if (f) c++;
        }
        return c;
    }

}
