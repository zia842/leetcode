public class SortArrayByParity {
	
	public int[] sortArrayByParity(int[] nums) {

		int result[] = new int[nums.length];
		int t = 0;
		
		for(int i : nums) {
			if(i%2 == 0) {
				result[t++] = i;
			}
		}
		
		for(int i : nums) {
			if(i%2 != 0) {
				result[t++] = i;
			}
		}
		return result;
	}
	
	public static void main(String []args) {
		SortArrayByParity s = new SortArrayByParity();
		int result[] = s.sortArrayByParity(new int[] {3,1,2,4});
		for(int i : result) {
			System.out.print(i + " ");
		}
		
		result = s.sortArrayByParity(new int[] {0});
		for(int i : result) {
			System.out.print(i + " ");
		}
	}
}
