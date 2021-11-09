
public class PivotIndex {

	public int pivotIndex(int[] nums) {
		
		int sum = 0;
		int leftSum = 0;
		if(nums!=null && nums.length > 0) {
			
			for(int s : nums) {
				sum += s;
			}
			
			for(int i=0;i<nums.length;i++) {
				
				if(leftSum == sum-leftSum-nums[i]) {
					return i;
				}
				
				leftSum += nums[i];
			}
			
		}
		return -1;
	}
	
	public static void main(String []args) {
		PivotIndex p = new PivotIndex();
		System.out.println(p.pivotIndex(new int[] {1,7,3,6,5,6}));
		System.out.println(p.pivotIndex(new int[] {1,2,3}));
		System.out.println(p.pivotIndex(new int[] {2,1,-1}));
	}
	
}
