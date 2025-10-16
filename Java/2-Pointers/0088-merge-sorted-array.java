/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, 
representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. 
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, 
and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        int readOne = m-1;
        int readTwo = n-1;
        int write = nums1.length-1;

        while((readOne > -1) || (readTwo > -1)) {
            if (readOne < 0) {
                nums1[write] = nums2[readTwo];
                readTwo--;
                write--;
                continue;
            }
            if (readTwo < 0) {
                return;
            }
            if (nums1[readOne] > nums2[readTwo]) {
                nums1[write] = nums1[readOne];
                readOne--;
                write--;
            } else {
                nums1[write] = nums2[readTwo];
                readTwo--;
                write--;
            }
        }
    }
}