import java.util.Arrays;

public class MaxOfMinPairs {
	
	public static int maxOfMinPairs(int[] nums) {
		int sum = 0;
		if(nums!=null && nums.length > 0) {
			Arrays.sort(nums);
			for(int i=0;i<nums.length;i++) {
				if(i%2==0) {
					sum+= nums[i];
				}
			}
		}
		return sum;
	}

}
