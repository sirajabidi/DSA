class Solution {
    public String removeStars(String s) {
        Stack<Character> cache = new Stack<Character>();
        char []chars = s.toCharArray();

        for(Character ch : chars) {
            if (ch != '*') {
                cache.push(ch);
                continue;
            }
            if (!cache.isEmpty()) {
                cache.pop();
            }
        }

        char[] result = new char[cache.size()];
        int writeIndex = cache.size()-1;
        while(!cache.isEmpty()) {
            result[writeIndex] = cache.pop();
            writeIndex--;
        }

        String str = new String(result);
        return str;   
    }
}