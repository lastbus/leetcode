package com.make.codetop;

/**
 * @author make
 * @create 2022-04-25
 */
public class M215_FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int target = n - k;
        return quickSort(nums, 0, n - 1, target);
    }


    public int quickSort(int[] nums, int start, int end, int target) {
        int left = start;
        int right = end;
        int base = nums[left];

        while (left < right) {
            while (left < right && nums[right--] >= base);
            while (left < right && nums[left++] <= base);
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }

        if (target == left) {
            return nums[left];
        }
        nums[start] = nums[left];
        nums[left] = base;
        if (target > left) {
            return quickSort(nums, left + 1, end , target);
        } else {
            return quickSort(nums, start, left - 1, target);
        }
    }

}
