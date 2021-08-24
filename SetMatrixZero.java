import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetMatrixZero {

	public void setZeroes(int[][] matrix) {
        
		List<int[]> zeroMatrix = new ArrayList<int[]>();
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j] == 0) {
					zeroMatrix.add(new int[]{i,j});
				}
			}
		}
		
		Set<Integer> rowSet = new HashSet<Integer>();
		Set<Integer> colSet = new HashSet<Integer>();
		
		for(int arr[] : zeroMatrix) {
			int row = arr[0];
			int col = arr[1];
			
			for(int j=0;j<matrix[0].length && !rowSet.contains(row);j++) {
				matrix[row][j] = 0;
		    }
			for(int i=0;i<matrix.length && !colSet.contains(col);i++) {
				matrix[i][col] = 0;
		    }
			rowSet.add(row);
			colSet.add(col);
		}
		
    }
	
	
	public static void main(String []args) {
		SetMatrixZero s = new SetMatrixZero();
		s.setZeroes(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
		s.setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
	}
}
