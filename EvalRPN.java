import java.util.Stack;

/**
 * Evaluate Reverse Polish Notation ~ Evaluate Postfix Notation
 * @author zia84
 *
 */
public class EvalRPN {
	
    public int evalRPN(String[] tokens) {
    	int result = 0;
    	Stack<Integer> stack = new Stack<Integer>();
    	for(int i=0;i<tokens.length;i++) {
    		
    		if(tokens[i].equals("+") || tokens[i].equals("-")
    				|| tokens[i].equals("*") || tokens[i].equals("/")) {
    			
    			if(!stack.isEmpty()) {
    				int op2 = stack.pop();
    				int op1 = stack.pop();
    				int r = 0;
    				if(tokens[i].equals("+")) {
    					r = op1 + op2;
    				}
    				if(tokens[i].equals("-")) {
    					r = op1 - op2;
    				}
					if(tokens[i].equals("*")) {
					    r = op1 * op2;					
					    				}
					if(tokens[i].equals("/")) {
						r = op1 / op2;
					}
					stack.push(r);
    			}
    		}
    		else 
    		{
    			stack.push(Integer.parseInt(tokens[i]));
    		}
    		
    	}
    	
    	result = !stack.isEmpty() ? stack.pop() : 0;
    	
    	return result;
    }
    
    public static void main(String []args) {
    	EvalRPN e = new EvalRPN();
    	System.out.println(e.evalRPN(new String[] {"2","1","+","3","*"}));
    	System.out.println(e.evalRPN(new String[] {"4","13","5","/","+"}));
    	System.out.println(e.evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }


}
