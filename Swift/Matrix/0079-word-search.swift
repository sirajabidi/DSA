class Solution {
    func _existDfs(r: Int, c: Int, board: [[Character]], explored: inout [[Bool]], word: [Character],
			   currentWordIndex: Int, current: inout [Character]) -> Bool {
	
        if (current.count == word.count) {
            return true
        }
        
        if (r < 0 || r > board.count-1) {
            return false
        }
        
        if (c < 0 || c > board[0].count-1) {
            return false
        }
        
        if (explored[r][c]) {
            return false
        }
        
        if (board[r][c] != word[currentWordIndex]) {
            return false
        }

        explored[r][c] = true
        current.append(word[currentWordIndex])
        
        if (_existDfs(r: r, c: c+1, board: board, explored: &explored, word: word, currentWordIndex: currentWordIndex+1, current: &current)) {
            return true
        }
        
        if (_existDfs(r: r, c: c-1, board: board, explored: &explored, word: word, currentWordIndex: currentWordIndex+1, current: &current)) {
            return true
        }
        
        if (_existDfs(r: r-1, c: c, board: board, explored: &explored, word: word, currentWordIndex: currentWordIndex+1, current: &current)) {
            return true
        }
        
        if (_existDfs(r: r+1, c: c, board: board, explored: &explored, word: word, currentWordIndex: currentWordIndex+1, current: &current)) {
            return true
        }
        
        explored[r][c] = false
        current.removeLast()
        return false
    }


    func exist(_ board: [[Character]], _ word: String) -> Bool {
        if (board.isEmpty) {
		return false
        }
        
        if (word.isEmpty) {
            return true
        }
        
        if (board.count * board[0].count < word.count) {
            return false
        }

        for r in 0...board.count-1 {
            for c in 0...board[0].count-1 {
                if (board[r][c] != word.first) {
                    continue
                }
                
                var current: [Character] = []
                var explored : [[Bool]] = Array(repeating: Array(repeating: false, count: board[0].count), count: board.count)
                
                if (_existDfs(r: r, c: c, board: board, explored: &explored, word: Array(word), currentWordIndex: 0, current: &current)) {
                    return true
                }
            }
        }
        return false
    }
}