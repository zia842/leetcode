import java.util.Stack;
/**
 * MaxStack using 2 stacks
 * @author zia84
 *
 */

public class MaxStack {

	/**
	 * Time Complexity O(1) for all operations except popMax where its O(N)
	 * Space Complexity O(N)
	 */
	Stack<Integer> stack;
	Stack<Integer> maxStack;

	public MaxStack() {
		stack = new Stack();
		maxStack = new Stack();
	}

	public void push(int x) {
		int max = maxStack.isEmpty() ? x : maxStack.peek();
		maxStack.push(max > x ? max : x);
		stack.push(x);
	}

	public int pop() {
		maxStack.pop();
		return stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int peekMax() {
		return maxStack.peek();
	}

	public int popMax() {
		int max = peekMax();
		Stack<Integer> buffer = new Stack();
		while (top() != max) buffer.push(pop());
		pop();
		while (!buffer.isEmpty()) push(buffer.pop());
		return max;
	}
	
	public static void main(String []args) {
		MaxStack stk = new MaxStack();
		stk.push(5);   // [5] the top of the stack and the maximum number is 5.
		stk.push(1);   // [5, 1] the top of the stack is 1, but the maximum is 5.
		stk.push(5);   // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is the top most one.
		stk.top();     // return 5, [5, 1, 5] the stack did not change.
		stk.popMax();  // return 5, [5, 1] the stack is changed now, and the top is different from the max.
		stk.top();     // return 1, [5, 1] the stack did not change.
		stk.peekMax(); // return 5, [5, 1] the stack did not change.
		stk.pop();     // return 1, [5] the top of the stack and the max element is now 5.
		stk.top();     // return 5, [5] the stack did not change.
	}

}
