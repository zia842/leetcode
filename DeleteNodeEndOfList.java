
public class DeleteNodeEndOfList {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p = head;
		ListNode q = null;
		
		int numberOfNodes = 0;
		while(p!= null) {
			p = p.next;
			numberOfNodes++; //Count the Number of Nodes
		}
		
		p = head; //Reset p back to head
		int deleteNodeAt = numberOfNodes-n+1; //As node needs to be deleted from end of the list
		int currentNode = 0;
		while(p!=null) {
			++currentNode;
			if(currentNode == deleteNodeAt) {
				if(q!= null) {
					q.next = p.next;
					return head;
				}
				else 
				{
					q = p.next;
					return q;
					//return q == null ? q = new ListNode() : q;
				}
			}
			q = p; //Before moving to next node bring pointer to previous node 
			p = p.next; //Move the node to next
		}
		return q;
    }
	
	public static void main(String []args) {
		ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		DeleteNodeEndOfList d = new DeleteNodeEndOfList();
		ListNode updatedNode = d.removeNthFromEnd(l1, 2);
		ListNode l2 = new ListNode(1);
		updatedNode = d.removeNthFromEnd(l2, 1);
		ListNode l3 = new ListNode(1, new ListNode(2));
		updatedNode = d.removeNthFromEnd(l3, 1);
		ListNode l4 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		updatedNode = d.removeNthFromEnd(l4, 1);
		System.out.println();
		
	}

}
