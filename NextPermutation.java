
public class NextPermutation {

	public void nextPermutation(int[] nums) {

		if(nums!=null && nums.length > 0) {

			int i = nums.length - 2;
			//Find first decreasing element
			while (i >= 0 && nums[i + 1] <= nums[i]) {
				i--;
			}

			if (i >= 0) {
				int j = nums.length - 1;
				//Find first greater number than i
				while (nums[j] <= nums[i]) {
					j--;
				}
				swap(nums, i, j);
			}
			reverse(nums, i+1);
		}

	}
	private void reverse(int[] nums, int start) {
		int i = start, j = nums.length - 1;
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String []args) {
		NextPermutation n = new NextPermutation();
		n.nextPermutation(new int[] {1,5,8,4,7,6,5,3,1});
	}

}
