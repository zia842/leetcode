
public class MinimumAddToMakeParenthesesValid {

	public int minAddToMakeValid(String s) {
		
		int bal = 0;
		int ans = 0;
		for(int i=0;i<s.length();i++) {
			bal += s.charAt(i) == '(' ? 1 : -1;
			if(bal == -1) {
				bal++;
				ans++;
			}
		}
		return bal + ans; //Balanced Brackets are Number of Open Bracket = Closing Brackets
	}
	
	public static void main(String []args) {
		MinimumAddToMakeParenthesesValid m = new MinimumAddToMakeParenthesesValid();
		System.out.println(m.minAddToMakeValid("())"));
		System.out.println(m.minAddToMakeValid("((("));
		System.out.println(m.minAddToMakeValid(")("));
	}

}
