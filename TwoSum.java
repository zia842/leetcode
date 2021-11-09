/**
 * Given an array of integers nums and an integer target, return indices of the two numbers 
 * such that they add up to target. You may assume that each input would have exactly one 
 * solution, and you may not use the same element twice.  
 * You can return the answer in any order.
 * 
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
   Output: [0,1]
   Output: Because nums[0] + nums[1] == 9, we return [0, 1].
  
   Example 2:
   Input: nums = [3,2,4], target = 6
   Output: [1,2]
   
   Example 3:
   Input: nums = [3,3], target = 6
   Output: [0,1]
   
 * @author zia84
 *
 */
import java.util.Hashtable;
public class TwoSum {
	
	 public static int[] twoSum(int[] nums, int target) {
        Hashtable<Integer,Integer> tableA = new Hashtable<Integer,Integer>();
        int[] result = new int[2];
        if(nums!=null && nums.length > 0){
        
            for(int i=0;i<nums.length;i++){
                tableA.put(nums[i],Integer.valueOf(i));
            }
            
            for(int i=0;i<nums.length;i++){
                
                if(tableA.get(target-nums[i])!= null
                            && tableA.get(target-nums[i])!= i){
                    result[0] = i;
                    result[1] = tableA.get(target-nums[i]);
                    break;
                }
            }
            
        }
        return result;
	 }
	 
	 public static void main(String []args) {
		 int arr[] = {2,7,11,15};
		 int target = 9;
		 int []result = twoSum(arr, target);
		 System.out.println(result[0] + " " + result[1]);
		 
		 result = twoSum(new int[]{3,3}, 6);
		 System.out.println(result[0] + " " + result[1]);
		 
		 result = twoSum(new int[]{3,2,4}, 6);
		 System.out.println(result[0] + " " + result[1]);
		 
	 }
}
