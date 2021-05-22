package com.make.medium;

/**
 * @author make
 * @create 2021-05-21
 */
public class M475_Heaters {

    public int findRadius(int[] houses, int[] heaters) {
        // Arrays.sort(heaters);
        int radis = 0;
        for (int house : houses) {
            radis = Math.max(radis, distance(heaters, house));
        }
        return radis;
    }


    public int distance2(int[] heaters, int pos) {
        int min = Integer.MAX_VALUE;
        for (int heater : heaters) {
            min = Math.min(min, Math.abs(pos - heater));
        }
        return min;
    }

    public int distance(int[] heaters, int pos) {
        int left = 0;
        int right = heaters.length - 1;

        int leftD = Math.abs(pos - heaters[left]);
        int rightD = Math.abs(pos - heaters[right]);

        while (left < right) {
            int mid = (left + right) >> 1;
            int midD = Math.abs(pos - heaters[mid]);
            if (midD <= rightD) {
                right = mid;
                rightD = Math.abs(pos - heaters[right]);
            } else {
                left = mid;
                leftD = Math.abs(pos - heaters[left]);
            }
        }
        return Math.abs(pos - heaters[left]);
    }

    public static void main(String[] args) {
        M475_Heaters solution = new M475_Heaters();
        int[] a =  {1, 2, 3, 4};
        int[] b = {1, 4};
        System.out.println(solution.findRadius(a, b));
    }

}
