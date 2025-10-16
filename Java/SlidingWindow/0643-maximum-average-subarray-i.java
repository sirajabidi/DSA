class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length==0) {
            return 0;
        }

        if (nums.length < k) {
            return 0;
        }

        if (k==0) {
            return 0;
        }

        if (nums.length==1) {
            return nums[0];
        }

        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        for (int i=1; i<=nums.length-1; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        double maxAverage = -1000000.00;

        for (int i=k-1; i<=nums.length-1; i++) {
            double sumOfContiguousArray = prefixSum[i] - (i<k ? 0 : prefixSum[i-k]);
            double average = sumOfContiguousArray/k;
            if (average > maxAverage) {
                maxAverage = average;
            }
        }
        return maxAverage;
    }
}