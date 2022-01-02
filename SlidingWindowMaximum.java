import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
	
	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums!=null && nums.length > 0 ? nums.length : 0;
		if(n == 0)
			return new int[0];
		
		int result[] = new int[n-k+1];
		int count = 0;
		
		Deque<Integer> dequeue = new ArrayDeque<>();
		for(int i=0; i<nums.length; i++) { 
			
			while(!dequeue.isEmpty() && dequeue.peekLast() < nums[i]) { //Remove all the elements which are < current element in queue
				dequeue.pollLast();
			}
			
			dequeue.offerLast(nums[i]); //Step 1 : Add the element in queue
			
			/**
			 * Step 2 : Take the max element from queue if queue has sufficient elements 
			 * i.e as index starts from zero 
			 */
			if(i >= k-1) { 
				result[count++] = dequeue.peek();
				
				/**
				 * Step 3 : After adding element to result remove the element
				 */
				if(!dequeue.isEmpty() && nums[i-k+1] == dequeue.peekFirst()) {
					dequeue.pollFirst();
				}
			}
			
		}

		return result;
	}
	
	public static void main(String []args) {
		SlidingWindowMaximum s = new SlidingWindowMaximum();
		int input[][] = new int[][] {{1,3,-1,-3,5,3,6,7},{1},{1,-1},{9,11},{4,-2}};
		int inputK[] = new int[] {3,1,1,2,2};
		for(int i=0;i<input.length;i++) {
			int result[] = s.maxSlidingWindow(input[i], inputK[i]);
			System.out.println("\n");
			for(int j=0;j<result.length;j++) {
				System.out.print(result[j] + " ");
			}
		}
		
	}

}
