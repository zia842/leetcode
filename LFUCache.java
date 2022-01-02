import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
	
	int capacity;
	int min;
	Map<Integer, Integer> valsMap;
	Map<Integer, Integer> countsMap;
	Map<Integer, LinkedHashSet<Integer>> lists;
	
	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.valsMap = new HashMap<Integer, Integer>();
		this.countsMap = new HashMap<Integer, Integer>();
		lists = new HashMap<Integer, LinkedHashSet<Integer>>();
		lists.put(1, new LinkedHashSet<Integer>());
	}
	
	public int get(int key) {
		if (!this.valsMap.containsKey(key))
			return -1;
		
		// Get the count from counts map
		int count = this.countsMap.get(key);
		// increase the counter
		this.countsMap.put(key, count + 1);
		// remove the element from the counter to linkedhashset
		this.lists.get(count).remove(key);

		// when current min does not have any data, next one would be the min
		if (count == min && this.lists.get(count).size() == 0)
			min++;
		
		if (!this.lists.containsKey(count + 1))
			this.lists.put(count + 1, new LinkedHashSet<>());
		
		this.lists.get(count + 1).add(key);
		
		return this.valsMap.get(key);
	}
	
	
	public void put(int key, int value) {
		if(this.capacity <= 0) //If there is no capacity
			return;
		
		if(this.valsMap.containsKey(key)) {
			this.valsMap.put(key, value);
			get(key);
			return;
		}
		if(this.valsMap.size() >= this.capacity) {
			int evict = this.lists.get(min).iterator().next();
			this.lists.get(min).remove(evict);
			this.valsMap.remove(evict);
			this.countsMap.remove(evict);
		}
		
		//If key is new, insert the value and current min should be 1 
		this.valsMap.put(key, value);
		this.countsMap.put(key, 1);
		this.min = 1;
		this.lists.get(1).add(key);
	}
	
	public static void main(String []args) {
		
		LFUCache lfu = new LFUCache(2);
		lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
		lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
		
		lfu.get(1);      // return 1
		// cache=[1,2], cnt(2)=1, cnt(1)=2
		
		lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
		// cache=[3,1], cnt(3)=1, cnt(1)=2
		
		lfu.get(2);      // return -1 (not found)
		lfu.get(3);      // return 3
		
		// cache=[3,1], cnt(3)=2, cnt(1)=2
		lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
		
		// cache=[4,3], cnt(4)=1, cnt(3)=2
		lfu.get(1);      // return -1 (not found)
		lfu.get(3);      // return 3
		
		// cache=[3,4], cnt(4)=1, cnt(3)=3
		lfu.get(4);      // return 4
		// cache=[3,4], cnt(4)=2, cnt(3)=3
	}
	

}
