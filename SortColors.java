
public class SortColors {

	public void sortColors(int[] nums) {
        int countArr[] = new int[3];
        for(int i=0;i<nums.length;i++) {
        	countArr[nums[i]]++;
        }
        int j = 0;
        for(int i=0;i<countArr.length;i++) {
        	while(countArr[i] > 0) {
        		nums[j++] = i;
        		countArr[i]--;
        	}
        }
    }
	
	public static void main(String []args) {
		SortColors s = new SortColors();
		s.sortColors(new int [] {2,0,2,1,1,0});
		s.sortColors(new int [] {2,0,1});
	}
}
