class Solution {
    private void _helper(Map<Integer, Integer>map, List<Integer> current, List<List<Integer>> answers) {
        if (map.size() == 0) {
            List<Integer> temp = new ArrayList<>(current);
            answers.add(temp);
            return;
        }
        
        Set<Integer> keysCopy = new HashSet<>(map.keySet());
        for(Integer key : keysCopy) {
            current.add(key);

            int keyFreq = map.get(key)-1;
            if (keyFreq == 0) {
                map.remove(key);
            } else {
                map.put(key, keyFreq);
            }
            _helper(map, current, answers);
            current.removeLast();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
    }

    private Map<Integer, Integer> _buildFrequencyMap(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        return frequencyMap;
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        if (nums.length == 1) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            result.add(list);
            return result;
        }
        
        Map<Integer, Integer> map = _buildFrequencyMap(nums);
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        _helper(map, currentList, results);
        return results;
    }
}