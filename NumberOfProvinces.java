
public class NumberOfProvinces {

	public int findCircleNum(int[][] isConnected) {
		int count = 0;
		boolean []visited = new boolean[isConnected.length];
		for(int i=0;i<isConnected.length;i++) {
			if(!visited[i]) {
				dfs(isConnected, visited, i);
				count++;
			}
		}
		return count;
	}
	
	public void dfs(int [][]grid, boolean []visited, int i) {
		for(int j=0;j<grid.length;j++) {
			if(grid[i][j] == 1 && !visited[j]) {
				visited[j] = true;
				dfs(grid, visited, j);
			}
		}
	}
	
	public static void main(String []args) {
		NumberOfProvinces n = new NumberOfProvinces();
		System.out.println(n.findCircleNum(new int[][] {{1,1,0},{1,1,0},{0,0,1}}));
	}

}
