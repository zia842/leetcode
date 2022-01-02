import java.util.Arrays;

public class MinimumTaps {

	public int minTaps(int n, int[] ranges) {
		int[] dp = new int[n + 1];
		for(int i = 0; i <= n; i++){
			int start = Math.max(0, i - ranges[i]);
			int end = i + ranges[i];
			dp[start] = Math.max(dp[start], end);
		}
		int count = 0;
		int next = 0;
		int farthest = 0;
		for(int i = 0; i <= n; i++){
			next = Math.max(next, dp[i]);
			if(i == farthest){
				count++;
				farthest = next;
				if(farthest >= n) return count;
			}
		}
		return farthest >= n? count: -1;
	}
	
	public int minBulbs(int n, int[] ranges) {
        // construct an array: the furthest point it can reach at current index
        int[] reached = new int[ranges.length];
        for(int i = 0; i < ranges.length; i++) {
            int pos = Math.max(0, i - ranges[i]);
            reached[pos] = Math.min(n , i + ranges[i]);
        }
        
        int res = 0;
        int levelS = 0, levelE = 0;  // next level start & end bound
        int furthest = 0;
        
        while (levelE < reached.length) {
            res += 1;
            for(int i  = levelS; i <= levelE; i++) {
                furthest = Math.max(furthest, reached[i]);
                if (furthest >= n ) return res;
            }
			// If furthest not change & also not return in the above for loop
			// means the furthest we can get will never reach to the end
            if (levelE == furthest) return -1; 
			
            // update the next level start & end bound
            levelS = levelE + 1;
            levelE = furthest;
        }
        return -1;
    }
	
	public static int getRadius(int[] lamps) {

        //Arrays.sort(houses);

        Arrays.sort(lamps);


        int i = 0;

        int radius = -1;

        //for (int house : houses) {

            while (i < lamps.length - 1 && lamps[i] + lamps[i + 1] <= i * 2) {

                i = i + 1;

            }


            radius = Math.max(radius, Math.abs(lamps[i] - i));

        //}


        return radius;

    }
	
	public static void main(String []args) {
		MinimumTaps m = new MinimumTaps();
		System.out.println(m.minTaps(5, new int[] {-1, 2, 2, -1, 0, 0}));
		System.out.println(m.getRadius(new int[] {-1, 2, 2, -1, 0, 0}));
		System.out.println(m.minTaps(8, new int[] {2, 3, 4, -1, 2, 0, 0, -1, 0}));
		System.out.println(m.getRadius(new int[] {2, 3, 4, -1, 2, 0, 0, -1, 0}));
	}

}
