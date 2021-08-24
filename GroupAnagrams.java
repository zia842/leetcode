import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		
		List<List<String>> group = new ArrayList<List<String>>();
		Map<String, List<String>> groupMap = new HashMap<String,List<String>>();
		
		for(String s : strs) {
			
			int charCountArr[] = new int[26];
			
			//Count the number of character occurrences
			for(char c : s.toCharArray()) {
				charCountArr[c-'a']++;
			}
			
			//Create a Key
			StringBuilder sb = new StringBuilder();
			for(int c : charCountArr) {
				sb.append("#");
				sb.append(c);
			}
			String key = sb.toString();
			
			//Add it to list
			List<String> groupList = groupMap.get(key);
			if(!groupMap.containsKey(key)) {
				groupList = new ArrayList<String>();
			}
			groupList.add(s);
			groupMap.put(key, groupList);
		}
		
		group = groupMap.values().stream().collect(Collectors.toCollection(ArrayList::new));
		
		return group;
    }

	
	public static void main(String []args) {
		GroupAnagrams g = new GroupAnagrams();
		System.out.println(g.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
		System.out.println(g.groupAnagrams(new String[] {""}));
		System.out.println(g.groupAnagrams(new String[] {"a"}));
		
		
	}
	
	
}
