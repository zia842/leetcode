
public class CountVowelsPermutations {

	public int countVowelPermutation(int n) {
		long countVowel = 0;
		
		long aCount[] = new long[n];
		long eCount[] = new long[n];
		long iCount[] = new long[n];
		long oCount[] = new long[n];
		long uCount[] = new long[n];
		
		aCount[0] = 1L;
		eCount[0] = 1L;
		iCount[0] = 1L;
		oCount[0] = 1L;
		uCount[0] = 1L;
		
		int MOD = 1000000007;
		/**
		 * "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
		 * ending with a -> ea, ia, ua 
		 * ending with e -> ae, ie 
		 * ending with i -> ei, oi
		 * ending with o -> io
		 * ending with u -> iu, ou
		 */
		for(int i=1;i<n;i++) {
			aCount[i] = (eCount[i-1] + iCount[i-1] + uCount[i-1]) %  MOD;
			eCount[i] = (aCount[i-1] + iCount[i-1]) %  MOD;
			iCount[i] = (eCount[i-1] + oCount[i-1]) %  MOD;
			oCount[i] = (iCount[i-1]) %  MOD;
			uCount[i] = (iCount[i-1] + oCount[i-1]) %  MOD;
			
		}
		
		countVowel = (aCount[n - 1] + eCount[n - 1] + iCount[n - 1] + oCount[n - 1] + uCount[n - 1]) % MOD;
		
		
		return (int)countVowel;
	}
	
	public static void main(String []args) {
		CountVowelsPermutations c = new CountVowelsPermutations();
		System.out.println(c.countVowelPermutation(1));
		System.out.println(c.countVowelPermutation(2));
		System.out.println(c.countVowelPermutation(5));
	}

}
