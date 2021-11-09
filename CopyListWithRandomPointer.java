import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {

	public Node copyRandomList(Node head) {
		Node clonedHead = null;
		Map<Node,Node> nodeMap = new HashMap<Node,Node>();
		
		Node copyOfHead = head;
		
		//Step 1 : Create Nodes and put it in a map
		while(copyOfHead!=null) {
			Node newNode = new Node(copyOfHead.val);
			nodeMap.put(copyOfHead, newNode);
			copyOfHead = copyOfHead.next;
		}
		
		//Step 2 : Iterate Nodes and set next, random pointers
		copyOfHead = head;
		int count = 0;
		while(copyOfHead!=null) {
			Node newNode = nodeMap.get(copyOfHead);
			newNode.next = nodeMap.get(copyOfHead.next);
			newNode.random = nodeMap.get(copyOfHead.random);
			if(count == 0) {
				clonedHead = newNode;
			}
			copyOfHead = copyOfHead.next;
			count++;
		}
		
		return clonedHead;
		
	}
	
	public static void main(String []args) {
		CopyListWithRandomPointer c = new CopyListWithRandomPointer();
		Node seven = new Node(7);
		Node thirteen = new Node(13);
		Node eleven = new Node(11);
		Node ten = new Node(10);
		Node one = new Node(1);
		
		seven.next = thirteen;
		
		thirteen.next = eleven;
		thirteen.random = seven;
		
		eleven.next = ten;
		eleven.random = one;
		
		ten.next = one;
		ten.random = eleven;
		
		one.random = seven;
		
		Node clone = c.copyRandomList(seven);
		System.out.println(clone);
		
		while(seven!=null) {
			System.out.print(" Value " + seven.val);
			
			if(seven.random!=null) {
				System.out.print(" Random  " + seven.random.val);
			}
			
			if(seven.next!=null) {
				System.out.print(" Next " + seven.next.val);
			}
			seven = seven.next;
			System.out.println("\n");
		}
		System.out.println("***********************Clone Copy**************************");
		while(clone!=null) {
			System.out.print(" Value " + clone.val);
			
			if(clone.random!=null) {
				System.out.print(" Random  " + clone.random.val);
			}
			
			if(clone.next!=null) {
				System.out.print(" Next " + clone.next.val);
			}
			clone = clone.next;
			System.out.println("\n");
		}
		
	}
}
