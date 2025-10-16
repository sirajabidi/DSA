class Solution {
    public int longestOnes(int[] nums, int k) {
        if (nums.length == k) {
            return nums.length;
        }

        int l = 0;
        int maxSize = 0;
        int zeroCount = 0;

        for (int r=0; r<=nums.length-1; r++) {
            if (nums[r] == 0) {
                // Everytime we see a zero we just increase the zeroCount by 1
                zeroCount++;
            }

            /* And then we try to contract the l - Do it every time - if zC is actually more than k
               only then we will end up contracting the window. As long as zC is greater then k and left 
               smaller than or equal to right we keep moving the left.
               the second part here (l<=r) is important to hanlde the k=0 cases like [1,1,1,0,0,0,1,1] where k=0
            */
            while ((zeroCount > k) && (l<=r)) {
                if (nums[l]==0) {
                    zeroCount--;
                }
                l++;
            }

            // Alos keep computing the window length in each step and update the mazSize.
            maxSize = Math.max(maxSize, (r-l)+1);
        }
        
        return maxSize;
    }
}