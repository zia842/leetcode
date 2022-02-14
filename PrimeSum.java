import java.util.ArrayList;
import java.util.List;

public class PrimeSum {

	static List<Integer> primeDivision(int N){
		List<Integer> arr = new ArrayList<>();
		int i=2;
		int j=(N-2);
		while(i<=j){
			if(i+j==N){
				if(isPrime(i)&&isPrime(j)){
					arr.add(i);   
					arr.add(j);
					break;
				}                
			}
			i++;
			j--;
		}
		return arr;
	}

	static boolean isPrime(int n){
		if(n==1){
			return false;
		}    
		if(n==2 || n==3){
			return true;
		}    
		if(n%2==0 || n%3==0){
			return false;
		}    
		for(int i=5;(i*i)<=n;i+=6){
			if(n%i==0 || n%(i+2)==0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String []args) {
		PrimeSum p = new PrimeSum();
		System.out.println(p.primeDivision(5));
	}


}
