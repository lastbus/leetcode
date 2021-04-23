package com.make.medium;

/**
 * @author make
 * @create 2021-04-23
 */
public class M33_SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int p = 0;
        for (; p < nums.length - 1; p++) {
            if (nums[p] > nums[p + 1]) break;
        }
        int res = binarySearch(nums, 0, p, target);
        if (res != -1) {
            return res;
        }
        return binarySearch(nums, p + 1, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) return -1;
        int mid = (start + end) >> 1;
        if (nums[mid] == target) {
            return mid;
        } else if (start == end) {
            return -1;
        } else if (nums[mid] > target) {
            return binarySearch(nums, start, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, end, target);
        }
    }


    // official solution
    public int search2(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) return mid;
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[n - 1] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
