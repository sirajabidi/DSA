class Solution {
    private String getMapping(int digit) {
        if (digit == 2) {
            return "abc";
        } else if (digit == 3) {
            return "def";
        } else if (digit == 4) {
            return "ghi";
        } else if (digit == 5) {
            return "jkl";
        } else if (digit == 6) {
            return "mno";
        } else if (digit == 7) {
            return "pqrs";
        } else if (digit == 8) {
            return "tuv";
        } else if (digit == 9) {
            return "wxyz";
        } else {
            return "";
        }
    }

    private void _helper(String input, int index, List<Character> current, List<String> result) {
        if (current.size() == input.length()) {
            StringBuilder sb = new StringBuilder();
            for (char c : current) {
                sb.append(c);
            }
            result.add(sb.toString());
            return;
        }

        Character chr = input.charAt(index);
        int digit = Character.getNumericValue(chr);
        String mapping = getMapping(digit);

        for(Character ch : mapping.toCharArray()) {
            current.add(ch);
            _helper(input, index + 1, current, result);
            current.removeLast();
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        _helper(digits, 0, new ArrayList<>(), result);
        return result;
    }
}