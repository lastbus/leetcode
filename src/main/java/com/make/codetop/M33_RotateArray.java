package com.make.codetop;

/**
 * @author make
 * @create 2022-04-27
 */
public class M33_RotateArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;

        int left = 0;
        int right = n - 1;


        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {

            } else if (nums[mid] < target) {

            }

        }

        return -1;
    }
}
