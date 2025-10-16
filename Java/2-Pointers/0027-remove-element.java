/*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. 
The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. 
The remaining elements of nums are not important as well as the size of nums.
Return k.
*/


/* Insight : forward pointer will find val and backward pointer represent where could the val found by forward can be 
             written to. So backward pointer waits at non-val value and once forward has found a val we swap the
            values and move both forward and backward.
            
*/
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return (nums[0] == val) ? 0 : 1;
        }
        
        int forward = 0, backward = nums.length - 1;
        while(forward <= backward) {
            if ((nums[forward] == val) && (nums[backward] != val)) {
                int tmp = nums[forward];
                nums[forward] = nums[backward];
                nums[backward] = tmp;
                forward++;
                backward--;
            } else if (nums[forward] == val) {
                backward--;
            } else {
                forward++;
            }
        }
        return backward+1;
    }
}