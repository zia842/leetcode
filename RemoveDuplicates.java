
public class RemoveDuplicates {

	public int removeDuplicates(int[] nums) {
		int i=0;
		for(int j=1;j<nums.length;j++) {
			if(nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
			}
		}
		
		//0 to i + 1 will return unique elements 
		return i + 1;
    }
	
	public static void main(String []args) {
		RemoveDuplicates r = new RemoveDuplicates();
		r.removeDuplicates(new int[] {1,1,2});
		r.removeDuplicates(new int[] {1,2,3});
		r.removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4});
		
	}
}
