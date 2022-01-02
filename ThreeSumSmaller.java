import java.util.Arrays;

public class ThreeSumSmaller {

	public int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
		int count = 0;
		for(int i=0;i<nums.length-2;i++) {
			count += twoSumSmaller(nums, target-nums[i], i+1); //target-nums[i] as we are checking only 2 numbers in twosum
		}
		return count;
	}
	
	public int twoSumSmaller(int []nums, int target, int startIndex) {
		int left = startIndex;
		int right = nums.length-1;
		int count = 0;
		while(left < right) {
			if(nums[left] + nums[right] < target) {
				count += right - left;
				left++;
			}
			else {
				right--;
			}
		}
		return count;
		
	}
	
	public static void main(String []args) {
		ThreeSumSmaller t = new ThreeSumSmaller();
		System.out.println(t.threeSumSmaller(new int[] {-2,0,1,3}, 2));
	}

}
