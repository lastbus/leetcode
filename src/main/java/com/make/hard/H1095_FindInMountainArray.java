package com.make.hard;

/**
 * @author make
 * @create 2021-04-24
 */
public class H1095_FindInMountainArray {

     interface MountainArray {
         public int get(int index);
         public int length();
     }

     // my solution
     public int findInMountainArray(int target, MountainArray mountainArr) {
         int left = 0, n = mountainArr.length();
         int right = n - 1;
         int peak = -1;
         while (left < right) {
             int mid = (left + right) >> 1;
             int midValue = mountainArr.get(mid);
             if (mountainArr.get(mid - 1) < midValue && midValue > mountainArr.get(mid + 1)) {
                 peak = mid;
                 break;
             }
             if (midValue < mountainArr.get(mid + 1)) {
                 left = mid;
             } else {
                 right = mid;
             }
         }
         // search left side
         left = 0;
         right = peak;
         while (left <= right) {
             int mid = (left + right) >> 1;
             int midValue = mountainArr.get(mid);
             if (midValue == target) return mid;
             if (midValue > target) {
                 right = mid - 1;
             } else {
                 left = mid + 1;
             }
         }
         // search right side
         left = peak + 1;
         right = n - 1;
         while (left <= right) {
             int mid = (left + right) >> 1;
             int midValue = mountainArr.get(mid);
             if (midValue == target) return mid;
             if (midValue < target) {
                 right = mid - 1;
             } else {
                 left = mid + 1;
             }
         }
         return -1;
     }


}

