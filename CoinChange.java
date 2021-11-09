import java.util.Arrays;

public class CoinChange {
	
public int coinChange(int[] coins, int amount) {
        
        //Sort
      //  Arrays.sort(coins);
        
        //Initialize dpTable to amount size
        int [][]dpTable = new int[coins.length][amount+1];
      //  Arrays.fill(dpTable, amount+1);
        for(int i=0;i<coins.length;i++){
        	for(int j=1;j<amount+1;j++){
        		dpTable[i][j] = amount+1;
        	}
        }
        
        for(int i=0;i<coins.length;i++){
            for(int j=1;j<amount+1;j++){
                
                if(coins[i] == j){
                    dpTable[i][j] = 1;
                }
                else if(j > coins[i]){
                    if(i == 0){
                        dpTable[i][j] = dpTable[i][j-coins[i]] + 1;
                    }
                    else{
                        dpTable[i][j] = Math.min(dpTable[i][j-coins[i]] + 1, dpTable[i-1][j]);
                  //  System.out.println(dpTable[i][j-coins[i]] + " i is " + i + " j is " + j + "coins[i] is " + coins[i]);
                    }
                        
                }
                else{ //j < coins[i]
                    if(i > 0){
                        dpTable[i][j] = dpTable[i-1][j];
                    }
                }
                
            }
        }
        
      // System.out.println(dpTable[coins.length-1][amount] + " Coin is  " + coins[coins.length-1]);
        
     //   System.out.println(amount);
        
      //  System.out.println((long)dpTable[coins.length-1][amount] * coins[coins.length-1]);
        
        
        /*if((long)dpTable[coins.length-1][amount] * coins[coins.length-1] < amount){
            return -1;      
        }*/
        
        return dpTable[coins.length-1][amount];
    }
	
	
	public int coinChangeOneD(int[] coins, int amount) {
		int max = amount + 1;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, max);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}
	
	public static void main(String []args) {
		CoinChange c = new CoinChange();
		System.out.println(c.coinChange(new int[]{2}, 3));
		System.out.println(c.coinChange(new int[]{1}, 0));
		System.out.println(c.coinChange(new int[]{1}, 1));
		System.out.println(c.coinChange(new int[]{1}, 2));
		
		System.out.println(c.coinChange(new int[]{1,2147483647}, 2));
		System.out.println(c.coinChange(new int[]{2,5,10,1}, 27));
		System.out.println(c.coinChange(new int[]{186,419,83,408}, 6249));
		System.out.println(c.coinChange(new int[]{1,2,5}, 11));
		
	}
}
