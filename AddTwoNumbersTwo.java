import java.util.Stack;

public class AddTwoNumbersTwo {
	
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        long numOne = getNumber(l1);
        long numTwo = getNumber(l2);
        long result = numOne + numTwo;
       // System.out.println("Result is " + result);
        ListNode resultList = null;
        ListNode tempList = null;
        
        Stack<Long>stack = new Stack<Long>();
        
        //Handle separately if result is zero
        if(result == 0){
            return new ListNode((int)result);
        } 
    
        //System.out.println("Result is " + result);
        while(result > 0){
            long r = (long)result%10;
            //System.out.println("Mod is " + r);
            stack.push((long)result%10);
            result = result / 10;
        }
        
        if(!stack.isEmpty()){
            Long val = stack.pop();
            
            tempList = new ListNode(val.intValue());
            resultList = tempList; //Point to head
        }
       
                
        while(!stack.isEmpty()){
            Long val = stack.pop();
            tempList.next = new ListNode(val.intValue());
            tempList = tempList.next;
        }
        
        return resultList;
        
    }
    
    public long getNumber(ListNode head){
        long result = 0L;
        int numberOfNodes = 0;
        ListNode l = head;
        l = l.next; //Point to next node
        
        while(l!=null){
            numberOfNodes++;
            l = l.next;
        }
        
        l = head; //Now repoint to head
        while(l!=null){
            result = (long)(result + (l.val * Math.pow(10,numberOfNodes--)));
            l = l.next;
        }
        return result;
    }
}
