import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestBridge {
	
	class Pair{
		int row;
		int col;
		
		Pair(int row, int col){
			this.row = row;
			this.col = col;
		}
	}

	boolean [][] visited;
	int [][]direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; //Left, Right, Up, Down
	/**
	 *  0,  1 --> Move in Right Direction, Same Row Next Column
	 *  0, -1 --> Move in Left Direction, Same Row Previous Column
	 *  1,  0 --> Move Down, Next Row Same Column
	 *  -1, 0 --> Move Up, Previous Row, Same Column 
	 */
	
	Queue<Pair> queue = new ArrayDeque<Pair>();
	
	public int shortestBridge(int[][] grid) {
		visited = new boolean[grid.length][grid[0].length];
		boolean found = false;
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j] == 1) {
					queue.add(new Pair(i,j));
					dfs(i, j, grid);
					found = true;
					break;
				}
			}
			if(found)
				break;
		}
		
		while(!queue.isEmpty()) {
			Pair p = queue.remove();
			visited[p.row][p.col] = true;
			
			for(int i=0;i<direction.length;i++) {
				int newRow = p.row + direction[i][0];
				int newCol = p.col + direction[i][1];
				if(newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length 
						&& !visited[newRow][newCol]) {
					
					if(grid[newRow][newCol] == 0) {
						grid[newRow][newCol] = grid[p.row][p.col] + 1;
						queue.add(new Pair(newRow, newCol));
					}
					else if(grid[newRow][newCol] == 1) {
						return grid[p.row][p.col] - 1;
					}
				}
				
			}
			
		}
		
		return 0;
	}
	
	public void dfs(int row, int col, int [][]grid) {
		
		visited[row][col] = true;
		
		for(int i=0;i<direction.length;i++) {
			int newRow = row + direction[i][0];
			int newCol = col + direction[i][1];
			if(newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length 
					&& !visited[newRow][newCol] && grid[newRow][newCol] == 1) {
				queue.add(new Pair(newRow, newCol));
				dfs(newRow, newCol, grid);
			}
		}
		
	}
	
	public static void main(String []args) {
		ShortestBridge sh = new ShortestBridge();
		//System.out.println(sh.shortestBridge(new int[][] {{0,1},{1,0}}));
		System.out.println(sh.shortestBridge(new int[][] {{0,1,0},{0,0,0},{0,0,1}}));
	}

}
