package com.make.medium;

/**
 * @author make
 * @create 2021-04-21
 */
public class M55_JumpGame {

    public boolean canJump(int[] nums) {
        for (int i = nums.length - 1; i >= 1; i--) {
            if (!canJump(nums, i)) return false;
        }
        return true;
    }

    public boolean canJump(int[] nums, int end) {
        for (int i = 1; end - i >= 0; i++) {
            if (i <= nums[end - i]) {
                return true;
            }
        }
        return false;
    }

    // official solution, nicer
    public boolean canJump2(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }


}
