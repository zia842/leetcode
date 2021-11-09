
public class MoveZeroes {
	
	public void moveZeroes(int[] nums) {
		int lastNonZeroIndex = 0;
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=0) {
				nums[lastNonZeroIndex++] = nums[i];
			}
		}
		
		for(int i=lastNonZeroIndex;i<nums.length;i++) {
			nums[i] = 0;
		}
		
    }
	
	public static void main(String []args) {
		MoveZeroes m = new MoveZeroes();
		m.moveZeroes(new int[] {0,1,0,3,12});
		m.moveZeroes(new int[] {0});
		m.moveZeroes(new int[] {1,0});
		m.moveZeroes(new int[] {0,1});
	}
}
