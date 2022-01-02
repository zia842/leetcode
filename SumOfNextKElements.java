import java.util.Arrays;

public class SumOfNextKElements {
	
	public int sumOfNextKElements(int []nums, int k) {
		int sum = 0;
		
		if(nums == null || nums.length <= 0 || nums.length < k) {
			return sum;
		}
		
		Arrays.sort(nums); //Sort the array
		for(int i=0;i<k;i++) { //Consider only k elements for the first time
			sum += nums[i];
		}
		
		System.out.println(sum);
		int i = 0;
		for(int j=k;j<nums.length;j++) {
			sum = sum - nums[i++];
			sum = sum + nums[j];
			System.out.println(sum);
		}
		
		return sum;
	}
	/**
	 * Sorting not required
	 * @param nums
	 * @param k
	 * @return
	 */
	public int sumOfMaxNextKElements(int []nums, int k) {
		int sum = 0;
		if(nums == null || nums.length <= 0 || nums.length < k) {
			return sum;
		}
		
		for(int i=0;i<k;i++) { //Consider only k elements for the first time
			sum += nums[i];
		}
		
		int i = 0;
		int temp = sum;
		int endingIndex = 0;
		for(int j=k;j<nums.length;j++) {
			temp = temp - nums[i];
			temp = temp + nums[j];
			//sum = Math.max(sum, temp);
			if(temp > sum) {
				sum = temp;
				endingIndex = j;
			}
			i++; //Advance pointer
		}
		
		return sum;
	}
	
	
	public static void main(String []args) {
		SumOfNextKElements s = new SumOfNextKElements();
		System.out.println(s.sumOfMaxNextKElements(new int[]{6, 1, 4, 6, 3, 2, 7, 4}, 3));
	}

}
