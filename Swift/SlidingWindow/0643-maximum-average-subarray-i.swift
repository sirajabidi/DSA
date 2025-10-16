class Solution {
    func findMaxAverage(_ nums: [Int], _ k: Int) -> Double {
        if (k == 0 || nums.isEmpty) {
		    return 0
        }
        
        if (k > nums.count) {
            return 0
        }

        var prefixArray : [Int] = []
        
        for i in 0...nums.count-1 {
            var prefixSum = nums[i] + ((i-1 >= 0) ? prefixArray[i-1] : 0)
            prefixArray.append(prefixSum)
        }

        var wS = -1
        var wE = k - 1
        var maxAvg = Double(Int.min)
        
        while (wE <= prefixArray.count-1) {
            var  windowSum = prefixArray[wE] - (wS >= 0 ? prefixArray[wS] : 0)
            var windowAvg : Double = Double(Double(windowSum)/Double(k))
            if (windowAvg > maxAvg) {
                maxAvg = windowAvg
            }
            wS += 1
            wE += 1
        }
        return maxAvg
    }
}