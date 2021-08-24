
public class FirstAndLastSearch {

	public int[] searchRange(int[] nums, int target) {
		int result[] = new int[] {-1,-1};

		if(nums == null || nums.length == 0) {
			return result;
		}
		
		int firstIndex = searchBound(nums, target, true);
		if(firstIndex == -1) {
			return result;
		}
		
		int lastIndex = searchBound(nums, target, false);
		result[0] = firstIndex;
		result[1] = lastIndex;
		
		return result;
    }
	/**
	 * 1. Follow Regular Binary Search
	 * 2. Below method needs to be called twice once to identify first element and last element
	 * 3. If Number Found then we need to identify if number is first, middle, last
	 * 3.1 If number is at beginning/first or number prior to mid is not same as target then we found first occurrence, 
	 * 3.2 Similar applies for last element if number next to mid is not same as target then we found last  occurrence
	 * 3.3 If number is not at beginning/first and prior number is same as mid & target then move index range end, begin
	 * 
	 * @param nums
	 * @param target
	 * @param isFirst
	 * @return
	 */
	public int searchBound(int[] nums, int target, boolean isFirst) {
		int resultIndex = -1;
		int begin = 0;
		int end = nums.length - 1;
		while(begin <= end) {
			int mid = (begin+end)/2;
			
			if(nums[mid] == target) {
				
				if(isFirst) {
					
					/**
					 * Check begin and mid index are same 
					 * Number prior to mid if not same
					 */
					if(begin == mid || nums[mid-1] != target) { 
						return mid;
					}
					else 
					{
						end = mid - 1; //As we are trying to search first occurrence move end 
					}
				}
				else 
				{
					if(end == mid || nums[mid+1] != target) {
						return mid;
					}
					else {
						begin = mid + 1; //As we are trying to search last occurrence move beginning 
					}
				}
				
			}
			else if(target > nums[mid]) {
				begin = mid + 1;
			}
			else {
				end = mid - 1;
			}
			
			
		}
		return resultIndex;
	}
	
	public static void main(String []args) {
		FirstAndLastSearch f = new FirstAndLastSearch();
		f.searchRange(new int[] {5,7,7,8,8,10}, 8);
		f.searchRange(new int[] {5,7,7,8,8,10}, 6);
		f.searchRange(new int[] {}, 0);
	}
}
