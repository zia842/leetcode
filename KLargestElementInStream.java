import java.util.PriorityQueue;

/**
 * 
 * @author zia84
 * 
 * 2 4 5 8
   4 5 8

   3 4 5 8 
   4 5 8 -> 4

   4 5 5 8
   5 5 8 -> 5

   5 5 8 10
   5 8 10 -> 5

   5 8 9 10
   8 9 10 -> 8

   4 8 9 10
   8 9 10 -> 8

 *
 */
public class KLargestElementInStream {
	
	PriorityQueue<Integer> pq; 
	
	private int k;

	public KLargestElementInStream(int k, int[] nums) {
		this.k = k;
		this.pq = new PriorityQueue<Integer>();
		
		for(int i=0;i<nums.length;i++) {
			this.pq.offer(nums[i]);
		}
		
		while(this.pq.size() > k && !this.pq.isEmpty()) {
			this.pq.poll();
		}
	}

	public int add(int val) {
		this.pq.offer(val);
		
		if(this.pq.size() > k && !this.pq.isEmpty()) {
			this.pq.poll();
		}
		
		return !this.pq.isEmpty() && this.pq.size() > 0 ? this.pq.peek() : -1;
	}
	
	public static void main(String []args) {
		KLargestElementInStream kthLargest = new KLargestElementInStream(3, new int[] {4, 5, 8, 2});
		System.out.println(kthLargest.add(3));   // return 4
		System.out.println(kthLargest.add(5));   // return 5
		System.out.println(kthLargest.add(10));  // return 5
		System.out.println(kthLargest.add(9));   // return 8
		System.out.println(kthLargest.add(4));   // return 8
	}

}
