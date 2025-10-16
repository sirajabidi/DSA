class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int one=0;
        int two=0;
        int three=0;

        List<Integer> resultList = new ArrayList<Integer>();

        while(one < arr1.length && two < arr2.length && three < arr3.length) {
            if (arr1[one] == arr2[two] && arr2[two] == arr3[three]) {
                resultList.add(arr1[one]);
                one += 1;
                two += 1;
                three += 1;
            } else if ((arr1[one] <= arr2[two]) && (arr1[one] <= arr3[three])) {
                one += 1;
            } else if ((arr2[two] <= arr1[one]) && (arr2[two] <= arr3[three])) {
                two += 1;
            } else {
                three += 1;
            }
        }
        return resultList;
    }
}