import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingSubString {

	/**
	 * Time Complexity O(N LOGN)
	 * Space Complexity O(N) - Hashset
	 * @param s
	 * @return
	 */
	public int longestRepeatingSubstring(String s) {
		
		//Rolling Hash
		long P = 131;
		long hash[] = new long[s.length() + 1];
		long pow[] = new long[s.length() + 1];
		pow[0] = 1;
		
		for(int i=1;i<=s.length();i++) { //O(N)
			hash[i] = hash[i-1] * P + s.charAt(i-1);
			pow[i] = pow[i-1] * P;
		}
		
		
		int left = 0;
		int right = s.length();
		
		while(left < right) { //Binary Search O(LOG N)
			
			int middle = left + (right - left + 1 >> 1);
			
			if(check(middle, hash, pow)) {
				left = middle; 
			}
			else {
				right = middle - 1; 
			}
			
		}
		
		return left;

	}
	
	public boolean check(int length, long [] hash, long pow []) { //O(N)
		Set<Long> set = new HashSet<Long>();
		for(int i= length;i < hash.length;i++) {
			long h = hash[i] - hash[i-length] * pow[length];
			if(!set.add(h)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String []args) {
		LongestRepeatingSubString l = new LongestRepeatingSubString();
		System.out.println(l.longestRepeatingSubstring("abcd"));
		System.out.println(l.longestRepeatingSubstring("abbaba"));
		System.out.println(l.longestRepeatingSubstring("aabcaabdaab"));
	}

}
