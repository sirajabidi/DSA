/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in 
the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
*/

class Solution {
    func containsNearbyDuplicate(_ nums: [Int], _ k: Int) -> Bool {
        if (nums.isEmpty || nums.count==1 || k==0) {
		    return false
        }

        var cache: Set<Int> = Set()
        
        for i in 0...nums.count-1 {
            if (cache.contains(nums[i])) {
                return true
            }
            if (cache.count == k) {
                let windowStartsAtIndex = i-k

                // let's delete the item at start of the window :
                let itemToDelete = nums[windowStartsAtIndex]
                cache.remove(itemToDelete)
            }
            
            cache.insert(nums[i])
        }
        return false
    }
}