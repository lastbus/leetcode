package com.make.simple;

/**
 * @author make
 * @create 2021-06-06
 */
public class E169_MajorityElement {

    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

}
