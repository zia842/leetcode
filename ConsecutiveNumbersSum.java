/**
 * Given an integer n, return the number of ways you can write n as the sum of 
 * consecutive positive integers.
Example 1:

Input: n = 5
Output: 2
Explanation: 5 = 2 + 3

Example 2:
Input: n = 9
Output: 3
Explanation: 9 = 4 + 5 = 2 + 3 + 4

Example 3:
Input: n = 15
Output: 4
Explanation: 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5

Constraints:
    1 <= n <= 109
 * @author zia84
 *
 *
 Algorithm

    Initiate the counter to zero.
    Iterate over k from 1 to Sqrt(2N + 1/4) - 1/2

   If  x = N/K - (K+1)/2 is an integer, increase the counter by one.
   
   Refer : https://leetcode.com/problems/consecutive-numbers-sum/solution/ (Important)

Return the counter.

 */

public class ConsecutiveNumbersSum {

	public int consecutiveNumbersSum(int n) {
		
		int counter = 0;
		int upperLimit = (int)(Math.sqrt(2 * n + 0.25) - 0.5);
		for (int k = 1; k <= upperLimit; ++k) {
            // x should be an integer
            if ((n - k * (k + 1) / 2) % k == 0)
            	counter++;
        } 
		return counter;

	}
}
