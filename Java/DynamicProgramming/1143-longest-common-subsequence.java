/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no 
common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) 
deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
*/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if ((text1.length()) == 0 || (text2.length() == 0)) {
            return 0;
        }

        if (text1.equals(text2)) {
            return text1.length();
        }

        // text1 is along rows and text2 is alomg cols:
        int [][] grid = new int[text1.length()+1][text2.length()+1];
        
        // Fill row 0 with all zero's :
        Arrays.fill(grid[0], 0);

        // Fill first column i.e (0,0) cell for every row with 0:
        for(int[] row : grid) {
            row[0] = 0;
        }

        // At this point our gris has row 0 filled with zeros and column zero is also filled with zeros:
        
        // rowLoop starts from row 1 and goes all the way to last row (which is the same as length of text1):
        for(int r=1; r<=text1.length(); r++) {
            for(int c=1; c<=text2.length(); c++) {
                Character charAtRow = text1.charAt(r-1);
                Character charAtColumn = text2.charAt(c-1);
                if (charAtRow == charAtColumn) {
                    // if char of text1 and text2 matches then we find the LCS for past substring and add +1 to it to find the LCS for current cell :
                    int tmpLCS = grid[r-1][c-1];
                    grid[r][c] = tmpLCS+1;
                } else {
                    // in non-martching case we just take the max LCS from left or top cell:
                    grid[r][c] = Math.max(grid[r][c-1], grid[r-1][c]);
                }
            }

        } 

        return grid[text1.length()][text2.length()];      
    }
}