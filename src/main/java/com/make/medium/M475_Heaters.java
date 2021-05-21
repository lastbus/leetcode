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


    public int distance(int[] heaters, int pos) {
        int min = Integer.MAX_VALUE;
        for (int heater : heaters) {
            min = Math.min(min, Math.abs(pos - heater));
        }
        return min;
    }

}
