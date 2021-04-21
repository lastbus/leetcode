package com.make.medium;

import java.util.Arrays;

/**
 * @author make
 * @create 2021-04-21
 */
public class M56_MergeIntervals {

    public int[][] merge(int[][] intervals) {
        int[][] res = new int[intervals.length][2];
        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] < arr2[0] ? -1 : (arr1[0] == arr2[0] ? 0 : 1));
        int start = intervals[0][0];
        int end = intervals[0][1];
        int resRow = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(intervals[i][1], end);
            } else {
                res[resRow] = new int[]{start, end};
                resRow++;
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res[resRow] = new int[]{start, end};
        resRow++;
        int[][] res2 = new int[resRow][2];
        System.arraycopy(res, 0, res2, 0, resRow);
        return res2;
    }

}
