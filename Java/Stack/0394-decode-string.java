class Solution {
    private int frequency(Stack<String> stack) {
        String freqStr = "";
        while(!stack.isEmpty()) {
            try {
                Integer.parseInt(stack.peek());
                freqStr = stack.pop() + freqStr;
            } catch(Exception e) {
                break;
            }
        }
        return Integer.parseInt(freqStr);
    }
    public String decodeString(String s) {
        int currentFrequency = 0;
        Stack<String> cache = new Stack<String>();
        String result = "";

        for(int i=0; i<=s.length()-1; i++) {
            char ch = s.charAt(i);
            String currentStr = Character.toString(ch);

            if (currentStr.equals("]")) {
                // dance
                String tmpStr = "";
                while(true) {
                    String tmp = cache.pop();
                    if (tmp.equals("[")) {
                        break;
                    }
                    tmpStr = tmp + tmpStr;
                }

                int freq = frequency(cache);
                String repeatedStr = tmpStr.repeat(freq);
                cache.push(repeatedStr);
            } else {
                cache.push(currentStr);
            }
            
        }

        while(!cache.isEmpty()) {
            result = cache.pop() + result;
        }
        return result;
    }
}