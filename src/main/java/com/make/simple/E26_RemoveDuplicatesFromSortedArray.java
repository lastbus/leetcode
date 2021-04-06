package com.make.simple;

/**
 * @author make
 * @create 2019-12-29
 */
public class E26_RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int previous = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[previous]) {
                previous += 1;
                if (i > previous) {
                    nums[previous] = nums[i];
                }
            }
        }
        return previous + 1;
    }

}
