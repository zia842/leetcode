
public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		
		while(left <= right) {
			int middle = left + (right - left) / 2;
			if(nums[middle] == target) {
				return middle;
			}
			if(target < nums[middle]) {
				right = middle - 1;
			}
			else {
				left = middle + 1;
			}
		}
		
		return left;
	}
	
	public static void main(String []args) {
		SearchInsertPosition s = new SearchInsertPosition();
		System.out.println(s.searchInsert(new int[] {1,3,5,6}, 5));
		System.out.println(s.searchInsert(new int[] {1,3,5,6}, 2));
		System.out.println(s.searchInsert(new int[] {1,3,5,6}, 7));
	}

}
