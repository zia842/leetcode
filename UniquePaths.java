
public class UniquePaths {
	
	public int uniquePaths(int m, int n) {
        
        int dpTable[][] = new int [m][n];
        
        for(int j=0;j<n;j++) {
        	dpTable[0][j] = 1;
        }
        
        for(int i=0;i<m;i++) {
        	dpTable[i][0] = 1;
        }
        
        for(int i=1;i<m;i++) {
        	for(int j=1;j<n;j++) {
        		dpTable[i][j] = dpTable[i][j-1] + dpTable[i-1][j];
        	}
        }
        
        return dpTable[m-1][n-1];
    }
	
	public static void main(String []args) {
		UniquePaths u = new UniquePaths();
		System.out.println(u.uniquePaths(3, 7));
		System.out.println(u.uniquePaths(3, 2));
		System.out.println(u.uniquePaths(7, 3));
		System.out.println(u.uniquePaths(3, 3));
		
	}

}
