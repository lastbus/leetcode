package com.make.simple;

/**
 * @author make
 * @create 2021-05-30
 */
public class E35_SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = (right + left) >> 1;
            if (target == nums[mid]) return mid;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
