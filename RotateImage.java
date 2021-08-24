
public class RotateImage {

	public void rotate(int[][] matrix) {
        if(matrix.length <= 1) {
        	return;
        }
        
        //Transpose
        //Swap Row -> Col; Col -> Row
        for(int i=0;i<matrix.length;i++) {
        	for(int j=i;j<matrix.length;j++) {
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[j][i];
        		matrix[j][i] = temp;
        	}
        }
        
        //Reverse the Array
        for(int i=0;i<matrix.length;i++) {
        	for(int j=0;j<matrix.length/2;j++) {
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[i][matrix.length-j-1];
        		matrix[i][matrix.length-j-1] = temp;
        	}
        	
        }
    }
	
	
	public static void main(String []args) {
		RotateImage r = new RotateImage();
		r.rotate(new int [][] {{1}});
		r.rotate(new int [][] {{1,2},{3,4}});
		r.rotate(new int [][] {{1,2,3},{4,5,6},{7,8,9}});
		r.rotate(new int [][] {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});
	}
}
