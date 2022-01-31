import java.util.Stack;

public class BackspaceString {

	public boolean backspaceCompare(String s, String t) {
		return removeBackspace(s).equals(removeBackspace(t));
	}
	
	public String removeBackspace(String s) {
		Stack<String> stack = new Stack<String>();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!='#') {
				stack.push(String.valueOf(s.charAt(i)));
			}
			else {
				if(!stack.isEmpty())
					stack.pop();
			}
		}
		return String.valueOf(stack);
	}

}
