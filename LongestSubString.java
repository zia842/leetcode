import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestSubString {

	public int lengthOfLongestSubstring(String s) {
		int maxLength = 0;
		int i = 0;
		int j = 0;
		
		Set<Character> charSet = new HashSet<Character>();
		int charArr[] = new int[256];
		while(j < s.length()) {
			if(!charSet.contains(s.charAt(j))) {
				charSet.add(s.charAt(j));
				j++;
				maxLength = Math.max(maxLength, charSet.size());
			}
			else 
			{
				charSet.remove(s.charAt(i));
				i++;
			}
			
		}
		
		return maxLength;
    }
	
	public int lengthOfLongestSubstringUsingArray(String s) {
		int maxLength = 0;
		int i = 0;
		int j = 0;
		int charArr[] = new int[256];
		int charArrSize = 0;
		List<String> strList = new ArrayList<String>();
		while(j < s.length()) {
			if(charArr[s.charAt(j)] == 0) {
				charArr[s.charAt(j)]++;
				j++;
				charArrSize++;
				maxLength = Math.max(maxLength, charArrSize);
				strList.add(s.substring(i,j));
			}
			else {
				charArr[s.charAt(i)]--;
				i++;
				charArrSize--;
			}
		}
		final int max = maxLength;
		List<String> resultList = strList
										.stream()
										.filter(st -> st.length() == max)
										.collect(Collectors.toList());
		return maxLength;
	}
	
	
	public static void main(String []args) {
		LongestSubString l = new LongestSubString();
		System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(l.lengthOfLongestSubstring("bbbbb"));
		System.out.println(l.lengthOfLongestSubstring("pwwkew"));
		System.out.println(l.lengthOfLongestSubstring(""));
		
		System.out.println("*************************************");
		
		System.out.println(l.lengthOfLongestSubstringUsingArray("abcabcbb"));
		System.out.println(l.lengthOfLongestSubstringUsingArray("bbbbb"));
		System.out.println(l.lengthOfLongestSubstringUsingArray("pwwkew"));
		System.out.println(l.lengthOfLongestSubstringUsingArray(""));
		System.out.println(l.lengthOfLongestSubstringUsingArray("acca"));
	}
	
}
