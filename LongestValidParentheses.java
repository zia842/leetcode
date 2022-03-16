
public class LongestValidParentheses {

	public int longestValidParentheses(String s) {
		
		int left = 0;
		int right = 0;
		int maxLength = 0;
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == '(') {
				left++;
			}
			else {
				right++;
			}
			
			if(left == right) { //Number of Brackets open brackets = closed brackets
				maxLength = Math.max(maxLength, 2 * right); 
			}
			else if(right >= left) { //If number of closed brackets > open brackets
				left = right = 0;
			}
		}
		
		left = right = 0;
		
		for(int i=s.length()-1;i>=0;i--) {
			if(s.charAt(i) == '(') {
				left++;
			}
			else {
				right++;
			}
			if(left == right) { //Number of Brackets open brackets = closed brackets
				maxLength = Math.max(maxLength, 2 * left); 
			}
			else if(left >= right) { //If number of open brackets > closed brackets
				left = right = 0;
			}
		}
		return maxLength;

	}
	
	public static void main(String []args) {
		LongestValidParentheses l = new LongestValidParentheses();
		System.out.println(l.longestValidParentheses("(()"));
		System.out.println(l.longestValidParentheses(")()())"));
		System.out.println(l.longestValidParentheses(""));
	}

}
