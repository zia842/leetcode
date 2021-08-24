import java.util.PriorityQueue;

public class MergeKList {
	
	 public ListNode mergeKLists(ListNode[] lists) {
		 ListNode mergeList = null;
		 ListNode head = null;
		 PriorityQueue<Integer> queue = new PriorityQueue<>();
		 for(ListNode l : lists) {
			 while(l!=null) {
				 queue.offer(l.val);
				 l = l.next;
			 }
		 }
		 
		 while(queue!=null && !queue.isEmpty()) {
			 if(mergeList == null) {
				 mergeList = new ListNode(queue.poll());
				 head = mergeList;
			 }
			 else 
			 {
				 mergeList.next = new ListNode(queue.poll());
				 mergeList = mergeList.next;
			 }
		 }
		 return head;
		 
	 }
	 
	 public static void main(String []args) {
		 
		 PriorityQueue<Integer> queue = new PriorityQueue<>();
		 queue.offer(20);
		 queue.offer(5);
		 queue.offer(10);
		 System.out.println(queue.poll());
		 System.out.println(queue.poll());
		 System.out.println(queue.poll());
		 
		 MergeKList m = new MergeKList();
		 ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
		 ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
		 ListNode l3 = new ListNode(2, new ListNode(6));
		 
		 m.mergeKLists(new ListNode[] {l1,l2,l3});
		 m.mergeKLists(new ListNode[] {});
		 
	 }

}
