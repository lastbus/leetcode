package com.make.medium;

import java.util.HashMap;

/**
 * @author make
 * @create 2021-05-04
 */
public class M560_SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap < Integer, Integer > mp = new HashMap< >();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1, 1, 1};
        M560_SubarraySumEqualsK abc = new M560_SubarraySumEqualsK();
        System.out.println(abc.subarraySum(a, 3));

    }

}
