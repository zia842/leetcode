import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		
		if(nums!=null && nums.length > 0) {
			
			Arrays.sort(nums); //First Sort the numbers
			
			/***
			 *  a + b + c = 0
			 *  b + c = -a (Target)
			 *  Also check duplicates. Duplicates can be identified if array is sorted and two consecutive elements do not match
			 */
			for(int i=0;i<nums.length && nums[i] <= 0;i++) {
				
				if(i == 0 || nums[i-1] != nums[i]) {
					twoSum(nums, i, resultList);
				}
			}
		}
		
		return resultList;
    }
	
	public static void twoSum(int[] numbers, int i, List<List<Integer>> result) {
	    
		int low = i + 1;
		int high = numbers.length - 1;
		
		while(low < high) {
			int sum = numbers[i] + numbers[low] + numbers[high];
			if(sum < 0) {
				low++;
			}
			else if(sum > 0) {
				high--;
			}
			
			if(sum == 0) {
				result.add(Arrays.asList(numbers[i],numbers[low++],numbers[high--]));
				while(low < high && numbers[low] == numbers[low-1]) { //Skip duplicates
					low++;
				}
			}
			
		}
	}
	
	
	public static List<Integer> filterDuplicates(int[] numbers){
		List<Integer> filterList = new ArrayList<>();
		int i = 0;
		int low = 0;
		int high = numbers.length - 1;
		
		Arrays.sort(numbers);
		while(low < high) {
			
			filterList.add(numbers[low]);
			filterList.add(numbers[high]);
			low++; high--;
			while(low < high && numbers[low] == numbers[low-1]) {
				low++;
			}
			
			if(low == high) {
				filterList.add(numbers[low]);
			}
			
		}
		
		return filterList;
	}
	
	
	public static void main(String []args) {
		ThreeSum threeSum = new ThreeSum();
		threeSum.threeSum(new int[] {-1,0,1,2,-1,-4});
		System.out.println(filterDuplicates(new int[] {-1,0,1,2,-1,-4}));
		System.out.println(filterDuplicates(new int[] {1,1,1,1,1}));
	}
}
