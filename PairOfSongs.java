import java.util.HashMap;
import java.util.Map;

public class PairOfSongs {

	public int numPairsDivisibleBy60(int[] time) {
		int count = 0;
		if(time == null || time.length <= 0) {
			return count;
		}
		int k = 60;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<time.length;i++) {
			int t = time[i] % k;
			int c = (k - t) % k;
			count += map.getOrDefault(c, 0);
			map.put(t, map.getOrDefault(t, 0) + 1);
			
		}
		return count;
	}

	public static void main(String []args) {
		PairOfSongs p = new PairOfSongs();
		System.out.println(p.numPairsDivisibleBy60(new int[] {30,20,150,100,40}));
	}

}
