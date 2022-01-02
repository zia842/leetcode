
public class MaxAreaIsland {
	
	public int maxAreaOfIsland(int[][] grid) {
		int result = 0;
		int maxArea = 0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j] == 1) {
					result = dfs(grid, i, j);
					maxArea = Math.max(maxArea, result);
					
				}
			}
		}
		
		return maxArea;
	}
	
	public int dfs(int [][]grid, int row, int col) {
		if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
			return 0;
		}
		
		grid[row][col] = 0;
		return 1 + dfs(grid, row+1, col) +	dfs(grid, row-1, col) 
					+ dfs(grid, row, col+1) + dfs(grid, row, col-1);
	}

}
