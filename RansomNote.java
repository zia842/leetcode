import java.util.HashMap;
import java.util.Map;

public class RansomNote {

	public boolean canConstruct(String ransomNote, String magazine) {
		
		if(ransomNote.length() > magazine.length()) {
			return false;
		}
		
		Map<Character, Integer> mapOne = new HashMap<Character, Integer>();
		for(Character c : magazine.toCharArray()) {
			mapOne.put(c, mapOne.getOrDefault(c, 0)+1);
		}
		
		for(Character c : ransomNote.toCharArray()) {
			if(!mapOne.containsKey(c) || mapOne.get(c) <= 0) {
				return false;
			}
			
			mapOne.put(c, mapOne.get(c)-1);
		}

		return true;
	}
	
	public static void main(String[] args) {
		RansomNote r = new RansomNote();
		System.out.println(r.canConstruct("a", "b"));
		System.out.println(r.canConstruct("aa", "ab"));
		System.out.println(r.canConstruct("aa", "aab"));
		System.out.println(r.canConstruct("aaaa", "aabc"));
	}

}
