class Solution {
    private boolean _dfs(char[][] board, String word, int row, int col, int wordIndex, boolean[][] visited) {
        if (wordIndex == word.length()) {
            return true;
        }
        
        if ((row < 0) || (row >= board.length) || (col < 0) || (col >= board[0].length)) {
            return false;
        }
        
        if (visited[row][col]) {
            // already visited
            return false;
        }
        
        if (board[row][col] != word.charAt(wordIndex)) {
            return false;
        }

        visited[row][col] = true;
        
        boolean rightStatus = _dfs(board, word, row, col+1 , wordIndex+1, visited);
        if (rightStatus) {
            return true;    
        }
        
        boolean bottomStatus = _dfs(board, word, row+1, col, wordIndex+1, visited);
        if (bottomStatus) {
            return true;
        }

        boolean leftStatus = _dfs(board, word, row, col-1 , wordIndex+1, visited);
        if (leftStatus) {
            return true;
        }
        
        boolean topStatus = _dfs(board, word, row-1, col, wordIndex+1, visited);
        if (topStatus) {
            return true;
        }
        visited[row][col] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                boolean found = _dfs(board, word, i, j, 0, visited);
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }
}