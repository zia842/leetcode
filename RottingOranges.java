import java.util.HashSet;
import java.util.Set;

public class RottingOranges {

	/**
	 * Time Complexity O(N)
	 * Space Complexity O(N)
	 * @param grid
	 * @return
	 */
	public int orangesRotting(int[][] grid) {
	
		Set<String> fresh = new HashSet<String>();
		Set<String> rotten = new HashSet<String>();
		
		/**
		 * Capture cell location where fresh oranges, Rotten Oranges
		 */
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j] == 1) {
					fresh.add("" + i + j);
				}
				else if(grid[i][j] == 2) {
					rotten.add("" + i + j);
				}
			}
		}

		int minutes = 0;
		int directions[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}}; //Up, Down, Left, Right
		
		//Simulate using BFS
		while(fresh.size() > 0) {
			Set<String> infected = new HashSet<String>();
			for(String s : rotten) {
				int i = s.charAt(0) - '0';
				int j = s.charAt(1) - '0';
				for(int []direction : directions ) {
					int nextI = i + direction[0]; 
					int nextJ = j + direction[1];
					if(fresh.contains("" + nextI + nextJ)) {
						fresh.remove("" + nextI + nextJ);
						infected.add("" + nextI + nextJ);
					}
				}
			}
			
			if(infected.size() == 0) {
				return -1;
			}
			rotten = infected;
			minutes++;
		}
		
		return minutes;
	}
	
	public static void main(String []args) {
		RottingOranges r = new RottingOranges();
		System.out.println(r.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
		System.out.println(r.orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}}));
		System.out.println(r.orangesRotting(new int[][]{{0,2}}));
	}	

}
