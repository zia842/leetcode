
/**
 * k(k+1) / 2 -> N 
 * k(k+1) -> 2N
 * Math.sqrt(2 * (long)n + 0.25) - 0.5
 * @author zia84
 *
 */
public class ArrangingCoins {

	public int arrangeCoins(int n) {
		return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);
	}

}
