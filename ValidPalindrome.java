
public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		boolean isValidPalindrome = true;
		if(s!=null && !s.isEmpty()) {
			
			int i = 0;
			int j = s.length() - 1;
			while(i < j) {
				
				if(!Character.isLetterOrDigit(s.charAt(i))) {
					i++;
					continue;
				}
				if(!Character.isLetterOrDigit(s.charAt(j))) {
					j--;
					continue;
				}
				
				if(Character.toUpperCase(s.charAt(i)) == Character.toUpperCase(s.charAt(j))) {
					i++;
					j--;
				}
				else 
				{
					return false;
				}
			}
			
		}
		return isValidPalindrome;
	}
	
	public static void main(String []args) {
		ValidPalindrome v = new ValidPalindrome();
		System.out.println(v.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(v.isPalindrome("race a car"));
		System.out.println(v.isPalindrome("m,adam"));
	}

}
