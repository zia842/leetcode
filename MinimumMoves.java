
public class MinimumMoves {

	public int minMoves(int[] nums) {
		int moves = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			moves += nums[i];
			min = Math.min(min, nums[i]);
		}
		return moves - min * nums.length; //Sum of All the elements - (Minimum Number * number of elements)
	}
	
	public static void main(String []args) {
		MinimumMoves m = new MinimumMoves();
		System.out.println(m.minMoves(new int[] {1,2,3}));
	}
}
