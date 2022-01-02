
/**
 * Given an m x n 2D binary grid grid which represents a 
 * map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 300
    grid[i][j] is '0' or '1'.

 * @author zia84
 *
 */
public class NumberOfIslands {

	public int numIslands(char[][] grid) {
		
		int result = 0;
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				result += dfs(grid,i,j);
			}
		}
		
		return result;

	}
	
	public int dfs(char[][] grid, int row, int col) {
		if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
			return 0;
		}
		
		grid[row][col] = '0';
		dfs(grid,row+1,col);
		dfs(grid,row-1,col);
		dfs(grid,row,col+1);
		dfs(grid,row,col-1);
		
		return 1;
		
	}

}
