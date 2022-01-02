import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakesAndLadder {

	public int snakesAndLadders(int[][] board) { //Leet Code version
		int n = board.length;
        Map<Integer, int[]> map = new HashMap<>();
        int num = 1;
        /**
         * Map is required to identify cell number e.g 1 to 36 which row and col corresponds to
         */
        for(int i = n -1; i >= 0; i--) {
            for(int j = 0 ; j < n; j++) {
                if(i % 2 ==  (n - 1) % 2) {
                    map.put(num++, new int[]{i, j});
                } else {
                    map.put(num++, new int[]{i, n - 1 - j});
                }
            }
        }
        int step = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean[] visited = new boolean[n * n + 1];

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int cur = q.poll();
                if (visited[cur]) continue;
                visited[cur] = true;
                if(cur == n * n)
                    return step;
                for(int j = 1; j < 7 && cur + j <= n*n; j++) {
                    int[] curCell = map.get(cur + j);
                    int curX = curCell[0];
                    int curY = curCell[1];
                    int nxt = board[curX][curY] > 0 ? board[curX][curY] : cur + j;
                    if(!visited[nxt])
                        q.add(nxt);
                }
            }
            step++;
        }
        return -1;
	}

	public static void main(String []args) {
		SnakesAndLadder s = new SnakesAndLadder();
		System.out.println(s.snakesAndLadders(new int [][] {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}}));
		
		 // Let us construct the board given in above diagram
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;
 
        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;
 
        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;
 
        System.out.println("Min Dice throws required is " +
                          getMinDiceThrows(moves, N));
	} 
	
	/**
	 * For 1D Array Geeks4Geeks
	 */
	// An entry in queue used in BFS
    static class qentry
    {
        int v;// Vertex number
        int dist;// Distance of this vertex from source
    }
    
    // This function returns minimum number of dice
    // throws required to Reach last cell from 0'th cell
    // in a snake and ladder game. move[] is an array of
    // size N where N is no. of cells on board If there
    // is no snake or ladder from cell i, then move[i]
    // is -1 Otherwise move[i] contains cell to which
    // snake or ladder at i takes to.
    static int getMinDiceThrows(int move[], int n)
    {
        int visited[] = new int[n];
        Queue<qentry> q = new LinkedList<>();
        qentry qe = new qentry();
        qe.v = 0;
        qe.dist = 0;
 
        // Mark the node 0 as visited and enqueue it.
        visited[0] = 1;
        q.add(qe);
 
        // Do a BFS starting from vertex at index 0
        while (!q.isEmpty())
        {
            qe = q.remove();
            int v = qe.v;
 
            // If front vertex is the destination
            // vertex, we are done
            if (v == n - 1)
                break;
 
            // Otherwise dequeue the front vertex and
            // enqueue its adjacent vertices (or cell
            // numbers reachable through a dice throw)
            for (int j = v + 1; j <= (v + 6) && j < n; ++j)
            {
                // If this cell is already visited, then ignore
                if (visited[j] == 0)
                {
                    // Otherwise calculate its distance and
                    // mark it as visited
                    qentry a = new qentry();
                    a.dist = (qe.dist + 1);
                    visited[j] = 1;
 
                    // Check if there a snake or ladder at 'j'
                    // then tail of snake or top of ladder
                    // become the adjacent of 'i'
                    if (move[j] != -1)
                        a.v = move[j];
                    else
                        a.v = j;
                    q.add(a);
                }
            }
        }
 
        // We reach here when 'qe' has last vertex
        // return the distance of vertex in 'qe'
        return qe.dist;
    }
 
    

}
