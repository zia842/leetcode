import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Vector;

public class FourDivisors {
	
	public int sumFourDivisors(int[] nums) {
		int sumOf4Divisors = 0;
		Map<Integer,HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		
		for(int i=0;i<nums.length;i++) {
			for(int j=1;j<=Math.sqrt(nums[i]);j++) {
				if(nums[i] % j == 0) {
					HashSet<Integer> divisorSet = map.get(nums[i]);
					if(divisorSet == null) {
						divisorSet = new HashSet<Integer>();
					}
					divisorSet.add(j);
					divisorSet.add(nums[i]/j);
					map.put(nums[i], divisorSet);
				}
			}
		}
		
		for(int i : nums) {
			HashSet<Integer> divisorSet = map.get(i);
			if(divisorSet!=null && divisorSet.size() == 4) {
				for(int s : divisorSet) {
					sumOf4Divisors = sumOf4Divisors + s;
				}
			}
		}
		
		return sumOf4Divisors;
		
	}
	
	public static void main(String []args) {
		FourDivisors f = new FourDivisors();
		System.out.println(f.sumFourDivisors(new int[] {21,4,7}));
		System.out.println(f.sumFourDivisors(new int[] {21,21}));
		System.out.println(f.sumFourDivisors(new int[] {1,2,3,4,5}));
		printDivisors(21);
	}
	
	static void printDivisors(int n)
    {
        // Vector to store half of the divisors
        Vector<Integer> v = new Vector<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
 
                // check if divisors are equal
                if (n / i == i)
                    System.out.printf("%d ", i);
                else {
                    System.out.printf("%d ", i);
 
                    // push the second divisor in the vector
                    v.add(n / i);
                }
            }
        }
 
        // The vector will be printed in reverse
        for (int i = v.size() - 1; i >= 0; i--)
            System.out.printf("%d ", v.get(i));
    }
	
}
