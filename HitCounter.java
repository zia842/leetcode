import java.util.LinkedList;
import java.util.Queue;

public class HitCounter 
{
	
	private Queue<Integer> queue;
	
	public HitCounter() {
		queue = new LinkedList<Integer>();
	}

	public void hit(int timestamp) {
		queue.add(timestamp);
	}

	public int getHits(int timestamp) {
		while(!queue.isEmpty()) {
			int t = queue.peek();
			if(timestamp - t >= 300) {
				queue.poll();
			}
			else {
				break;
			}
		}
		return queue.size();
	}
	
	public static void main(String []args) {
		HitCounter hitCounter = new HitCounter();
		hitCounter.hit(1);
		hitCounter.hit(2);
		hitCounter.hit(3);
		System.out.println(hitCounter.getHits(4));
		hitCounter.hit(300);
		System.out.println(hitCounter.getHits(300));
		System.out.println(hitCounter.getHits(301));
	}
}
