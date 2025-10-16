/*We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked (the number I picked stays the same 
throughout the game).

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns three possible results:

-1: Your guess is higher than the number I picked (i.e. num > pick).
1: Your guess is lower than the number I picked (i.e. num < pick).
0: your guess is equal to the number I picked (i.e. num == pick).
Return the number that I picked.

 

Example 1:

Input: n = 10, pick = 6
Output: 6
Example 2:

Input: n = 1, pick = 1
Output: 1
Example 3:

Input: n = 2, pick = 1
Output: 1
*/


/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public Long binarySearch(Long start, Long end) {
        if (start > end) {
            return Long.valueOf(-2);
        }

        Long middle = (end+start)/2;
        Long guessed = Long.valueOf(guess(middle.intValue()));

        if (guessed == 0) {
            return middle;
        }

        if (guessed == -1) {
            return binarySearch(start, middle-1);
        } else {
            return binarySearch(middle+1, end);
        }
    }
   
    public int guessNumber(int n) {
        Long result = binarySearch(Long.valueOf(1), Long.valueOf(n));
        return result.intValue();
    }
}