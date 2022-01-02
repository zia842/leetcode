/**
 * 
 */

/**
 * @author zia84
 *
 */
class GreatestCommonDivisorStrings {

	public String gcdOfStrings(String str1, String str2) {
		int len = gcd(str1.length(), str2.length());
		return ((str1+str2).equals(str2+str1) ? str1.substring(0, len) : "");
	}
	
	public int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}
	
	public static void main(String []args) {
		GreatestCommonDivisorStrings gcd = new GreatestCommonDivisorStrings();
		System.out.println(gcd.gcdOfStrings("ABCABC", "ABC"));
		System.out.println(gcd.gcdOfStrings("ABABAB", "ABAB"));
		System.out.println(gcd.gcdOfStrings("LEET", "CODE"));
		System.out.println(gcd.gcdOfStrings("ABCDEF", "ABC"));
	}

}
