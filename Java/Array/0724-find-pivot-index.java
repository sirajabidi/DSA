/*
Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to 
the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. 
This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.


*/
class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefixArray = new int[nums.length];
        prefixArray[0] = nums[0];

        int[] suffixArray = new int[nums.length];
        suffixArray[nums.length-1] = nums[nums.length-1];

        int prefixWrite = 1;
        int suffixWrite = nums.length-2;
        for(int i=1; i<=nums.length-2; i++) {
            prefixArray[prefixWrite] = prefixArray[prefixWrite-1] + nums[i];
            suffixArray[suffixWrite] = suffixArray[suffixWrite+1] + nums[(nums.length-1)-i];
            prefixWrite++;
            suffixWrite--;
        }

        int pivotIndex = -1;
        for(int i=0; i<=nums.length-1; i++) {
            int leftSum = (i-1)>=0 ? prefixArray[i-1 ]: 0;
            int rightSum = (i+1)<=nums.length-1 ? suffixArray[i+1] : 0;
            if (leftSum == rightSum) {
                pivotIndex = i;
                break;
            } 
        }

        return pivotIndex;
    }
}