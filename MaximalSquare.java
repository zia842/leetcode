
public class MaximalSquare {

	public int maximalSquare(char[][] matrix) {
		
		int result = 0;
		int rows = matrix.length;
		int cols = rows > 0 ? matrix[0].length : 0;
		int dpTable[][] = new int[rows+1][cols+1];
		
		for(int i=1;i<=rows;i++) {
			for(int j=1;j<=cols;j++) {
				if(matrix[i-1][j-1] == '1') {
					dpTable[i][j] = Math.min(Math.min(dpTable[i-1][j], dpTable[i][j-1]), dpTable[i-1][j-1]) + 1;
					result = Math.max(result, dpTable[i][j]);
				}
			}
		}
		return result * result;
	}
	
	public static void main(String []args) {
		MaximalSquare m = new MaximalSquare();
		System.out.println(m.maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
	}

}
