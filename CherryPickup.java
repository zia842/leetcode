
public class CherryPickup {
	
	int maxCheries = 0;
	
	static Boolean destinationReached = Boolean.valueOf(false);
	
	/**
	 * Some Test cases are Failing + Time Limit Exceeds
	 * @param grid
	 * @return
	 */
	public int cherryPickupBackTracking(int[][] grid) {
		cp(0, 0, grid, 0);
		return maxCheries;

	}
	
	public void cp(int row, int col, int [][]grid, int ccsf) {
		
		if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == -1) { //If Boundaries are not valid or Thorn exist
			return;
		}
		
		if(row == grid.length - 1 && col == grid[0].length - 1) { //Reached at Bottom
			helper(row, col, grid, ccsf); //Now go back to starting point
		}
		
		int cherries = grid[row][col]; //Pickup cherry
		grid[row][col] = 0; //Mark cherry as picked
		cp(row, col + 1, grid, ccsf + cherries); //Move Right
		cp(row + 1, col, grid, ccsf + cherries); //Move Down
		grid[row][col] = cherries; //Revert it back -- Backtracking
		
		
	}
	
	public void helper(int row, int col, int [][]grid, int ccsf) {
		if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == -1) { //If Boundaries are not valid or Thorn exist
			return;
		}
		
		if(row == 0 && col == 0) { //Reached at Top / Starting Point
			maxCheries = Math.max(maxCheries, ccsf);
			return;
		}
		
		int cherries = grid[row][col]; //Pickup cherry
		grid[row][col] = 0; //Mark cherry as picked
		helper(row, col - 1, grid, ccsf + cherries); //Move Left
		helper(row - 1, col, grid, ccsf + cherries); //Move Up
		grid[row][col] = cherries; //Revert it back -- Backtracking
		
	}
	
	
	/**
	 * Time Complexity o(n ^ 4)
	 * Space Complexity o (n ^ 4)
	 * @param grid
	 * @return
	 */
	
	public int cherryPickup(int[][] grid) {
		destinationReached = Boolean.valueOf(false);
		
		int dp[][][][] = new int[grid.length][grid.length][grid.length][grid.length];
		int c = cp1(0, 0, 0, 0, grid, dp);
		
		if(!destinationReached) { //If there is no valid path between (0, 0) and (n - 1, n - 1), then no cherries can be collected.
			return 0;
		}
		return c;
	}
	
	public int cp1(int r1, int c1, int r2, int c2, int [][]grid, int dp[][][][]) {
		
		if(r1 >= grid.length || r2 >= grid.length || c1 >= grid[0].length || c2 >= grid[0].length || grid[r1][c1] == -1
				|| grid[r2][c2] == -1) { //If Boundaries are not valid or Thorn exist
			return Integer.MIN_VALUE;
		}
		
		if(r1 == grid.length - 1 && c1 == grid[0].length - 1) { //If destination is reached
			destinationReached = Boolean.valueOf(true);
			return grid[r1][c1];
		}
		
		if(dp[r1][c1][r2][c2] != 0) {
			return dp[r1][c1][r2][c2];
		}
		
		
		int cherries = 0;
		
		if(r1 == r2 && c1 == c2) { //If both persons p1, p2 are on same cell they can pick up only 1 cherry
			cherries += grid[r1][c1]; 
		}
		else {
			cherries += grid[r1][c1] + grid[r2][c2]; 
		}
		
		/**
		 * Vertical is   Column + 1
		 * Horizontal is Row + 1
		 */
		int f1 = cp1(r1, c1 + 1, r2, c2 + 1, grid, dp); //Horizontal, Horizontal
		int f2 = cp1(r1 + 1, c1, r2, c2 + 1, grid, dp); //Vertical, Horizontal
		int f3 = cp1(r1, c1 + 1, r2 + 1, c2, grid, dp); //Horizontal, Vertical
		int f4 = cp1(r1 + 1, c1, r2 + 1, c2, grid, dp); //Vertical, Vertical
		
		
		cherries += Math.max(Math.max(f1, f2), Math.max(f3, f4));
		dp[r1][c1][r2][c2] = cherries;
		
		return cherries;
		
	}
	
	/**
	 * Time Complexity o(n ^ 4)
	 * Space Complexity o (n ^ 3)
	 * @param grid
	 * @return
	 */
	
	public int cherryPickupSpace(int[][] grid) {
		destinationReached = Boolean.valueOf(false);
		
		int dp[][][] = new int[grid.length][grid.length][grid.length];
		int c = cp1Space(0, 0, 0, grid, dp);
		
		if(!destinationReached) { //If there is no valid path between (0, 0) and (n - 1, n - 1), then no cherries can be collected.
			return 0;
		}
		return c;
	}
	
	public int cp1Space(int r1, int c1, int r2, int [][]grid, int dp[][][]) {
		
		int c2 = r1 + c1 - r2;
		
		if(r1 >= grid.length || r2 >= grid.length || c1 >= grid[0].length || c2 >= grid[0].length || grid[r1][c1] == -1
				|| grid[r2][c2] == -1) { //If Boundaries are not valid or Thorn exist
			return Integer.MIN_VALUE;
		}
		
		if(r1 == grid.length - 1 && c1 == grid[0].length - 1) { //If destination is reached
			destinationReached = Boolean.valueOf(true);
			return grid[r1][c1];
		}
		
		if(dp[r1][c1][r2] != 0) {
			return dp[r1][c1][r2];
		}
		
		
		int cherries = 0;
		
		if(r1 == r2 && c1 == c2) { //If both persons p1, p2 are on same cell they can pick up only 1 cherry
			cherries += grid[r1][c1]; 
		}
		else {
			cherries += grid[r1][c1] + grid[r2][c2]; 
		}
		
		/**
		 * Vertical is   Column + 1
		 * Horizontal is Row + 1
		 */
		int f1 = cp1Space(r1, c1 + 1, r2, grid, dp); //Horizontal, Horizontal
		int f2 = cp1Space(r1 + 1, c1, r2, grid, dp); //Vertical, Horizontal
		int f3 = cp1Space(r1, c1 + 1, r2 + 1, grid, dp); //Horizontal, Vertical
		int f4 = cp1Space(r1 + 1, c1, r2 + 1, grid, dp); //Vertical, Vertical
		
		
		cherries += Math.max(Math.max(f1, f2), Math.max(f3, f4));
		dp[r1][c1][r2] = cherries;
		
		return cherries;
		
	}
	
	
	
	public static void main(String []args) {
		CherryPickup c = new CherryPickup();
		/*
		 * c.cherryPickupBackTracking(new int[][] {{0,1,-1},{1,0,-1},{1,1,1}});
		 * System.out.println(c.maxCheries); c = new CherryPickup();
		 * c.cherryPickupBackTracking(new int[][] {{1,1,-1},{1,-1,1},{-1,1,1}});
		 * System.out.println(c.maxCheries); c.cherryPickupBackTracking(new int[][]
		 * {{1}}); System.out.println(c.maxCheries);
		 */
		
		System.out.println(c.cherryPickup(new int[][] {{0,1,-1},{1,0,-1},{1,1,1}}));
		System.out.println(c.cherryPickup(new int[][] {{1,1,-1},{1,-1,1},{-1,1,1}}));
		System.out.println(c.cherryPickup(new int[][] {{1}}));
	}

}
