/*
You are given an integer array coins representing coins of different denominations and an integer amount 
representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot 
be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] dpTable = new int[amount+1];
        Arrays.fill(dpTable, -1);

        dpTable[0] = 0;
        for(int i = 1; i<=dpTable.length-1; i++) {
            int minForCurrentIndex = Integer.MAX_VALUE;
            for(int coin : coins) {
                if (i-coin >= 0 && 
                    (dpTable[i-coin] != -1)) {
                    minForCurrentIndex = Math.min(minForCurrentIndex, dpTable[i-coin]);
                }
            }
            dpTable[i] = (minForCurrentIndex == Integer.MAX_VALUE) ? -1 : minForCurrentIndex+1;
        }
        return dpTable[dpTable.length-1];
    }
}