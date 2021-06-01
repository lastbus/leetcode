package com.make.simple;

/**
 * @author make
 * @create 2021-06-01
 */
public class E53_MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        int i = 0;
        int j = 100;
        System.out.println();
    }

}
