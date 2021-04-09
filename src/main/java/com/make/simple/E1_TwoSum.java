package com.make.simple;

/**
 * @author make
 * @create 2021-04-09
 */
public class E1_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

}
