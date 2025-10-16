/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < nums.length; i++) {
            int startIndexForJ = 0;
            int endIndexForJ = i-1;
            int maxLIS = -1;
            for (int j = startIndexForJ; j <= endIndexForJ; j++) {
                if (nums[j] < nums[i]) {
                    maxLIS = Math.max(maxLIS, dp[j]);
                }
            }
            if (maxLIS != -1) {
                dp[i] = maxLIS + 1;    
            }
        }

        int max = Arrays.stream(dp).max().orElseThrow();
        return max;
    }
}