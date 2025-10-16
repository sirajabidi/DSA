/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting 
some (can be none) of the characters without disturbing the relative positions of the remaining characters. 
(i.e., "ace" is a subsequence of "abcde" while "aec" is not).
*/

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length()==0 && t.length()==0) {
            return true;
        }

        if (s.length()==0) {
            return true;
        }

        if (t.length()==0) {
            return false;
        }

        int sPtr = 0;
        int tPtr = 0;
        while ((sPtr <= s.length()-1) && (tPtr <= t.length()-1)) {
            if (s.charAt(sPtr) == t.charAt(tPtr)) {
                sPtr++;
                tPtr++;
            } else {
                tPtr++;
            }
        }

        if (sPtr > s.length()-1) {
            return true;
        }
        
        return false;
    }
}