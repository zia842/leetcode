import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {
		int result = 0;
		if(nums!=null && nums.length > 0) {
			
			int dpTable[] = new int[nums.length];
			Arrays.fill(dpTable, 1);
			
			for(int i=1;i<nums.length;i++) {
				for(int j=0;j<i;j++) {
					if(nums[i] > nums[j]) {
						dpTable[i] = Math.max(dpTable[i], dpTable[j]+1);
					}
				}
			}
			
			for(int i=0;i<dpTable.length;i++) {
				result = Math.max(result, dpTable[i]);
			}
		
			
		}

		return result;
	}
	
	public static void main(String []args) {
		LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
		System.out.println(l.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
		System.out.println(l.lengthOfLIS(new int[] {0,1,0,3,2,3}));
		System.out.println(l.lengthOfLIS(new int[] {7,7,7,7,7,7,7}));
	}

}
