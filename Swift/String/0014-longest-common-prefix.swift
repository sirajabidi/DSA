class Solution {
    func longestCommonPrefix(_ strs: [String]) -> String {
        if strs.isEmpty {
            return ""
        }
        if strs.count == 1 {
            return strs[0]
        }
        
        var lcp = strs[0]
        var index = 1
        
        while index <= strs.count - 1 {
            lcp = lcp.commonPrefix(with: strs[index], options: .caseInsensitive)
            index += 1
        }
        
        return lcp
    }
}