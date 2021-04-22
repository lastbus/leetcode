package com.make.medium;

/**
 * @author make
 * @create 2021-04-22
 */
public class M11_ContainerWithMostWater {

    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int area = 0;
        while (start < end) {
            int tmpArea = Math.min(height[start], height[end]) * (end - start);
            area = Math.max(area, tmpArea);
            if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }
        return area;
    }

}
