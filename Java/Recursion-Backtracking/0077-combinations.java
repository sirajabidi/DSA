class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (k == 0) {
            return new ArrayList<>();
        }

        int[] input = new int[n];
        for(int i = 0; i <= n-1; i++) {
            input[i] = i+1;
        }

        if (input.length == k) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> tmp = new ArrayList<>();
            for(int i: input) {
                tmp.add(i);
            }
            result.add(tmp);
            return result;
        }
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        _combinations(input, k, 0, tmp, result);
        return result;
    }

    private void _combinations(int[] input, int k, int startIndex, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            List<Integer> tmp = new ArrayList<>(current);
            result.add(tmp);
            return;
        }
        
        for (int i = startIndex; i < input.length; i++) {
            current.add(input[i]);
            _combinations(input, k, i + 1, current, result);
            current.removeLast();
        }
    }
}