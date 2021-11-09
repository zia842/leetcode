import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {

	public int[] topKFrequent(int[] nums, int k) {
		int result[] = new int[k];
		
		Map<Integer, Integer> table = new HashMap<Integer, Integer>();
		for(Integer i : nums) {
			int frequency = table.getOrDefault(i, 0) + 1;
			table.put(i, frequency);
		}
		
		//Compare the priority remove the less frequent item first 
		Queue<Integer> heap = new PriorityQueue<>( (n1, n2) -> table.get(n1) -  table.get(n2));
		 
		
		for (int n: table.keySet()) {
			heap.add(n);
			if (heap.size() > k) {
				heap.poll();
				//System.out.print(heap.poll() + " ");    
			}
		}
		
		// 3. build an output array
        // O(k log k) time
        for(int i = k - 1; i >= 0; --i) {
        	result[i] = heap.poll();
        }
        
		return result;
    }
	
	public static void main(String []args) {
		TopKFrequentElements t = new TopKFrequentElements();
		t.topKFrequent(new int[] {1,1,1,2,2,3,3,4,5,6,6,6}, 3);
		//t.topKFrequent(new int[] {1,1,1,1,1,1}, 3);
	}
	
	public int[] topKFrequentLeetCode(int[] nums, int k) {

		Map<Integer,Integer> table = new HashMap<Integer,Integer>();

		//Count the Frequency
		for(int i : nums){
			int frequency = table.getOrDefault(i,0) + 1;
			table.put(i,frequency);
		}

		//Initialize Priority Queue using comparison lower priority item are moved out first using lambda
		Queue<Integer> heap = new PriorityQueue<>( (n1,n2) -> table.get(n1) - table.get(n2) );


		//Loop thru table map 
		for(int n : table.keySet()){
			heap.add(n);

			if(heap.size() > k){ //Lower Frequency Items will be polled and removed
				heap.poll();
			}
		}

		int result[] = new int[k];
		//Poll the items from Queue and assign it to Array
		for(int j=k-1;j>=0;j--){
			result[j] = heap.poll();
		}

		return result;

	}
}
