import java.util.Stack;

public class MinStack {
	
	Stack<int[]> stack = new Stack<int[]>();

	public MinStack() {

	}

	public void push(int val) {
		if(stack.isEmpty()) {
			stack.push(new int[] {val,val});
			return;
		}
		
		int currentMin = stack.peek()[1];
		stack.push(new int[] {val,Math.min(currentMin, val)});
	}

	public void pop() {
		stack.pop();
	}

	public int top() {
		return stack.peek()[0];
	}

	public int getMin() {
		return stack.peek()[1];
	}
	
	public static void main(String []args) {
		MinStack m = new MinStack();
		m.push(-1);
		m.push(-2);
		m.push(3);
		m.push(2);
		m.pop();
		System.out.println(m.top());
		System.out.println(m.getMin());
		
	}

}
