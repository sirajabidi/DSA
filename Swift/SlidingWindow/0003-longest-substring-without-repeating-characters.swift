class Solution {
    func lengthOfLongestSubstring(_ s: String) -> Int {
        if (s.isEmpty) {
            return 0
        }
        
        if (s.count == 1) {
            return 1
        }
        
        var left = 0
        var right = 0
        
        var cache: [Character: Int] = Dictionary()
        
        var result = 0
        
        while right <= s.count-1 {
            let rightIndex = s.index(s.startIndex, offsetBy: right)
            
            let charAtRight = s[rightIndex]
            cache[charAtRight] = (cache[charAtRight] != nil) ? (cache[charAtRight]! + 1) : 1
            

            while cache[charAtRight]! > 1 {
                let leftIndex = s.index(s.startIndex, offsetBy: left)
                let charAtLeft = s[leftIndex]
                cache[charAtLeft] = cache[charAtLeft]! - 1
                left += 1
            }
            
            result = max(result, right-left+1)
            right += 1
        }
        
        return result
    }
}