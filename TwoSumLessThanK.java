import java.util.Arrays;

public class TwoSumLessThanK {
	
	public int twoSumLessThanK(int[] nums, int k) {
		int result = -1;
		
		//Sort the array
		Arrays.sort(nums);
		int i = 0;
		int j = nums.length - 1;
		while(i<j) {
			int sum = nums[i] + nums[j];
			if(sum < k) {
				result = Math.max(sum, result);
				i++;
			}
			else {
				j--;
			}
		}
		
		return result;
	}
	
	public static void main(String []args) {
		TwoSumLessThanK t = new TwoSumLessThanK();
		System.out.println(t.twoSumLessThanK(new int [] {34,23,1,24,75,33,54,8}, 60));
		System.out.println(t.twoSumLessThanK(new int [] {10,20,30}, 15));
		System.out.println(t.twoSumLessThanK(new int [] {10,20,30}, 50));
	}

}
