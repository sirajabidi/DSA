/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
*/

class Solution {
    /* Working principle:
     to find all subArrays whose sum is equal to target we use prefix-sum. 
     arr =        [1,3,0,-1,5,2]
     prefixSum =  [1,4,4,3,8,10]
     prefixSum at index i is equal to the of all items in arr upto index 1. In a sense 
     that's the sum of subArray from index 0 to index i for arr. So if a item prefixSum 
     array is equal to target at-least that is one subArray from index 0 to index i which 
     is part of answer as it's total is equal to target. 

     - Now we have to find other subArrays which does not start from index 0 and whose sum is equalt o target. For this observe this property of prefixSum array. If we have to find the sum of items from index (2,4) then this can be found by preffixSum[4]-prefixSum[2-1] i.e prefixSum[j] - prefixSum[i-1] where i is the startIndex and j in the endIndex of any subArray.

     Hence for a targetSum we can say :  targetSum = prefixSum[j] - prefixSum[i-1]
     or : prefixSum[i-1] = prefixSum[j] - targetSum (this means for every prefixSum in prefixSum array the value is the sum of items from 0 to that index in arr buut if there exists a prefixSum previously in prefixSum array which is equal to the diff of current prefixSum minus the targetSum then there is a subArray starting from between whose is equal to the target.) 

     The existenvce is tracked by HashMap and how many times is tracked by frequnecy
    */
    public int subarraySum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int prefixSum = 0;
        int subArrayCount = 0;

        for(int num: nums) {
            prefixSum = prefixSum + num;

            // if prefixSum is equal to target at-leat that subArray from index 0 to curent item is part of the answer . Thus increment by 1:
            if (prefixSum == target) {
                subArrayCount++;
            }
            
            // and then we check if a prefixSum equal to the diff of currentPrefixSim and targetSum already exists and by what frequnecy. Frequency denotes that many different spanni g subArrays which when excluded from subArray spanning from index 0 to current will give us a middle subArray whose sum is equal to target:
            subArrayCount += map.getOrDefault(prefixSum-target, 0);

            int freqency = map.getOrDefault(prefixSum, 0);
            map.put(prefixSum, freqency+1);
        }
        return subArrayCount;
    }
}