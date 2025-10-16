class Solution {
    public String mergeAlternately(String word1, String word2) {
        if (word1.length()==0 && word2.length()==0) {
            return null;
        }
        
        if (word1.length()==0) {
            return word2;
        }

        if (word2.length()==0) {
            return word1;
        }

        int one = 0;
        int two = 0;
        String result = "";
        while((one<=word1.length()-1) || (two<=word2.length()-1)) {
            if (one<=word1.length()-1) {
                result = result + word1.charAt(one);
                one++;
            }
            if (two<=word2.length()-1) {
                result = result + word2.charAt(two);
                two++;
            }
        }
        return result;
    }
}