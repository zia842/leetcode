import java.util.HashMap;

/**
 * 416. Partition Equal Subset Sum
 * Split Set to Equal Subsets
 * 
 * Given a non-empty array nums containing only positive integers, 
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

Constraints:

    1 <= nums.length <= 200
    1 <= nums[i] <= 100


 * @author zia84
 *
 */

public class PartitionEqualSubsetSum {

	public boolean canPartition(int[] nums) {
		
		if(nums!=null && nums.length > 0) {
			
			int totalSum = 0;
			for(int i : nums) {
				totalSum += i;
			}
			
			if(totalSum%2!=0) { //If Total Sum is Odd then it cannot be split into two halves equally
				return false;
			}
			
			return canPartition(nums, 0, 0, totalSum, new HashMap<String,Boolean>());
		}
		
		return true;
	}
	
	public boolean canPartition(int []nums, int index, int sum, int totalSum, HashMap<String,Boolean> stateMap) {
		
		String key = index + "" + sum;
		if(stateMap.containsKey(key)) {
			return stateMap.get(key);
		}
		
		if(sum * 2 == totalSum) {
			return true;
		}
		
		if(index >= nums.length || sum > totalSum/2) {
			return false;
		}
		
		boolean result = canPartition(nums, index+1, sum, totalSum, stateMap) || canPartition(nums, index+1, sum+nums[index], totalSum, stateMap);
		stateMap.put(key, Boolean.valueOf(result));
		
		return result;
	}
	
	public static void main(String []args) {
		PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
		System.out.println(p.canPartition(new int[] {1,5,11,5}));
		System.out.println(p.canPartition(new int[] {1,2,3,5}));
		System.out.println(p.canPartition(new int[] {5,9,7,21}));
		System.out.println(p.canPartition(new int[] {9,3,1}));
	}
}
