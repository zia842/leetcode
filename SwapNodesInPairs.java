
public class SwapNodesInPairs {

	public ListNode swapPairs(ListNode head) {
		/*
		 * ListNode q = head; ListNode result = q;
		 * 
		 * while(q!=null && q.next!=null) { head = swapNodes(q,q.next); q = head; q =
		 * q.next!=null ? q.next.next : null; }
		 * 
		 * 
		 * return result;
		 */
		
		// Dummy node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;
        
		while(head!=null && head.next!=null) {
			
			ListNode firstNode = head;
			ListNode secondNode = head.next;
			
			prevNode.next = secondNode;
			firstNode.next = secondNode.next;
			secondNode.next = firstNode;
			
			prevNode = firstNode;
			head = firstNode.next;
			
		}
		
		return dummy.next;
		
    }
	
	public ListNode swapNodes(ListNode p, ListNode q) {
		ListNode r = q!=null ? q.next : null;
		q.next = p;
		p.next = r;
		p = q;
		return p;
	}
	
	public static void main(String []args) {
		 ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
		 ListNode l3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
		 SwapNodesInPairs s = new SwapNodesInPairs();
		 //s.swapPairs(l1);
		// s.swapPairsRecursive(l3);
	 }
	
	public ListNode swapPairsRecursive(ListNode head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode firstNode = head;
		ListNode secondNode = head.next;
		
		firstNode.next = swapPairs(secondNode.next);
		secondNode.next = firstNode;
		
		return secondNode;
	}
	

}
