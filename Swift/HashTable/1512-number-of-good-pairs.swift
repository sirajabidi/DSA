class Solution {
    func numIdenticalPairs(_ nums: [Int]) -> Int {
        var goodPairs = 0
        var cache = [Int:Int]()
        for num in nums {
            if let freq = cache[num] {
                goodPairs = goodPairs + freq
                cache[num] = freq+1
            } else {
                cache[num] = 1
            }
        }
        return goodPairs
    }
}