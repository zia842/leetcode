/*class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}*/
public class RemoveLinkedListElements {
	
	public ListNode removeElements(ListNode head, int val) {
		ListNode updatedHead = head;
		ListNode modifiedHead = updatedHead;
		ListNode previousNode = null;
		
		//1->2->3
		while(updatedHead!=null) {
			
			if(updatedHead.val == val) {
				ListNode nextNode = updatedHead.next; 
				if(previousNode!=null) {
					previousNode.next = nextNode;
				}
				else {
					modifiedHead = nextNode;
					head = modifiedHead;
				}
					
			    //if(updatedHead.next!=null)
			    updatedHead = updatedHead.next;
				continue;
			}
			
			previousNode = updatedHead;
			updatedHead = updatedHead.next;
			
		}
		
		return modifiedHead;
		
	}
	
	public static void main(String []args) {
		RemoveLinkedListElements r = new RemoveLinkedListElements();
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
		head = r.removeElements(head, 2);
		System.out.println(head);
		head = new ListNode(1, new ListNode(2, new ListNode(3)));
		head = r.removeElements(head, 1);
		System.out.println(head);
		head = new ListNode(1, new ListNode(2, new ListNode(3)));
		head = r.removeElements(head, 3);
		System.out.println(head);
	}
}
