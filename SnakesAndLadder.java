import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakesAndLadder {

	public int snakesAndLadders(int[][] board) {
		int n = board.length;
        Map<Integer, int[]> map = new HashMap<>();
        int num = 1;
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
	} 

}
