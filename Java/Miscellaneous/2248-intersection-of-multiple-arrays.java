class Solution {
    private List<Integer> intersection(List<Integer> nums1, List<Integer> nums2) {
        List<Integer> resultList = new ArrayList<Integer>();

        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        for(int item: nums1) {
            if(frequencyMap.containsKey(item)) {
                int frequency = frequencyMap.get(item);
                frequencyMap.put(item, frequency+1);
            } else {
                frequencyMap.put(item, 1);
            } 
        }

        for(int i=0; i<=nums2.size()-1; i++) {
            int valueFromTwo = nums2.get(i);
            if(frequencyMap.containsKey(valueFromTwo)) {
                resultList.add(valueFromTwo);
            }
        }

        Collections.sort(resultList);
        return resultList;
    }

    private List<Integer> arrayToList(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();

        for(int i: nums) {
            result.add(i);
        }
        return result;
    }

    public List<Integer> intersection(int[][] nums) {
        int[] firstArray = nums[0];
        List<Integer> result = arrayToList(firstArray);
        Collections.sort(result);
        
        for(int i=1; i<=nums.length-1; i++) {
            int[] item = nums[i];
            result = intersection(result, arrayToList(nums[i]));
        }

        return result;
    }
}