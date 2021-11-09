/**
 * Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative 
 * integers. The digits are stored in reverse order, and each of their 
 * nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
   You may assume the two numbers do not contain any leading zero, 
   except the number 0 itself.
   
   Example 1
   				2 --> 4 --> 3
   				5 --> 6 --> 4
   	O/P :       7 --> 0 --> 8
   	
   	Input: l1 = [2,4,3], l2 = [5,6,4]
	Output: [7,0,8]
	Explanation: 342 + 465 = 807.
	
  Example 2:
    Input: l1 = [0], l2 = [0]
	Output: [0]
	
  Example 3:
	Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
	Output: [8,9,9,9,0,0,0,1]
 * 
 */
import java.math.BigInteger;

public class AddTwoNumbers {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode resultList = null;
		BigInteger num1 = reverseListNumber(l1);
		BigInteger num2 = reverseListNumber(l2);
		BigInteger result = num1.add(num2);
		String reversedNumber = reverseNumber(result);
		ListNode rear = null;
		for(int i=0;i<reversedNumber.length();i++) {
			int val = Integer.parseInt(Character.toString(reversedNumber.charAt(i)));
			ListNode node = new ListNode();
			node.val = val;
			if(resultList == null) {
				resultList = node;
				rear = resultList;
			}
			else {
				rear.next = node;
				rear = rear.next;
				//resultList.next = rear;
			}
		}
		return resultList;
	}
	
	
	public static BigInteger reverseListNumber(ListNode l) {
		String s = "";
		while(l!=null) {
			s = BigInteger.valueOf(l.val).toString() + s;
			l = l.next;
		}
		return s!="" && s!=null && s.length() > 0 ? new BigInteger(s) : new BigInteger("0");
		
	}
	
	public static String reverseNumber(BigInteger number) {
		String result = "";
		if(number!=null) {
			String s = number.toString();
			if(s!=null && s!="") {
				for(char c : s.toCharArray()) {
					result = c + result;
				}
			}
			
		}
		return result;
	}
	
	public static void main(String []args) {
		
		/*
		 * ListNode two = new ListNode(2); ListNode four = new ListNode(4); ListNode
		 * three = new ListNode(3); two.next = four; four.next = three;
		 */
		ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
		
		ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
		
		ListNode l3 = new ListNode(0);
		
		ListNode l4 = new ListNode(1);
		
		ListNode zero = new ListNode(0);
		ListNode zero1 = new ListNode(0);
		ListNode zero2 = new ListNode(0);
		ListNode zero3 = new ListNode(1);
		
		zero.next = zero1;
		zero1.next = zero2;
		zero2.next = zero3;
		
		l4.next = zero;
		
		
		
		
		System.out.println(l1);
		
		AddTwoNumbers a = new AddTwoNumbers();
		a.addTwoNumbers(l1, l2);
		
		 BigInteger bd = new BigInteger("1000000000000000000000000000001");
		 System.out.println(bd.multiply(new BigInteger("100")));
	}

}
