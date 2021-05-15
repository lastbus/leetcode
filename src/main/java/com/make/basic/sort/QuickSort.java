package com.make.basic.sort;

import java.util.Arrays;

/**
 * @author make
 * @create 2021-05-15
 */
public class QuickSort {

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

    public static void main(String[] args) {
        int[] a = {1,2,3};

        sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

}
