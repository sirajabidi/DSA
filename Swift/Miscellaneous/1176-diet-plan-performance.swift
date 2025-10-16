class Solution {
    func dietPlanPerformance(_ calories: [Int], _ k: Int, _ lower: Int, _ upper: Int) -> Int {
        var prefixArray : [Int] = []
        
        for i in 0...calories.count-1 {
            var prefixCalorie = (i == 0) ? calories[i] : (prefixArray[i-1] + calories[i])
            prefixArray.append(prefixCalorie)
        }
        
        var wS = -1
        var wE = k-1
        var points = 0
        
        while (wE <= prefixArray.count-1) {
            var totalCaloriesInWindow = prefixArray[wE] - ((wS >= 0) ? prefixArray[wS] : 0)
            
            if (totalCaloriesInWindow < lower) {
                points = points - 1
            }
            if (totalCaloriesInWindow > upper) {
                points = points + 1
            }
            wE += 1
            wS += 1
        }
        return points
    }
}