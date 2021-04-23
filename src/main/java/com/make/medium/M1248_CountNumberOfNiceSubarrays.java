package com.make.medium;

/**
 * @author make
 * @create 2021-04-23
 */
public class M1248_CountNumberOfNiceSubarrays {

    // over time limit
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int odd = 0;
            int j = i;
            for (; j < nums.length; j++) {
                if (nums[j] % 2 == 1) {
                    if (odd < k) {
                        odd++;
                    } else {
                        break;
                    }
                }
                if (odd == k) count++;
            }
            if (odd == 0 && j == nums.length) break;
        }
        return count;
    }

    // official solution
    public int numberOfSubarrays2(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int oddCount = 0;
        int count = 0;
        while (right < nums.length) {
            if ((nums[right++] & 1) == 1) {
                oddCount++;
            }
            if (oddCount == k) {
                int rightCount = 1;
                while (right < nums.length && (nums[right] & 1) == 0) {
                    right++;
                    rightCount++;
                }
                int leftCount = 1;
                while ((nums[left] & 1) == 0) {
                    left++;
                    leftCount++;
                }
                count += leftCount * rightCount;
                oddCount--;
                left++;
            }
        }
        return count;
    }

}
