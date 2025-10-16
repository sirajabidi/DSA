/*
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
*/

class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.equals(word2)) {
            return 0;
        }

        if (word1.length() == 0) {
            return word2.length();
        }

        if (word2.length() == 0) {
            return word1.length();
        }

        word1 = "_".concat(word1);
        word2 = "_".concat(word2);

        Integer[][] dp = new Integer[word1.length()][word2.length()];
        dp[0][0] = 0;

        for(int i = 0; i<=word1.length()-1; i++) {
            for(int j = 0; j<=word2.length()-1; j++) {
                if (i==0 && j==0) {
                    dp[0][0] = 0;
                } else if (i==0) {
                    dp[i][j] = dp[i][j-1] + 1;
                } else if (j==0) {
                    dp[i][j] = dp[i-1][j] + 1;
                } else {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        int editsViaAddition = dp[i][j-1] + 1;;
                        int editsViaDeletion = dp[i-1][j] + 1;
                        int editsViaReplace = dp[i-1][j-1] + 1;
                        int tmpMin = Math.min(editsViaAddition, editsViaDeletion);
                        int minEdits = Math.min(tmpMin, editsViaReplace);
                        dp[i][j] = minEdits;
                    }
                }                
            }
        }
        return dp[word1.length()-1][word2.length()-1];
    }
}