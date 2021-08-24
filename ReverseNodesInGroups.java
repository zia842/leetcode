
public class ReverseNodesInGroups {
	
	ListNode revPtr;
	ListNode first;
	
	public ListNode reverseKGroup(ListNode head, int k) {
		int count = 0;
		ListNode node = head;
		while(node!=null) {
			
			
		}
		
		
        return null;
    }
	
	public static void main(String []args) {
		ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
		ReverseNodesInGroups r = new ReverseNodesInGroups();
		ListNode reverseList = r.reverseList(l1);
		
		//System.out.println(r.revPtr);
		while(r.revPtr!=null) {
			System.out.println(r.revPtr.val);
			r.revPtr = r.revPtr.next;
		}
	}
	
	public void reverseList(ListNode previousNode, ListNode currentNode) {
		if(currentNode!=null) {
			reverseList(currentNode, currentNode.next);
			currentNode.next = previousNode;
		}
		else {
			first = previousNode;
		}
	}
	
	public ListNode reverseList(ListNode head) {
		
		if(head == null) {
			return head;
		}
		
		ListNode reverseHead = reverseList(head.next);
		if(reverseHead == null) {
			reverseHead = head;
			revPtr = reverseHead;
		}
		else 
		{
			//reverseHead = reverseHead.next;
			reverseHead.next = new ListNode(head.val);
			reverseHead = reverseHead.next;
		}
		
		return reverseHead;
	}

}
