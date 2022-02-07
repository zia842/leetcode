import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxEventsCanBeAttended {

	public int maxEvents(int[][] events) {
		
		PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a,b)->a[1]-b[1]);

		Arrays.sort(events, (a,b)->a[0]-b[0]); //Sort by starting day

		int maxEvents = 0;
		int day = 1;//start from 1st day.
		int n = events.length;
		int i = 0;
		while(!minHeap.isEmpty() || i<n) {

			while(!minHeap.isEmpty() && minHeap.peek()[1] < day) //4. Before moving to next, remove the ones that ends before the current day.
				minHeap.poll();

			while(i<n && events[i][0] <= day){ //1. Consider the ones starts today(day or before)
				minHeap.offer(events[i]);
				i++;
			}

			if(!minHeap.isEmpty()) { //2. attend the one which ends first on that day
				maxEvents++;
				minHeap.poll();
			}
			day++; // 3. move to next day

		}

		return maxEvents;
	}

	public static void main(String []args) {
		MaxEventsCanBeAttended m = new MaxEventsCanBeAttended();
		System.out.println(m.maxEvents(new int [][] {{1,2},{2,3},{3,4},{1,2}}));
		System.out.println(m.maxEvents(new int [][] {{1,2},{2,3},{3,4}}));
		System.out.println(m.maxEvents(new int [][] {{1,4},{4,4},{2,2},{3,4},{1,1}}));
		System.out.println(m.maxEvents(new int [][] {{1,100000}}));
		System.out.println(m.maxEvents(new int [][] {{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7}}));
		System.out.println(m.maxEvents(new int [][] {{2,2}}));
		System.out.println(m.maxEvents(new int [][] {{1,2},{1,1}}));
	}

}
