
public class WaysToMakeArrayFair {

	public int waysToMakeFair(int[] nums) {
		int numOfWays = 0;

		if(nums == null || nums.length <= 0)
			return numOfWays;
			
		int n = nums.length;
		int evenSum[] = new int[n+1];
		int oddSum[] = new int[n+1];
		
		for(int i=0;i<n;i++) {
			if(i%2 == 0) {
				evenSum[i+1] = evenSum[i] + nums[i];
				oddSum[i+1] = oddSum[i];
			}
			else {
				oddSum[i+1] = oddSum[i] + nums[i];
				evenSum[i+1] = evenSum[i];
			}
		}
		
		for(int i=0;i<nums.length;i++) {
			int nos = oddSum[i] + evenSum[n] - evenSum[i+1];
			int nes = evenSum[i] + oddSum[n] - oddSum[i+1];
			
			if(nos == nes) {
				numOfWays++;
			}
		}
		
		return numOfWays;
	}
	
	public static void main(String []args) {
		WaysToMakeArrayFair w = new WaysToMakeArrayFair();
		System.out.println(w.waysToMakeFair(new int[] {6,1,7,4,1}));
		System.out.println(w.waysToMakeFair(new int[] {2,1,6,4}));
		System.out.println(w.waysToMakeFair(new int[] {1,1,1}));
		System.out.println(w.waysToMakeFair(new int[] {1,2,3}));
	}

}
