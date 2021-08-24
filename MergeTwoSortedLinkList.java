
public class MergeTwoSortedLinkList {

	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 ListNode node = null;
		 ListNode head = node;
		 
		 while(l1!=null && l2!=null) {
			 if(l1.val < l2.val) {
				 if(node == null) {
					 node = new ListNode(l1.val);
					 head = node;
				 }
				 else 
				 {
					 node.next = new ListNode(l1.val);
					 node = node.next;
				 }
				 l1 = l1.next;
			 }
			 else 
			 {
				 if(node == null) {
					 node = new ListNode(l2.val);
					 head = node;
				 }
				 else 
				 {
					 node.next = new ListNode(l2.val);
					 node = node.next;
				 }
				 l2 = l2.next;
			 }
		 }
		 
		 while(l1!=null) {
			 if(node == null) {
				 node = new ListNode(l1.val);
				 head = node;
			 }
			 else 
			 {
				 node.next = new ListNode(l1.val);
				 node = node.next;
			 }
			 l1 = l1.next;
		 }
		 
		 while(l2!=null) {
			 if(node == null) {
				 node = new ListNode(l2.val);
				 head = node;
			 }
			 else 
			 {
				 node.next = new ListNode(l2.val);
				 node = node.next;
			 }
			 l2 = l2.next;
		 }
				 
		 
		 return head;
		 
	 }
	 
	 public static void main(String []args) {
		 ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
		 ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
		 MergeTwoSortedLinkList m = new MergeTwoSortedLinkList();
		 m.mergeTwoLists(l1, l2);
	 }
}
