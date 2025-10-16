class Solution {
    private List<List<Integer>> _helper(List<Integer> input, int index, Map<Integer, Integer> frequencyMap) {
        if (index == input.size()) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            result.add(temp);
            return result;
        }

        List<List<Integer>> fromLowerLevel = _helper(input, index+1, frequencyMap);
        List<List<Integer>> currentLevel = new ArrayList<>();

        for (List<Integer> lower : fromLowerLevel) {
            currentLevel.add(lower);
            int item = input.get(index);

            List<Integer> temp = lower;
            for (int j=0; j<frequencyMap.get(item); j++) {
                List<Integer> newList  = new ArrayList<>(temp);
                newList.add(item);
                currentLevel.add(newList);
                temp = newList;
            }
        }
        return currentLevel;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Integer> keys = map.keySet();
        List<Integer> keyList = new ArrayList<>(keys);
        return _helper(keyList, 0, map);
    }
}