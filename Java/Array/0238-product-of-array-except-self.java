/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of 
all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length==0 || nums.length==1) {
            return nums;
        }

        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        int[] suffix = new int[nums.length];
        suffix[suffix.length-1] = nums[nums.length-1];

        int[] result = new int[nums.length];

        int pWritre = 1;
        int sWrite = nums.length-2;

        int pRead = 1;
        int sRead = nums.length-2;

        while ((pRead <= nums.length-1) && (sRead >= 0)) {
            prefix[pWritre] = prefix[pWritre-1] * nums[pRead];
            pWritre++;
            pRead++;

            suffix[sWrite] = suffix[sWrite+1] * nums[sRead];
            sWrite--;
            sRead--;
        }

        for (int i=0; i<=nums.length-1; i++) {
            result[i] = (i>=1 ? prefix[i-1] : 1) * (i<=nums.length-2 ? suffix[i+1] :  1);
        }
        return result;
    }
}