class Solution {
    private static Map<Character, Integer> fCache = new HashMap<Character, Integer>();

    private static void populate() {
        fCache.put('a', 1);
        fCache.put('e', 1);
        fCache.put('i', 1);
        fCache.put('o', 1);
        fCache.put('u', 1);
    }

    private boolean isVowel(Character ch) {
        if (fCache.isEmpty()) {
            populate();
        }
        if (fCache.containsKey(ch)) {
            return true;
        }
        return false;
    }

    public int maxVowels(String s, int k) {
        int maxVowels = 0;
        int currentWindowVowelCount = 0;

        // process first window :
        for (int i = 0; i<=k-1; i++) {
            if (isVowel(s.charAt(i))) {
                    currentWindowVowelCount++;
            }
            if (currentWindowVowelCount > maxVowels) {
                maxVowels = currentWindowVowelCount;
            }
        }

        // sliding started :
        for (int i=k; i<=s.length()-1; i++) {
            currentWindowVowelCount = currentWindowVowelCount - (isVowel(s.charAt(i-k)) ? 1 : 0) + (isVowel(s.charAt(i)) ? 1 : 0);

            if (currentWindowVowelCount > maxVowels) {
                maxVowels = currentWindowVowelCount;
            }
            
        }

        if (k == s.length()) {
            return currentWindowVowelCount;
        }
        return maxVowels;
        
    }
}