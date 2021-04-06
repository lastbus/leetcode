package com.make.simple;

/**
 * @author make
 * @create 2019-12-29
 */
public class E27_RemoveElement {


    /**
     * keep element order
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (p != i) {
                    nums[p] = nums[i];
                }
                p += 1;
            }
        }
        return p;
    }


    /**
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int j = nums.length - 1;
        for (int i = 0; i < nums.length && i <= j; i++) {
            if (nums[i] == val) {
                while (i <= j && j >= 0) {
                    if (nums[j] != val) {
                        nums[i] = nums[j];
                        j--;
                        break;
                    }
                    j--;
                }
            }
        }
        return j + 1;
    }




}
