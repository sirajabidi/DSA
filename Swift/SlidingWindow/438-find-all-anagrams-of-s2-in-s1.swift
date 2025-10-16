/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. 
You may return the answer in any order.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/

class Solution {
    func currentWindowValid(_ win: inout [Character: Int], _ pFreqMap: inout [Character: Int]) -> Bool {
        if (win.count != pFreqMap.count) {
            return false
        }
        
        for i in pFreqMap.keys {
            if (win[i] == nil) {
                return false
            }
            
            if (win[i] != pFreqMap[i]) {
                return false
            }
        }
        return true
    }

    func findAnagrams(_ s: String, _ p: String) -> [Int] {
        if (p.count > s.count) {
            return []
        }
        
        var pFreqMap : [Character: Int] = Dictionary()
        for c in p {
            pFreqMap[c] = (pFreqMap[c] != nil) ? pFreqMap[c]! + 1 : 1
        }
        
        var l = 0
        var r = 0
        var result: [Int] = []
        
        var win: [Character: Int] = Dictionary()
        
        while r <= s.count-1 {
            let rIndex = s.index(s.startIndex, offsetBy: r)
            let rCurrentChar = s[rIndex]
            
            if (pFreqMap[rCurrentChar] == nil) {
                r += 1
                l = r
                win = Dictionary()
                continue
            }
            
            win[rCurrentChar] = (win[rCurrentChar] != nil) ? win[rCurrentChar]! + 1 : 1
            
            while win[rCurrentChar]! > pFreqMap[rCurrentChar]! {
                let lIndex = s.index(s.startIndex, offsetBy: l)
                let lCurrentChar = s[lIndex]
                if (win[lCurrentChar]! == 1) {
                    win.removeValue(forKey: lCurrentChar)
                } else {
                    win[lCurrentChar] = win[lCurrentChar]! - 1
                }
                l += 1
            }
            
            if (currentWindowValid(&win, &pFreqMap)) {
                result.append(l)
                win = Dictionary()
                l += 1
                r = l
            } else {
                r += 1
            }
        }
        return result
    }
}