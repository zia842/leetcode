
public class SingleElementInSortedArray {

	/**
	 * Binary Search to identify single element
	 * Single Element will exist only if array size is Odd
	 * @param nums
	 * @return
	 */
	public int singleNonDuplicate(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			int mid = (left + ((right-left)/2));
			if(mid%2 == 1)
				mid--;
			if(nums[mid] == nums[mid+1])
				left = mid + 2;
			else
				right = mid;
		}
		
		return nums[left];
	}
	
	public static void main(String []args) {
		SingleElementInSortedArray s = new SingleElementInSortedArray();
		System.out.println(s.singleNonDuplicate(new int[] {1,1,2,3,3,4,4,8,8}));
		System.out.println(s.singleNonDuplicate(new int[] {3,3,7,7,10,11,11}));
	}

}
