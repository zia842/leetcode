import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given the head of a linked list, find all the values that appear more than once in the 
 * list and delete the nodes that have any of those values.

   Return the linked list after the deletions.
   
   Input: head = [1,2,3,2]
   Output: [1,3]
   Explanation: 2 appears twice in the linked list, so all 2's should be deleted. 
   After deleting all 2's, we are left with [1,3].
   
   Input: head = [2,1,1,2]
   Output: []
   Explanation: 2 and 1 both appear twice. All the elements should be deleted.

 * @author zia84
 *
 */
public class RemoveDuplicatesFromLinkedList {
	
	public ListNode deleteDuplicates(ListNode head) {
		ListNode copyOfHead = head;
		
		while(copyOfHead!=null && copyOfHead.next!=null) {
			if(copyOfHead.next.val == copyOfHead.val) {
				copyOfHead.next = copyOfHead.next.next;
			}
			else {
				copyOfHead = copyOfHead.next;
			}
		}
		
		return head;
	}

	public ListNode deleteDuplicatesUnsorted(ListNode head) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> list = new LinkedHashSet<>();

		while(head != null){
			if(set.contains(head.val)){
				list.remove(head.val);
			} 
			else{
				list.add(head.val);
				set.add(head.val);
			}
			head = head.next;
		}

		head = new ListNode();
		ListNode temp = head;

		for (int val : list) {
			temp.next = new ListNode(val);
			temp = temp.next;
		}
		return head.next;
	}

	public ListNode deleteDuplicatesUnsortedCustom(ListNode head) {
		ListNode copyOfHead = head;
		ListNode p = null;
		ListNode modifiedHead = copyOfHead;

		Map<Integer,Integer> frequencyMap = new HashMap<Integer,Integer>();
		while(copyOfHead!=null) {
			Integer occurence = frequencyMap.getOrDefault(copyOfHead.val, 0);
			frequencyMap.put(copyOfHead.val, occurence + 1);
			copyOfHead = copyOfHead.next; //Advance Pointer
		}
		
		copyOfHead = head;
		while(copyOfHead!=null) {
			Integer occurence = frequencyMap.get(copyOfHead.val);
			if(occurence > 1) {
				if(p!=null) {
					p.next = copyOfHead.next;
					copyOfHead = copyOfHead.next; //Advance Pointer
					continue;
				}
				//If p is null but check if head node needs to be deleted
				copyOfHead = copyOfHead.next;
			}
			p = copyOfHead; //Before advancing pointer take a copy
			copyOfHead = copyOfHead.next; //Advance Pointer
		}
		return modifiedHead;
		
	}
	
	public static void main(String []args) {
		RemoveDuplicatesFromLinkedList r = new RemoveDuplicatesFromLinkedList();
		ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2))));
		//l1 = r.deleteDuplicatesUnsorted(l1);
		
		l1 = new ListNode(3, new ListNode(2, new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(2, new ListNode(4)))))));
		//l1 = r.deleteDuplicatesUnsorted(l1);
		
		l1 = new ListNode(2, new ListNode(1, new ListNode(1, new ListNode(2))));
		//l1 = r.deleteDuplicatesUnsorted(l1);
		
		
		l1 = new ListNode(1, new ListNode(1, new ListNode(2)));
		l1 = r.deleteDuplicates(l1);
		
		l1 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
		l1 = r.deleteDuplicates(l1);
		
		l1 = new ListNode(1, new ListNode(1, new ListNode(1)));
		l1 = r.deleteDuplicates(l1);
		
	}
}
