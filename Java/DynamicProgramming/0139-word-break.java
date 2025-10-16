/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a 
space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty() && wordDict.isEmpty()) {
            return true;
        }
        if (s.isEmpty() || wordDict.isEmpty()) {
            return false;
        }

        boolean[] dp = new boolean[s.length()];
        Arrays.fill(dp, false);

        for (int i = 0; i <= s.length()-1; i++) {
            boolean wordMatchedAtCurrentIndex = false;
            boolean hasMatchedWordBeenBuiltOnMatchedWord = true;

            for (String word : wordDict) {
                int lengthOfCurrentWord = i+1;
                if (word.length() > lengthOfCurrentWord) {
                    continue;
                }
                int startIndexForWordToBeSelected = (i - word.length())+1;
                String selectedWord = s.substring(startIndexForWordToBeSelected, i+1);
                if (!selectedWord.equals(word)) {
                    continue;
                }

                wordMatchedAtCurrentIndex = true;
                
                if ((startIndexForWordToBeSelected-1) >= 0) {
                    hasMatchedWordBeenBuiltOnMatchedWord = dp[startIndexForWordToBeSelected-1];
                }

                if (wordMatchedAtCurrentIndex && hasMatchedWordBeenBuiltOnMatchedWord) {
                    break;
                }
            }
            dp[i] = wordMatchedAtCurrentIndex && hasMatchedWordBeenBuiltOnMatchedWord;
        }
        return dp[s.length()-1];
    }
}