
public class SearchInRotatedArray {

	public int search(int[] nums, int target) {
        
        if(nums == null || nums.length <= 0) {
        	return -1;
        }
        
        int left = 0;
        int right = nums.length-1;
        while(left < right) {
        	int mid = left + (right-left)/2;
        	
        	if(nums[mid] > nums[right]) {
        		left = mid + 1;
        	}
        	else {
        		right = mid;
        	}
        }
        
        System.out.println(nums[left] + " " + nums[right]);
        
        int start = left;
        left = 0;
        right = nums.length-1;
        
        if(target >= nums[start] && target <= nums[right]) {
        	left = start;
        }
        else {
        	right = start;
        }
        
        while(left <= right) {
        	
        	int mid = left + (right-left) / 2;
        	if(nums[mid] == target) {
        		return mid;
        	}
        	else if(target > nums[mid]) {
        		left = mid + 1;
        	}
        	else {
        		right = mid-1;
        	}
        	
        }
        return -1;
    }
	
	public static void main(String []args) {
		SearchInRotatedArray s = new SearchInRotatedArray();
		System.out.println(s.search(new int[] {4,5,6,7,8,1,2,3}, 5));
		System.out.println(s.search(new int[] {4,5,6,7,8,1,2}, 2));
		System.out.println(s.search(new int[] {4,5,6,7,8,1,2}, 4));
		System.out.println(s.search(new int[] {4,5,6,7,8,1,2}, 1));
	}
	
	
}
