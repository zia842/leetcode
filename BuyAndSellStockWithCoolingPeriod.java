/**
 * 
 * @author zia84
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many 
transactions as you like (i.e., buy one and sell one share of the stock multiple times)
with the following restrictions:

    After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).

Note: You may not engage in multiple transactions simultaneously
 (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]

Example 2:

Input: prices = [1]
Output: 0

 

Constraints:

    1 <= prices.length <= 5000
    0 <= prices[i] <= 1000


 *
 */
public class BuyAndSellStockWithCoolingPeriod {

	public int maxProfit(int[] prices) {
		if(prices == null || prices.length <= 1) {
			return 0;
		}
		
		int n = prices.length;
		int noStock[] = new int[n];
		int inHand[] = new int[n];
		int sold[] = new int[n];
		
		noStock[0] = 0;
		inHand[0] = -prices[0]; //Because we have bought a stock and never sold it
		sold[0] = 0;
		
		for(int i=1;i<n;i++) {
			noStock[i] = Math.max(noStock[i-1], sold[i-1]);
			inHand[i] = Math.max(inHand[i-1], noStock[i-1]-prices[i]);
			sold[i] = inHand[i-1] + prices[i];
		}
		
		int result = Math.max(noStock[n-1], sold[n-1]);
		return result;

	}
	
	public static void main(String []args) {
		BuyAndSellStockWithCoolingPeriod bc = new BuyAndSellStockWithCoolingPeriod();
		System.out.println(bc.maxProfit(new int[] {1,2,3,0,2}));
		System.out.println(bc.maxProfit(new int[] {1}));
	}


}
