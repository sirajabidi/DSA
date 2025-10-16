class Solution {
    private List<List<Integer>> _helper(int[] nums, int index) {
        if (index == nums.length) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            res.add(list);
            return res;
        }

        List<List<Integer>> fromLowerLevel = _helper(nums, index + 1);
        List<List<Integer>> currentLevel = new ArrayList<>();
        
        for (List<Integer> list : fromLowerLevel) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(nums[index]);
            
            currentLevel.add(list);
            currentLevel.add(newList);
        }
        return currentLevel;
    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        return _helper(nums, 0);
    }
}