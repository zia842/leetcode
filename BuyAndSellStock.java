
public class BuyAndSellStock {
	public int maxProfit(int[] prices) {

		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;

		for(int p : prices){
			if(p < minPrice){
				minPrice = p;
			}
			else{
				maxProfit = Math.max(maxProfit, p-minPrice);
			}
		}

		return maxProfit;
	}
	
	public static void main(String []args) {
		BuyAndSellStock b = new BuyAndSellStock();
		System.out.println(b.maxProfit(new int[] {7,1,5,3,6,4}));
		System.out.println(b.maxProfit(new int[] {7,6,4,3,1}));
	}
}
