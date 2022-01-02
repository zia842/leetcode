import java.util.Arrays;

public class KLargestElement {

	public int findKthLargest(int[] nums, int k) {
		
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
	
	public static void main(String []args) {
		KLargestElement k = new KLargestElement();
		System.out.println(k.findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
		System.out.println(k.findKthLargest(new int[] {3,2,1,5,6,4}, 2));
	}

}
