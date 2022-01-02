
public class PerfectSquares {
	/**
	 * 4^k (8m + 7) 
	 * @param n
	 * @return
	 */
	
	public int numSquares(int n) {
		
		while(n%4 == 0) {
			n /= 4;
		}
		
		if(n%8 == 7) {
			return 4;
		}
		
		if(this.isSquare(n)) {
			return 1;
		}
		
		for(int i=1; i*i <= n; i++) {
			if(this.isSquare(n-i*i)) {
				return 2;
			}
		}
		
		return 3;
	}
	
	public boolean isSquare(int n ) {
		int sq = (int)Math.sqrt(n);
		return n == sq * sq;
	}
	
	public static void main(String []args) {
		PerfectSquares p = new PerfectSquares();
		System.out.println(p.numSquares(1));
		System.out.println(p.numSquares(2));
		System.out.println(p.numSquares(3));
		System.out.println(p.numSquares(4));
		System.out.println(p.numSquares(5));
		System.out.println(p.numSquares(12));
		System.out.println(p.numSquares(13));
	}
}
