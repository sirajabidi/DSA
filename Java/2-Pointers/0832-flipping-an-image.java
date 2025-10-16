/*
Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.

For example, flipping [1,1,0] horizontally results in [0,1,1].
To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.

For example, inverting [0,1,1] results in [1,0,0].
*/
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int rows = image.length;
        int cols = image[0].length;

        for (int r = 0; r <= rows - 1; r++) {
            int cF = 0;
            int cB = cols - 1;

            while (cF <= cB) {
                int tmp = image[r][cF];
                image[r][cF] = (image[r][cB] == 1) ? 0 : 1;
                image[r][cB] = (tmp == 1) ? 0 : 1;
                cF = cF + 1;
                cB = cB - 1;
            }
        }
        return image;
    }
}