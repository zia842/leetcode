import java.util.Stack;

public class ValidParenthesisString {
	
	/**
	 * Two Stacks push indexes open bracket in Open Stack
	 * Push index if Star in Star Stack
	 * if Closing bracket and Open Stack is not empty pop it otherwise check if star stack is not empty pop it otherwise return false
	 * Position matters (*, *) this are good but not *( 
	 * @param s
	 * @return
	 */
	public boolean checkValidString(String s) {
		
		Stack<Integer> openStack = new Stack<Integer>();
		Stack<Integer> starStack = new Stack<Integer>();
		for(int i=0;i<s.length();i++) { //Balance Closing Brackets

			if(s.charAt(i) == '(') { 
				openStack.push(i);
			}
			else if(s.charAt(i) == '*') {
				starStack.push(i);
			}
			else { //')' Closing Bracket
				
				if(!openStack.isEmpty()) //Try Poping from Open Stack
					openStack.pop();
				else if(!starStack.isEmpty()) //If not check can it balanced via * from Star Stack
					starStack.pop();
				else
					return false; //Can't be balanced 
			}
		}
		
		while(!openStack.isEmpty()) { //Balance Open Brackets
			
			if(starStack.isEmpty())
				return false;
			else if(openStack.peek() < starStack.peek()) { //If open 0index is say 3 and closing indexes are at 0 or 1 or 2  
				openStack.pop();
				starStack.pop();
			}
			else {
				return false;
			}
				
		}
		
		
		return true; //If All cases pass
	}

}
