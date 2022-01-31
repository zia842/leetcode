import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
	
	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
		for(int s : stones) {
			pq.add(s);
		}
		while(pq.size() > 1) {
			int stone1 = pq.poll();
			int stone2 = pq.poll();
			if(stone1!=stone2) {
				pq.add(stone1-stone2);
			}
			
		}
		return pq.isEmpty() ? 0 : pq.remove();
	}
	
	public static void main(String []args) {
		LastStoneWeight l = new LastStoneWeight();
		System.out.println(l.lastStoneWeight(new int[] {2,7,4,1,8,1}));
		System.out.println(l.lastStoneWeight(new int[] {1}));
	}

}
