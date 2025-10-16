/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique 
combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 
150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
*/

class Solution {
    private void _helper(int[] candidates, int target, int currentSum, int startIndex, List<Integer> current, List<List<Integer>> results) {
        if (currentSum > target) {
            return;
        }
        if (currentSum == target) {
            List<Integer> newCurrent = new ArrayList<>(current);
            results.add(newCurrent);
            return;
        }
        
        for (int i=startIndex; i<candidates.length; i++) {
            current.add(candidates[i]);
            _helper(candidates, target, currentSum+candidates[i], i, current, results);
            current.removeLast();
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) { 
            return new ArrayList<>();
        }
        if (candidates.length == 1) {
            if (candidates[0] == target) {
                List<List<Integer>> res = new ArrayList<>();
                List<Integer> list = new ArrayList<>();
                list.add(candidates[0]);
                res.add(list);
                return res;
            } else {
                return new ArrayList<>();
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        _helper(candidates, target, 0, 0, list, result);
        return result;
    }
}