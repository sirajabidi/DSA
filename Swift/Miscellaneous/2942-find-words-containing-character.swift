class Solution {
    func findWordsContaining(_ words: [String], _ x: Character) -> [Int] {
        if (words.isEmpty) {
            return []
        }
        
        var indices: [Int] = Array()
        
        for index in 0...words.count-1 {
            var word = words[index]
            var charIndex = word.firstIndex(of: x)
            if (charIndex != nil) {
                indices.append(index)
            }
        }
        return indices
    }
}