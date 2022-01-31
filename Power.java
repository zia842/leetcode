
public class Power {

	public double myPow(double x, int n) {
		
		double result = 1;
		long N = n;
		
		if(N < 0) {
			x = 1 / x;
			N = -N;
		}
		
		for(long i=0;i<N;i++) {
			result = result * x;
		}
		
		return result;
	}
	
	public static void main(String []args) {
		Power p = new Power();
		System.out.println(p.myPow(2.0, 10));
		System.out.println(p.myPow(2.0, -2));
	}

}
