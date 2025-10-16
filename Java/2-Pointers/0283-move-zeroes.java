/*
Given an integer array nums, move all 0's to the end of it while maintaining the 
relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.
*/

class Solution {
    public void moveZeroes(int[] nums) {
        int t = 0;
        int i = 0;
        int arrayBound = nums.length-1;
        while((t<=arrayBound) || (i<=arrayBound)) {
            if (t > arrayBound) {
                nums[i] = 0;
                i = i+1;
                continue;
            }

            if (nums[t] != 0) {
                nums[i] = nums[t];
                t = t+1;
                i = i+1;
            } else {
                t = t+1;
            }

            
        }
    }
}