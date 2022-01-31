import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
	
	Map<Integer, Integer> dict;
	
	List<Integer> list;
	
	Random random;
	
	public RandomizedSet() {
		this.dict = new HashMap<Integer, Integer>();
		this.list = new ArrayList<Integer>();
		this.random = new Random();
	}
	
	
	public boolean insert(int val) {
		if(this.dict.containsKey(val)) {
			return false;
		}
		
		this.dict.put(val, this.list.size());
		this.list.add(this.list.size(), val);
		return true;
	}
	
	public boolean remove(int val) {
		if(!this.dict.containsKey(val)) {
			return false;
		}
		
		//Move the element to last index to remove
		int lastElement = this.list.get(this.list.size()-1);
		int index = this.dict.get(val);
		this.list.set(index, lastElement);
		this.dict.put(lastElement, index);
		
		//Delete element
		this.list.remove(this.list.size()-1);
		this.dict.remove(val);
		return true;
	}
	
	public int getRandom() {
		return this.list.get(this.random.nextInt(this.list.size()));
	}
	
	public static void main(String []args) {
		RandomizedSet randomizedSet = new RandomizedSet();
		randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
		randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
		randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
		randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
		randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
		randomizedSet.insert(2); // 2 was already in the set, so return false.
		randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
	}

}
