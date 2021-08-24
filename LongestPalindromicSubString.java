public class LongestPalindromicSubString {

	public String longestPalindrome(String s) {
		
		if(s == null || s == "") {
			return s;
		}
		
        int start = 0, end = 0;
        for(int i=0;i<s.length();i++) {
        	int len1 = expandAroundCenter(s, i, i);
        	int len2 = expandAroundCenter(s, i, i+1);
        	int len = Math.max(len1, len2);
        	 if (len > end - start) { //Calculate start and end based on i as center
                 start = i - (len - 1) / 2;
                 end = i + len / 2;
             }
        }
        
		return s.substring(start,end + 1);
    }
	
	public static void main(String []args) {
		LongestPalindromicSubString l = new LongestPalindromicSubString();
		//System.out.println(l.longestPalindrome("aaaabbaa"));
		//System.out.println(l.longestPalindrome("abcba"));
		System.out.println(l.longestPalindrome("babad"));
	}
	
	public static void printStartAndEnd(int maxLength) {
		for(int len=3;len<=maxLength;len++) {
			System.out.println("*********Length is **************** " + len);
			int start = 0;
			int end = start + len - 1;
			while(end < maxLength) {
				end = start + len - 1;
				System.out.println(start + " " + end);
				start++;
			}
		}
	}
	
	
	public static int expandAroundCenter(String s, int start, int end) {
		int left = start;
		int right = end;
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}
}
