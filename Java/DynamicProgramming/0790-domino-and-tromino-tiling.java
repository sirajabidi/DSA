/*
You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.


Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 109 + 7.

In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are 
two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.

 

Example 1:


Input: n = 3
Output: 5
Explanation: The five different ways are shown above.
Example 2:

Input: n = 1
Output: 1
*/

class Solution {
    int MOD = 1000000007;
    Map<Integer, Long> fCache = new HashMap<Integer, Long>();
    Map<Integer, Long> pCache = new HashMap<Integer, Long>();

    private Long partialTilingWays(Integer gridIndex) {
        if (gridIndex == 2) {
            return 1L;
        }

        if (pCache.containsKey(gridIndex)) {
            return pCache.get(gridIndex);
        }

        Long fTitlingWays = fullTilingWays(gridIndex-2);
        Long pTilingWays = partialTilingWays(gridIndex-1);
        Long total = fTitlingWays + pTilingWays;
        total = total % MOD;
        pCache.put(gridIndex, total);
        return total;
    }

    private Long fullTilingWays(Integer gridIndex) {
        if (gridIndex == 1) {
            return 1L;
        }

        if (gridIndex == 2) {
            return 2L;
        }

        if (fCache.containsKey(gridIndex)) {
            return fCache.get(gridIndex);
        }

        Long waysMinusOne = fullTilingWays(gridIndex-1);
        Long waysMinusTwo = fullTilingWays(gridIndex-2);
        Long pWays = 2*partialTilingWays(gridIndex-1);
        Long total = waysMinusOne + waysMinusTwo + pWays;
        total = total % MOD;
        fCache.put(gridIndex, total);
        return total;
    }

    public int numTilings(int n) {
        if (n==0) {
            return 0;
        }

        if (n==1) {
            return 1;
        }

        if (n==2) {
            return 2;
        }

        
        Long ways = fullTilingWays(n);
        return ways.intValue();
    }
}