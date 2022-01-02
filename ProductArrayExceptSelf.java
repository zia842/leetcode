public class ProductArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {
		int resultArr[] = new int[nums.length];
		
		int leftArr[] = new int[nums.length];
		int rightArr[] = new int[nums.length];
		
		leftArr[0] = 1;
		for(int i=1;i<nums.length;i++) {
			leftArr[i] = nums[i-1] * leftArr[i-1];
		}
		
		
		rightArr[rightArr.length-1] = 1;
		for(int i=rightArr.length-2;i>=0;i--) {
			rightArr[i] = nums[i+1] * rightArr[i+1];
		}
		
		for(int i=0;i<nums.length;i++) {
			resultArr[i] = leftArr[i] * rightArr[i];
		}
		
		return resultArr;

	}
	
	public static void main(String []args) {
		ProductArrayExceptSelf p = new ProductArrayExceptSelf();
		int resultArr[] = p.productExceptSelf(new int[] {4,5,1,8,2});
		for(int i=0;i<resultArr.length;i++) {
			System.out.print(resultArr[i] + " ");
		}
		
	}

}
