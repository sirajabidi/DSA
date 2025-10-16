class Solution {
    func compress(_ chars: inout [Character]) -> Int {
        if (chars.isEmpty) {
		return 0
        }
        
        if (chars.count == 1) {
            return 1
        }
        
        var r = 0
        var w = 0
        var currentCharFreq = 1
        
        while r <= chars.count - 1 {
            var currentChar: Character = chars[r]
            var nextToCurrentChar: Character? = (r+1 > chars.count-1) ? nil : chars[r+1]
            
            if (currentChar == nextToCurrentChar) {
                currentCharFreq += 1
                r = r + 1
            } else {
                chars[w] = currentChar
                w += 1
                if (currentCharFreq == 1) {
                    // Don't do anything
                } else {
                    var freqStr = String(currentCharFreq)
                    for i in 0...freqStr.count-1 {
                        let index = freqStr.index(freqStr.startIndex, offsetBy: i)
                        var f = freqStr[index]
                        chars[w] = f
                        w += 1
                    }
                }
                r += 1
                currentCharFreq = 1
		    }
	    }
    return w
    }
}