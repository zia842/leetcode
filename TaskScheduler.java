import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

	public int leastInterval(char[] tasks, int n) {
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(Character c : tasks) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((a, b) -> b - a);
		priorityQueue.addAll(map.values());
		
		int cycles = 0;
		while(!priorityQueue.isEmpty()) {
			
			List<Integer> temp = new ArrayList<Integer>();
			for(int i=0;i<n+1;i++) {
				if(!priorityQueue.isEmpty()) {
					temp.add(priorityQueue.remove());
				}
			}
			
			for(int i : temp) {
				if(--i > 0)
					priorityQueue.add(i);
			}
			cycles += priorityQueue.isEmpty() ? temp.size() : n + 1;
		}
		return cycles;
	}
	
	public static void main(String []args) {
		TaskScheduler t = new TaskScheduler();
		System.out.println(t.leastInterval(new char[] {'A','A','A','B','B','B'}, 0));
		System.out.println(t.leastInterval(new char[] {'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
	}

}
