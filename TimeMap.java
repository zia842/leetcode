import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeValue
{
	int timestamp;
	String value;
	
	public TimeValue(int timestamp, String value) {
		super();
		this.timestamp = timestamp;
		this.value = value;
	}
	
}

public class TimeMap {
	
	Map<String, List<TimeValue>> timeValueMap;

	public TimeMap() {
		this.timeValueMap = new HashMap<String, List<TimeValue>>();
	}

	public void set(String key, String value, int timestamp) {
		if(!this.timeValueMap.containsKey(key)) {
			List<TimeValue> timeValueList = new ArrayList<TimeValue>();
			this.timeValueMap.put(key, timeValueList);
		}
		this.timeValueMap.get(key).add(new TimeValue(timestamp, value));
	}

	public String get(String key, int timestamp) {
		if(!this.timeValueMap.containsKey(key)) {
			return "";
		}
		List<TimeValue> timeValueList = this.timeValueMap.get(key);
		
		if(timeValueList == null || timeValueList.size() <= 0) {
			return "";
		}
		
		//Perform search
		int low = 0;
		int high = timeValueList.size()-1;
		if(timeValueList.get(low).timestamp > timestamp) { //If the list contains time stamp > requested one
			return "";
		}
		
		if(timeValueList.get(high).timestamp <= timestamp) {
			return timeValueList.get(high).value;
		}
		
		while(low < high) {
			int mid = (low + high) / 2;
			if(timeValueList.get(mid).timestamp <= timestamp) {
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		return timeValueList.get(low).value;
	}

}
