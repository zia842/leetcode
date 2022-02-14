import java.util.Arrays;

public class MinMovesToEqualArrayElements {

	public int minMoves2(int[] nums) {
		int steps = 0;

		int i = 0;
		int j = nums.length-1;
		Arrays.sort(nums);
		while(i < j) {
			steps += nums[j] - nums[i];
			i++;
			j--;
		}
		
		return steps;

	}
	
	public static void main(String []args) {
		MinMovesToEqualArrayElements m = new MinMovesToEqualArrayElements();
		System.out.println(m.minMoves2(new int[] {1,2,3}));
		System.out.println(m.minMoves2(new int[] {1,10,2,9}));
	}

}
