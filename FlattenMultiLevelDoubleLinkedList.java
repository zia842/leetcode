import java.util.ArrayDeque;
import java.util.Deque;

class DoubleNode
{

	public int val;
	public DoubleNode prev;
	public DoubleNode next;
	public DoubleNode child;

	public DoubleNode() {}

	public DoubleNode(int _val,DoubleNode _prev,DoubleNode _next,DoubleNode _child) {
		val = _val;
		prev = _prev;
		next = _next;
		child = _child;
	}
}

public class FlattenMultiLevelDoubleLinkedList {


	/**
	 * Time Complexity O(N)
	 * Space Complexity O(N)
	 * @param head
	 * @return
	 */
	public DoubleNode flatten(DoubleNode head) {
		if (head == null) return head;

		DoubleNode pseudoHead = new DoubleNode(0, null, head, null);
		DoubleNode curr, prev = pseudoHead;

		Deque<DoubleNode> stack = new ArrayDeque<>();
		stack.push(head);

		while (!stack.isEmpty()) {

			curr = stack.pop();
			prev.next = curr;
			curr.prev = prev;

			//Order of nodes being pushed in stack is very important
			if (curr.next != null) stack.push(curr.next);

			if (curr.child != null) {
				stack.push(curr.child);
				// don't forget to remove all child pointers.
				curr.child = null;
			}
			prev = curr;
		}
		// detach the pseudo node from the result
		pseudoHead.next.prev = null;
		return pseudoHead.next;
	}

	public static void main(String []args) {
		FlattenMultiLevelDoubleLinkedList f = new FlattenMultiLevelDoubleLinkedList();
		DoubleNode one = new DoubleNode(1, null, null, null);
		DoubleNode two = new DoubleNode(2, null, null, null);
		DoubleNode three = new DoubleNode(3, null, null, null);
		DoubleNode four = new DoubleNode(4, null, null, null);
		DoubleNode five = new DoubleNode(5, null, null, null);
		DoubleNode six = new DoubleNode(6, null, null, null);
		DoubleNode seven = new DoubleNode(7, null, null, null);
		DoubleNode eight = new DoubleNode(8, null, null, null);
		DoubleNode nine = new DoubleNode(9, null, null, null);

		one.next = two;
		two.next = three;
		three.next = four;
		
		four.prev = three;
		three.prev = two;
		two.prev = one;
		
		two.child = five;
		
		five.next = six;
		six.next = seven;
		
		seven.prev = six;
		six.prev = five;
		
		six.child = eight;
		
		eight.next = nine;
		
		nine.prev = eight;
		
		DoubleNode head = f.flatten(one);
		while(head!=null) {
			System.out.print(head.val + " --> ");
			head = head.next;
		}
			

	}



}
