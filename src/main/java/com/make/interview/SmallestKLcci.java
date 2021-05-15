package com.make.interview;

/**
 * @author make
 * @create 2021-05-15
 */
public class SmallestKLcci {

    public int[] smallestK(int[] arr, int k) {
        partition(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    public void partition(int[] arr, int left, int right, int k) {
        if (left >= right) return;
        int pivot = arr[left];
        int i = left, j = right;
        while (i < j) {
            while (arr[j] >= pivot && i < j) j--;
            while (arr[i] <= pivot && i <j) i++;
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        arr[left] = arr[i];
        arr[i] = pivot;
        if (k == i) {
            return;
        } else if (k < i) {
            partition(arr, left, i - 1, k);
        } else {
            partition(arr, i + 1, right, k);
        }
    }

}
