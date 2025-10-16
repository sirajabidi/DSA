class Solution {
    func getConcatenation(_ nums: [Int]) -> [Int] {
        var result = Array(repeating: 0, count: nums.count*2)
        for i in 0...nums.count-1 {
            result[i] = nums[i]
            result[i+nums.count] = nums[i]
        }
        return result
    }
}