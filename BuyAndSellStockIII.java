/**
 * 
 * @author zia84
 * 123. Best Time to Buy and Sell Stock III
 * 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously 
(i.e., you must sell the stock before you buy again).



Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, 
as you are engaging multiple transactions at the same time. You must sell before buying again.

Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.



Constraints:

    1 <= prices.length <= 105
    0 <= prices[i] <= 105


 *
 */
public class BuyAndSellStockIII {

	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		
		if(prices == null || prices.length <= 0) {
			return maxProfit;
		}
		
		int n = prices.length;
		int leftArr[] = new int[n];
		int rightArr[] = new int[n];
		
		int leftMin = prices[0];
		for(int i=1;i<n;i++) {
			leftArr[i] = Math.max(leftArr[i-1], prices[i]-leftMin);
			leftMin = Math.min(leftMin, prices[i]);
		}
		
		int rightMax = prices[n-1];
		for(int i=n-2;i>=0;i--) {
			rightArr[i] = Math.max(rightArr[i+1], rightMax-prices[i]);
			rightMax = Math.max(rightMax, prices[i]);
		}
		
		maxProfit = rightArr[0];
		for(int i=1;i<n;i++) {
			maxProfit = Math.max(maxProfit, leftArr[i-1]+rightArr[i]);
		}
		
		return maxProfit;

	}
	
	public static void main(String []args) {
		BuyAndSellStockIII b3 = new BuyAndSellStockIII();
		System.out.println(b3.maxProfit(new int[] {3,3,5,0,0,3,1,4}));
		System.out.println(b3.maxProfit(new int[] {1,2,3,4,5}));
		System.out.println(b3.maxProfit(new int[] {7,6,4,3,1}));
		System.out.println(b3.maxProfit(new int[] {2,1,2,0,1}));
	}

}
