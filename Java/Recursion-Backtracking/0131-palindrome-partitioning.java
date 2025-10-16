class Solution {
    public List<List<String>> partition(String s) {
        if (s.isEmpty()) {
            return new ArrayList<>();
        }
        return _partition(s);
    }

    private List<List<String>> _partition(String str) {
        if (str.isEmpty()) {
            List<String> inner = new ArrayList<>();
            List<List<String>> outer = new ArrayList<>();
            outer.add(inner);
            return outer;
        }
        
        List<List<String>> result = new ArrayList<>();
        for(int i=0; i<=str.length()-1; i++) {
            String substring = str.substring(0, i+1);
            if (!isPalindrome(substring)) {
                continue;
            }
            List<List<String>> fromLowerLevel = _partition(str.substring(i+1));
            for (List<String> partition : fromLowerLevel) {
                partition.addFirst(substring);
                result.add(partition);
            }
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}