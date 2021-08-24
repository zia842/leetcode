import java.util.Arrays;

public class TwoSumTwo {

	public int[] twoSum(int[] numbers, int target) {
       int[] result = new int[2];
       
       if(numbers!=null && numbers.length > 0) {
    	   
    	   int start = 0;
    	   int end = numbers.length - 1;
    	   
    	   while(start < end) {
    		   if(numbers[start] + numbers[end] == target) {
    			   result[0] = start + 1;
    			   result[1] = end + 1;
    			   return result;
    		   }
    		   else if(numbers[start] + numbers[end] < target) {
    			   start++;
    		   }
    		   else {
    			   end--;
    		   }
    	   }
       }
       return result;
    }
	
	public int twoSumLessThanK(int[] nums, int k) {
        int maxSum = -1;
        
        if(nums!=null && nums.length > 0) {
        	Arrays.sort(nums);
        	int start = 0;
	     	int end = nums.length - 1;
	     	while(start < end) {
	     		if(nums[start] + nums[end] < k) {
	     			maxSum = Math.max(nums[start] + nums[end], maxSum);
	     			start++;
	     		}
	     		else 
	     		{
	     			end--;
	     		}
	     	}
     	   
        }
        return maxSum;
    }

	
	public static void main(String []args) {
		TwoSumTwo t = new TwoSumTwo();
		System.out.println(t.twoSum(new int[]{2,7,11,15}, 9));
		System.out.println(t.twoSum(new int[]{2,3,4}, 6));
		System.out.println(t.twoSum(new int[]{-1,0}, -1));
		
		System.out.println(t.twoSumLessThanK(new int[]{34,23,1,24,75,33,54,8}, 60));
		System.out.println(t.twoSumLessThanK(new int[]{10,20,30}, -1));
	}
	
}
