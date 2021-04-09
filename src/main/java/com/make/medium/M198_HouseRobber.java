package com.make.medium;

/**
 * @author make
 * @create 2021-04-09
 */
public class M198_HouseRobber {


    public int rob(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        int[] s = new int[nums.length];
        s[0] = nums[0];
        s[1] = nums[0] >= nums[1] ? nums[0] : nums[1];
        for (int i = 2; i < nums.length; i++) {
            s[i] = (s[i - 2] + nums[i]) >= s[i - 1] ? (s[i - 2] + nums[i]) : s[i - 1];
        }
        return s[nums.length - 1];
    }

    public int rob2(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        int s1 = nums[0];
        int s2 = nums[0] >= nums[1] ? nums[0] : nums[1];
        int s3 = s2;
        for (int i = 2; i < nums.length; i++) {
            s3 = (s1 + nums[i]) >= s2 ? (s1 + nums[i]) : s2;
            s1 = s2;
            s2 = s3;
        }
        return s3;
    }


}
