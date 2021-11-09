import java.util.Arrays;

public class CountPrimes {
	
	public int countPrimes(int n) {
		int numberOfPrimes = 0;
		
		if(n <= 1) {
			return 0;
		}
		
		
		boolean isPrime[] = new boolean[n+1];
		Arrays.fill(isPrime, true);
		
		isPrime[0] = false;
		isPrime[1] = false;
		
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(isPrime[i]) {
				for(int j=2;i*j<=n;j++) {
					isPrime[i*j] = false;
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			if(isPrime[i]) numberOfPrimes++;
		}
		
		return numberOfPrimes;
		
	}
	
	
	public boolean isPrime(int n) {
		if(n <= 1) { 
			return false;
		}
		else if(n == 2) {
			return true;
		}
		else if(n % 2 == 0) { //Any number multiple of 2 is not a prime 
			return false;
		}
		
		for(int i=3;i<=Math.sqrt(n);i+=2) {
			if(n%i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String []args) {
		CountPrimes c = new CountPrimes();
		System.out.println("3 isPrime " + c.isPrime(3));
		System.out.println("4 isPrime " + c.isPrime(4));
		System.out.println("5 isPrime " + c.isPrime(5));
		System.out.println("6 isPrime " + c.isPrime(6));
		System.out.println("7 isPrime " + c.isPrime(7));
		System.out.println("8 isPrime " + c.isPrime(8));
		System.out.println("9 isPrime " + c.isPrime(9));
		System.out.println("10 isPrime " + c.isPrime(10));
		
		System.out.println(c.countPrimes(10));
		System.out.println(c.countPrimes(0));
		System.out.println(c.countPrimes(1));
		System.out.println(c.countPrimes(20));
	}

}
