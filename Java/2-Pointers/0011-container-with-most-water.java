import static java.lang.Math.abs;

class Solution {
    public int maxArea(int[] height) {
        if (height.length == 0 || height.length == 1) {
            return 0;
        }

        // state machinery:
        int s = 0;
        int e = height.length-1;
        int maxArea = 0;

        while(s < e) {
            int areaTmp = Math.min(height[s], height[e]) * (e-s);
            if (areaTmp > maxArea) {
                maxArea = areaTmp;
            }
            if (height[s] < height[e]) {
                s++;
            } else {
                e--;
            }
        }
        return maxArea;
    }
}