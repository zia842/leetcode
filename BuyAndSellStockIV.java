import java.util.Arrays;

/**
 * 
 * @author zia84
 *
 *188. Best Time to Buy and Sell Stock IV
 *
 *You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions.

Note: You may not engage in multiple transactions simultaneously 
(i.e., you must sell the stock before you buy again).

 

Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

Example 2:

Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. 
Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

 

Constraints:

    0 <= k <= 100
    0 <= prices.length <= 1000
    0 <= prices[i] <= 1000


 */

/**
 * 1. Buy before selling, 
 * 2. First Day you can either Buy or Skip
 * 3. Last Day you can either Sell/Only if existing stock or Skip if no stock
 * 
 *
 */
public class BuyAndSellStockIV {

	public int maxProfit(int k, int[] prices) {
		if (k == 0) return 0;

		int[] profit = new int[k+1];
		int[] cost = new int[k+1];

		profit[0] = 0;
		Arrays.fill(cost, Integer.MAX_VALUE);

		for (int price: prices) {
			for (int i = 0; i < k; i++) {
				cost[i+1] = Math.min(cost[i+1], price - profit[i]); //Buy at minimum
				profit[i+1] = Math.max(profit[i+1], price - cost[i+1]); //Sell at max
			}
		}
		return profit[k];
	}
	
	public static void main(String []args) {
		BuyAndSellStockIV b4 = new BuyAndSellStockIV();
		System.out.println(b4.maxProfit(2, new int[] {2, 4, 1}));
		System.out.println(b4.maxProfit(2, new int[] {3, 2, 6, 5, 0, 3}));
	}

}
