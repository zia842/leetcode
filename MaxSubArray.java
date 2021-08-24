
public class MaxSubArray {

	public int maxSubArray(int[] nums) {
        int maxGlobalSum = nums[0];
		int currentSum = nums[0];
        
		//Kadane's Algo
		for(int i=1;i<nums.length;i++) {
			currentSum = Math.max(nums[i], nums[i]+currentSum);
			maxGlobalSum = Math.max(maxGlobalSum, currentSum);
		}
        
        return maxGlobalSum;
    }
	
	public static void main(String []args) {
		
		MaxSubArray m = new MaxSubArray();
		System.out.println(m.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
		System.out.println(m.maxSubArray(new int[]{1}));
		System.out.println(m.maxSubArray(new int[]{5,4,-1,7,8}));
	}
}
