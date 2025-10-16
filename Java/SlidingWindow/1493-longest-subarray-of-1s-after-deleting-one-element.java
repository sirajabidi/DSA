class Solution {
    public int longestSubarray(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int l=0;
        int maxLength = 0;
        int zeroCount = 0;

        for(int r=0; r<=nums.length-1; r++) {
            if (nums[r]==0) {
                zeroCount++;
            }
            while(zeroCount > 1) {
                if (nums[l]==0) {
                    zeroCount--;
                }
                l++;
            }
            maxLength = Math.max(maxLength, (r-l)+1);
        }
        return maxLength-1;
    }
}