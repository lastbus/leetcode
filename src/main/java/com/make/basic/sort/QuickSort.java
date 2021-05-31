package com.make.basic.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author make
 * @create 2021-05-15
 */
public class QuickSort {

    private static final Random random = new Random();

    /**
     * 在网上看到的垃圾算法
     * @param arr
     */
    public static void sort(int[] arr) {
        partition(arr, 0, arr.length - 1);
    }

    public static void partition(int[] arr, int start, int end) {
        if (start >= end) return;

        int pivot = arr[start];
        int i = start, j = end;
        while (i < j) {
            while (arr[j] >= pivot && i < j) j--;
            while (arr[i] <= pivot && i < j) i++;
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        arr[start] = arr[i];
        arr[i] = pivot;
        partition(arr, start, i - 1);
        partition(arr, i + 1, end);
    }

    /**
     * 标准算法
     * @param nums
     * @param start
     * @param end
     */
    public static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int p = randomPartition(nums, start, end);
            quickSort(nums, start, p - 1);
            quickSort(nums, p + 1, end);
        }
    }

    /**
     * 基准元素选择最右，最坏时间复杂度为 O(n^2)
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int partition2(int[] arr, int left, int right) {
        int base = arr[right], p = left;
        for (int i = left; i < right; i++) {
            if (arr[i] <= base) {
                swap(arr, i, p);
                p++;
            }
        }
        swap(arr, p, right);
        return p;
    }

    /**
     * 随机选择基准点，O(n)，空间复杂度：O(log n)
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int randomPartition(int[] arr, int left, int right) {
        int i = random.nextInt(right - left + 1) + left;
        swap(arr, right, i);
        return partition2(arr, left, right);
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        int[] a = {1,2,3,0, -1, -199};

        quickSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.println(i);
        }
    }

}
