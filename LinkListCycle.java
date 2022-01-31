import java.util.HashSet;
import java.util.Set;

public class LinkListCycle {

	public boolean hasCycle(ListNode head) {
		
		if(head == null || head.next == null) {
			return false;
		}
		
		Set<ListNode> set = new HashSet<ListNode>();
		ListNode node = head;
		while(node!=null) {
			if(set.contains(node)) {
				return true;
			}
			set.add(node);
			node = node.next;
			
		}
		
		return false;
	}
	
	public static void main(String []args) {
		LinkListCycle l = new LinkListCycle();
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = head.next;
		System.out.println(l.hasCycle(head));
		head = null;
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = head;
		System.out.println(l.hasCycle(head));
		head = null;
		head = new ListNode(1);
		System.out.println(l.hasCycle(head));
		
		
	}

}
