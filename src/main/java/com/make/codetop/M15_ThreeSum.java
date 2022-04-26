package com.make.codetop;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author make
 * @create 2022-04-26
 */
public class M15_ThreeSum {


    public List<List<Integer>> threeSum(int[] nums) {
        int[] numsSort = new int[nums.length];
        System.arraycopy(nums, 0, numsSort, 0, nums.length);
        Arrays.sort(numsSort);

        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < numsSort.length; i++) {
            int k = numsSort.length - 1;
            for (int j = i + 1; j < numsSort.length; j++) {
                for (; k > j; k--) {
                    if (numsSort[i] + numsSort[j] + numsSort[k] == 0) {
                        List<Integer> zeroList = new LinkedList<>();
                        zeroList.add(numsSort[i]);
                        zeroList.add(numsSort[j]);
                        zeroList.add(numsSort[k]);
                    }
                }
            }

        }
        return result;
    }

}
