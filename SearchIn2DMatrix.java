
public class SearchIn2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		
		int m = matrix.length;
		int n = matrix[0].length;
		int left = 0;
		int right = (m * n) - 1;
		
		while(left <= right) {
			
			int mid = (left + right) / 2;
			int rowMid = mid / n;
			int colMid = mid % n;
			
			if(target == matrix[rowMid][colMid]) {
				return true;
			}
			else if(target < matrix[rowMid][colMid]) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
			
		}
		
		return false;
	}
	
	
	public static void main(String []args) {
		SearchIn2DMatrix searchIn2DMatrix = new SearchIn2DMatrix();
		System.out.println(searchIn2DMatrix.searchMatrix(new int [][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13));
		System.out.println(searchIn2DMatrix.searchMatrix(new int [][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 11));
		System.out.println(searchIn2DMatrix.searchMatrix(new int [][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
	}

}
