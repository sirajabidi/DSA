class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return null;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        List<Integer> result = new ArrayList<>();

        for (int r = 0; r <= rows - 1; r++) {
            int colStartIndex = 0;
            int colEndIndex = 0;
            int modulo = r%2;
            
            if (modulo == 0) {
                colStartIndex = 0;
                colEndIndex = cols - 1;
                for (int c=colStartIndex; c<=colEndIndex; c=c+2) {
                    int item = grid[r][c];
                    result.add(item);
                }
            } else {

                if (cols % 2 == 0) {
                    colStartIndex = cols - 1;
                } else {
                    colStartIndex = cols - 2;
                }
                colEndIndex = 0;
                for (int c=colStartIndex; c>=colEndIndex; c=c-2) {
                    int item = grid[r][c];
                    result.add(item);
                }
            }
        }

        return result;
    }
}