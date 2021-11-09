import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Longest Palindromic Substring
 
Given a string s, return the longest palindromic substring in s.
 Example 1:
	Input: s = "babad"
	Output: "bab"
	Note: "aba" is also a valid answer.
	
 Example 2:
	Input: s = "cbbd"
	Output: "bb"
	
Example 3:
	Input: s = "a"
	Output: "a"
	
Example 4:
	Input: s = "ac"
	Output: "a"

 * @author zia84
 *
 */
public class LongestPalindromicSubString {
	
	public String longestPalindromeW(String s) {
        int len = s.length();
        int ii=0;
        int jj=0;
        int max = 0;
        for (int i=0;i<len-1;i++){
            for (int j=i+1;j<len;j++){
                String str = s.substring(i,j+1);
                if (str.length()> max && isPalindromeW(str)){
                        if (max < str.length()) {
                            max = str.length();
                            ii = i;
                            jj = j;
                        }
                    }
                }
            }
        return s.substring(ii,jj+1);    
    }
    
    public static boolean isPalindromeW(String s){
        int i=0;
        int j= s.length()-1;
        while (i<j){ 
            if (s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }
	
	public String longestPalindromicBruteForce(String s) {
		if(s == null || s == "") {
			return s;
		}
		
		String result = "";
		
		Set<String> allSubStr = new HashSet<String>();
		
		for(int i=0;i<=s.length();i++) {
			for(int j=i;j<=s.length();j++) {
				if(s.substring(i,j).length() > 0) {
					allSubStr.add(s.substring(i,j));
				}
			}
		}
		result = palindromicString(allSubStr);
		//System.out.println(result);
		
		return result;
	}
	
	public String palindromicString(Set<String> allSubStr){
		Set<String> palindromicSubStr = new HashSet<String>();
		String result = "";
		int maxLen = 0;
		if(allSubStr!=null && allSubStr.size() > 0) {
			
			Iterator<String> itr = allSubStr.iterator();
			while(itr.hasNext()) {
				String s = itr.next();
				if(isPalindrome(s)) {
					palindromicSubStr.add(s);
					if(s.length() > maxLen) {
						result = s;
					}
					maxLen = Math.max(maxLen, s.length());
				}
			}
		}
		return result;
	}
	
	public static boolean isPalindrome(String s) {
		boolean isPalindrome = true;
		if(s!=null && s.length() > 0) {
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i) != s.charAt(s.length()-1-i)){
					return false;
				}
			}
		}
		return isPalindrome;
	}

	public String longestPalindrome(String s) {
		
		if(s == null || s == "") {
			return s;
		}
		
        int start = 0, end = 0;
        for(int i=0;i<s.length();i++) {
        	int len1 = expandAroundCenter(s, i, i);
        	int len2 = expandAroundCenter(s, i, i+1);
        	int len = Math.max(len1, len2);
        	 if (len > end - start) { //Calculate start and end based on i as center/midpoint
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
		//System.out.println(l.longestPalindrome("babad"));
		System.out.println(l.longestPalindrome("aba"));
		System.out.println(l.longestPalindromicBruteForce("abcd"));
		System.out.println(l.longestPalindromicBruteForce("aba"));
		long startTime = System.currentTimeMillis();
		System.out.println(l.longestPalindromeW("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth") );
		System.out.println(System.currentTimeMillis() - startTime);
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
