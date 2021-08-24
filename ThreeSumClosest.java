import java.util.Arrays;

public class ThreeSumClosest {
	
	public int threeSumClosest(int[] nums, int target) {
		int diff = Integer.MAX_VALUE;
		
		int minSum = 0;
		
		if(nums!=null && nums.length > 0) {
			
			Arrays.sort(nums);
			
			for(int i=0;i<nums.length && diff!= 0;i++) {
				
				int low = i + 1;
				int high = nums.length - 1;
				
				while(low < high) {
					
					int sum = nums[i] + nums[low] + nums[high];
					
					if(Math.abs(target-sum) < Math.abs(diff)) { //Compare Difference using Absolute to prevent errors
						diff = target-sum;
						minSum = sum;
					}
					
					
					if(sum < target) {
						low++;
					}
					else {
						high--;
					}
				}
				
			}
			
		}
		
		return minSum;
    }
	
	
	public static void main(String [] args) {
		ThreeSumClosest t = new ThreeSumClosest();
		System.out.println(t.threeSumClosest(new int []{-1,1,2,-4}, 1));
		System.out.println(t.threeSumClosestAsProvided(new int []{-1,1,2,-4}, 1));
		
		System.out.println(t.threeSumClosest(new int []{1,1,-1,-1,3}, -1));
		System.out.println(t.threeSumClosestAsProvided(new int []{1,1,-1,-1,3}, -1));
	

	}
	
	public int threeSumClosestAsProvided(int[] nums, int target) {
	    int diff = Integer.MAX_VALUE, sz = nums.length;
	    Arrays.sort(nums);
	    for (int i = 0; i < sz && diff != 0; ++i) {
	        int lo = i + 1, hi = sz - 1;
	        while (lo < hi) {
	            int sum = nums[i] + nums[lo] + nums[hi];
	            if (Math.abs(target - sum) < Math.abs(diff))
	                diff = target - sum;
	            if (sum < target)
	                ++lo;
	            else
	                --hi;
	        }
	    }
	    return target - diff;
	}

}
