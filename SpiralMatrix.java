import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	 public List<Integer> spiralOrder(int[][] matrix) {
		 List<Integer> spiral = new ArrayList<Integer>();
		 
		 int row = 0;
		 int col = 0;
		 
		 int maxRow = matrix.length;
		 int maxCol = matrix[0].length;
		 
		 int totalSpiralCount = maxRow * maxCol;
		 
		 int spiralArr[][] = new int[maxRow][maxCol]; 
		 
		 int visitedArr[][] = new int[maxRow][maxCol]; //This is required to keep track if element has been visited or not 0 represents not visited
		 
		 int spiralCount = 0;
		 
		 int i = 0;
		 int j = 0;
	
		 while(spiralCount < totalSpiralCount) {
			
			 
			 spiralArr[i][j] = matrix[row][col];
			 spiral.add(matrix[row][col]);
			 visitedArr[row][col] = matrix[row][col];
			 spiralCount++;
			 
			 if(j < maxCol-1) {
				 j++;
			 }
			 else {
				 j = 0;
				 i++;
			 }
			 
					 
			 if((col + 1 < maxCol && row == 0)
					 || (row!=0 && row - 1 >= 0 && visitedArr[row-1][col] != 0 && col + 1 < maxCol && row < maxRow && visitedArr[row][col+1] == 0) ) { //Move Right
				 col++;
			 }
			 else if(row + 1 < maxRow && visitedArr[row+1][col] == 0) { //Move Down
				 row++;
			 }
			 else if(col - 1 >= 0 && visitedArr[row][col-1] == 0) {  //Move Left
				 col--;
			 }
			 else if(row - 1 >= 0 && visitedArr[row-1][col] == 0) { //Move Up
				 row--;
			 }
			 
		 }
		 
		 return spiral;
	 }
	 public List<Integer> spiralOrderEnhanced(int[][] matrix) {
		 List<Integer> spiral = new ArrayList<Integer>();
		 
		 int row = 0;
		 int col = 0;
		 
		 int maxRow = matrix.length;
		 int maxCol = matrix[0].length;
		 
		 int totalSpiralCount = maxRow * maxCol;
		 
		 
		 boolean visitedArr[][] = new boolean[maxRow][maxCol]; //This is required to keep track if element has been visited or not 0 represents not visited
		 
		 int spiralCount = 0;
		 
		 while(spiralCount < totalSpiralCount) {
			
			 
			 spiral.add(matrix[row][col]);
			 visitedArr[row][col] = true;
			 spiralCount++;
			 
					 
			 if((col + 1 < maxCol && row == 0)
					 || (row!=0 && row - 1 >= 0 && visitedArr[row-1][col] && col + 1 < maxCol && row < maxRow && !visitedArr[row][col+1]) ) { //Move Right
				 col++;
			 }
			 else if(row + 1 < maxRow && !visitedArr[row+1][col]) { //Move Down
				 row++;
			 }
			 else if(col - 1 >= 0 && !visitedArr[row][col-1]) {  //Move Left
				 col--;
			 }
			 else if(row - 1 >= 0 && !visitedArr[row-1][col]) { //Move Up
				 row--;
			 }
			 
		 }
		 
		 return spiral;
	 }
	 
	 public static void main(String []args) {
		 SpiralMatrix s = new SpiralMatrix();
		 //System.out.println(s.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
		 //System.out.println(s.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
		 System.out.println(s.spiralOrderEnhanced(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}}));
	 }
	 
}
