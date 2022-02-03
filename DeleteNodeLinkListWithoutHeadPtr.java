
public class DeleteNodeLinkListWithoutHeadPtr {
	
	/**
	 *  4 -> 5 -> 1 -> 9
	 *  Delete 5
	 *  
	 * @param node
	 */
	public void deleteNode(ListNode node) {
		// 1.Assigned node the next node value.
		node.val=node.next.val; //4 -> 1 -> 1 -> 9
		// 2.Break connection .
		node.next=node.next.next;  //4 -> 1 -> 9
	}
	
}
