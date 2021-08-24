
public class JumpGame {
	
	public boolean canJump(int[] nums) {
        
		int lastGoodPositionIndex = nums[nums.length-1];
		for(int i=nums.length-1;i>=0;i--) {
			if(i+nums[i] >= lastGoodPositionIndex) {
				lastGoodPositionIndex = i;
			}
		}
		
		return lastGoodPositionIndex == 0;
    }
	
	public static void main(String []args) {
		JumpGame j = new JumpGame();
		System.out.println(j.canJump(new int[] {2,3,1,1,4}));
		System.out.println(j.canJump(new int[] {3,2,1,0,4}));
	}

}
