import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class Logger {

	private Map<String,Integer> map; 

	/** Initialize your data structure here. */
	public Logger() {
		map = new HashMap<String,Integer>();
	}

	/**
	 * Returns true if the message should be printed in the given timestamp, 
	 * otherwise returns false.
	 */
	public boolean shouldPrintMessage(int timestamp, String message) {
		
		if(!map.containsKey(message)) {
			map.put(message, timestamp);
			return true;
		}
		
		Integer oldTimeStamp = map.get(message);
		if(timestamp-oldTimeStamp >= 10) {
			map.put(message, timestamp);
			return true;
		}
		else {
			return false;
		}

	}
	
	public static void main(String []args) {
		
	}

}
