import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	Map<Integer, Integer> lru;
	Deque<Integer> lastAccessed;
	int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		lru = new HashMap<>(capacity);
		lastAccessed = new ArrayDeque<>();
	}

	public int get(int key) {
		if(lru.containsKey(key)){
			lastAccessed.removeFirstOccurrence(key);
			lastAccessed.offerLast(key);
			return lru.get(key);
		}
		else return -1;
	}

	public void put(int key, int value) {
		//if key in cache just update value
		if (lru.containsKey(key))
		{
			lru.replace(key, value);
			//we want to make sure once we update value in map
			//to reset it in deque as well
			lastAccessed.removeFirstOccurrence(key);
			lastAccessed.offerLast(key);
			return;
		}

		//key not in cache -  check size if >= capacity
		//move to the head
		if(capacity <= lru.size()){
			int lruKey = lastAccessed.removeFirst();
			lru.remove(lruKey);
		}
		lru.put(key, value);
		lastAccessed.offerLast(key);
	}

	public static void main(String []args) {
		LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 1); // cache is {1=1}
		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		System.out.println(lRUCache.get(1));    // return 1
		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		System.out.println(lRUCache.get(2));    // returns -1 (not found)
		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		System.out.println(lRUCache.get(1));    // return -1 (not found)
		System.out.println(lRUCache.get(3));    // return 3
		System.out.println(lRUCache.get(4));    // return 4
		
	}
}
