import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MaxStack2 {


	class Node
	{
		int value;
		Node prev, next;
		Node(int value){
			this.value = value;
		}
	}

	/**
	 * add, remove, containsKey O(LOG N)
	 */

	TreeMap<Integer, List<Node>> map;
	Node head, end;

	public MaxStack2() {
		this.map = new TreeMap<Integer, List<Node>>();
	}

	/**
	 * 6 -> 1 -> 5
	 * 
	 * @param x
	 */

	public void push(int x) {
		Node node = new Node(x);
		
		if(this.head!=null) {
			this.head.prev = node;
			node.next = head;
		}

		this.head = node;

		if(this.end == null) 
			this.end = this.head;
		

		if(!this.map.containsKey(x)) 
			this.map.put(x, new ArrayList<>());

		this.map.get(x).add(node);


	}

	public int pop() {

		if(this.head == null)
			return -1;

		int val = this.head.value;
		this.head = this.head.next; //Move to next node

		List<Node> list = this.map.get(val);
		Node n = list.get(list.size()-1); //Last Element

		if(n.prev!=null)
			n.prev.next = n.next;
		else 
			this.head = n.next;

		if(n.next!=null)
			n.next.prev = n.prev;
		else 
			this.end = n.prev;

		List<Node> temp = this.map.get(val);
		temp.remove(list.size()-1);

		if(temp.isEmpty())
			this.map.remove(val);

		return val;
	}

	public int top() {
		if(this.head == null)
			return -1;

		return this.head.value;
	}

	public int peekMax() {
		if(this.head == null)
			return -1;

		return this.map.lastKey();
	}

	public int popMax() {
		int max = peekMax();
		List<Node> list =  this.map.get(max);
		Node n= list.get(list.size()-1);
		
		if(n.prev!=null)
			n.prev.next = n.next;
		else 
			this.head = n.next;
		
		if(n.next!=null)
			n.next.prev = n.prev;
		else 
			end = n.prev;
		
		List<Node> temp = this.map.get(max);
		temp.remove(temp.size()-1);
		
		if(temp.isEmpty())
			this.map.remove(max);
		
		return max;
	}


	public static void main(String []args) {
		MaxStack2 stk = new MaxStack2();
		stk.push(5);   // [5] the top of the stack and the maximum number is 5.
		stk.push(1);   // [5, 1] the top of the stack is 1, but the maximum is 5.
		stk.push(5);   // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is the top most one.
		
		//stk.top();     // return 5, [5, 1, 5] the stack did not change.
		//stk.popMax();  // return 5, [5, 1] the stack is changed now, and the top is different from the max.
		//stk.top();     // return 1, [5, 1] the stack did not change.
		//stk.peekMax(); // return 5, [5, 1] the stack did not change.
		stk.pop();     // return 1, [5] the top of the stack and the max element is now 5.
		//stk.top();     // return 5, [5] the stack did not change.
	}

} 
