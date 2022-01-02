import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMapUsingTreeMap {
	
	Map<String, TreeMap<Integer,String>> timeValueMap;
	
	public TimeMapUsingTreeMap() {
		this.timeValueMap = new HashMap<String, TreeMap<Integer,String>>();
	}

	public void set(String key, String value, int timestamp) {
		TreeMap<Integer,String> timeValueTreeMap = this.timeValueMap.get(key);
		if(timeValueTreeMap == null) {
			timeValueTreeMap = new TreeMap<Integer,String>();
		}
		timeValueTreeMap.put(timestamp, value);
		this.timeValueMap.put(key, timeValueTreeMap);
		
	}

	public String get(String key, int timestamp) {
		if(!this.timeValueMap.containsKey(key)) {
			return "";
		}
		TreeMap<Integer,String> timeValueTreeMap = this.timeValueMap.get(key);
		if(timeValueTreeMap.floorKey(timestamp) == null) {
			return "";
		}
		return timeValueTreeMap.get(timeValueTreeMap.floorKey(timestamp)); //Returns Greatest Key less than equal to given key
	}
	
	public static void main(String []args) {
		TimeMapUsingTreeMap t = new TimeMapUsingTreeMap();
		t.set("foo", "bar", 1);
		System.out.println(t.get("foo", 1));
	}

}
