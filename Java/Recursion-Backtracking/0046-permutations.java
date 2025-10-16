
class Solution {
    private void backtrack(List<Integer> curr, List<List<Integer>> ans, int[] nums) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int num : nums) {
            if (!curr.contains(num)) {
                curr.add(num);
                backtrack(curr, ans, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        if (nums.length == 1) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(Arrays.asList(nums[0]));
            return result;
        }

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), ans, nums);
        return ans;
    }
}