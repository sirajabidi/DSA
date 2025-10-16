/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
*/

class Solution {
    private void _generateParenthesis(int invOpen, int invClose, int currOpen, int currClose, List<Character> current, List<String> results) {
        if ((invOpen == 0) && (invClose == 0)) {
            String result = current.stream().map(String::valueOf).collect(Collectors.joining());
            results.add(result);
            return;
        }

        if (invOpen > 0) {
            current.add('(');
            _generateParenthesis(invOpen-1, invClose, currOpen+1, currClose, current, results);
            current.removeLast();
        }

        if ((invClose > 0) && (currClose < currOpen)) {
            current.add(')');
            _generateParenthesis(invOpen, invClose-1, currOpen, currClose+1, current, results);
            current.removeLast();
        }
    }

    public List<String> generateParenthesis(int n) {
        if (n==0) {
            return new ArrayList<String>();
        }

        List<String> results = new ArrayList<String>();

        // We always starts with open paren and as a result we have one less open paren in inventory also currentOpen gets a value of 1 as we starts with open:
        List<Character> currentList = new ArrayList<>();
        _generateParenthesis(n, n, 0, 0, currentList, results);
        return results;
    }
}