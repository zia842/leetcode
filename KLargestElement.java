import java.util.Arrays;
import java.util.PriorityQueue;

public class KLargestElement {

	public int findKthLargestUsingSort(int[] nums, int k) {
		
		if(k > nums.length) {
			return -1;
		}
		
		int result = nums[0];
		Arrays.sort(nums);
		int counter = 0;
		for(int i=nums.length-1;i>=0;i--) {
			if(k == ++counter) {
				return nums[i];
			}
			
		}

		return result;
	}
	
	
	public int findKthLargest(int[] nums, int k) {
		if(k > nums.length) {
			return -1;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int n : nums) {
			pq.offer(n);
			
			if(pq.size() > k) {
				pq.poll();
			}
		}
		
		 return !pq.isEmpty() && pq.size() > 0 ? pq.poll() : -1;
	}
	
	public static void main(String []args) {
		KLargestElement k = new KLargestElement();
		System.out.println(k.findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
		System.out.println(k.findKthLargest(new int[] {3,2,1,5,6,4}, 2));
	}

}
