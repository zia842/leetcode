
public class BreakPalindrome {

	public String breakPalindrome(String palindrome) {
		
		if(palindrome.length() == 1) {
			return "";
		}
		
		char palindromeArr[] = palindrome.toCharArray();
		for(int i=0;i<palindromeArr.length/2;i++) {
			if(palindromeArr[i]!='a') {
				palindromeArr[i] = 'a';
				return String.valueOf(palindromeArr);
			}
		}
		
		palindromeArr[palindromeArr.length-1] = 'b';
		return String.valueOf(palindromeArr);
	}

}
