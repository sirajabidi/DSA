/*
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must be unique and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
*/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums1) {
            seen.add(num);
        }

        Set<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (seen.contains(num)) {
                result.add(num);
            }
        }

        int[] output = new int[result.size()];
        int index = 0;
        for (int num : result) {
            output[index++] = num;
        }
        return output;
    }
}
