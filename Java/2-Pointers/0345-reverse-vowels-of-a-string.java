/*
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, 
more than once.
*/
class Solution {
    private boolean isVowel(Character ch) {
        if (ch == 'a' || ch == 'A') {
            return true;
        } else if (ch == 'a' || ch == 'A') {
            return true;
        } else if (ch == 'e' || ch == 'E') {
            return true;
        } else if (ch == 'i' || ch == 'I') {
            return true;
        } else if (ch == 'o' || ch == 'O') {
            return true;
        } else if (ch == 'u' || ch == 'U') {
            return true;
        } else {
            return false;
        }
    }

    public String reverseVowels(String s) {
        if (s.length()==0 || s.length()==1) {
            return s;
        }

        char[] strArray = s.toCharArray();

        int b = 0;
        int e = strArray.length-1;
        
        while(b < e) {
            if (isVowel(strArray[b]) && isVowel(strArray[e])) {
                Character tmp = strArray[b];
                strArray[b] = strArray[e];
                strArray[e] = tmp;
                b++;
                e--;
            } else if (!isVowel(strArray[b]) && !isVowel(strArray[e])) {
                b++;
                e--;
            } else if (!isVowel(strArray[b])) {
                b++;
            } else {
                e--;
            }
        }

        return new String(strArray);
    }
}