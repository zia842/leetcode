
public class PalindromeLinkedList {

	/**
	 * Time Complexity O(N)
	 * Space Complexity O(1)
	 * @param head
	 * @return
	 */
	
	public boolean isPalindrome(ListNode head) {
		if(head == null) return true;
		
		// Find the end of first half and reverse second half.
		ListNode firstHalfEnd    = endOfFirstHalf(head);
		ListNode secondHalfStart = reverseList(firstHalfEnd.next);
		
		ListNode p1 = head;
		ListNode p2 = secondHalfStart;
		boolean result = true;
		while(result && p2 != null) {
			if(p1.val != p2.val) result = false;
			p1 = p1.next;
			p2 = p2.next;
		}
		
		firstHalfEnd.next = reverseList(secondHalfStart); //Reverting back the original state of list
		
		return result;
	}
	
	private ListNode endOfFirstHalf(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next!=null && fast.next.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	private ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while(curr!=null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}

}
