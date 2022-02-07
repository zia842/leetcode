import java.util.HashMap;
import java.util.Map;

public class RansomNote {
	
	public boolean canConstructLetter(String text, String note) {
		
		if((text ==null || text.isEmpty()) && (note!=null && !note.isEmpty())){
            return false;
        }
        
        if((note ==null || note.isEmpty()) && (text!=null && !text.isEmpty())){
            return false;
        }
        
        if(note.length() > text.length()) {
            return false;
        }
    
       Map<Character, Integer> mapOne = new HashMap<Character, Integer>();
        for(Character c : text.toCharArray()) {
            mapOne.put(c, mapOne.getOrDefault(c, 0)+1);
        }
        
        for(Character c : note.toCharArray()) {
            if(!mapOne.containsKey(c) || mapOne.get(c) <= 0) {
                return false;
            }
            
            mapOne.put(c, mapOne.get(c)-1);
        }
        
        return true;
		
	}

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
		//System.out.println(r.canConstruct("a", "b"));
		//System.out.println(r.canConstruct("aa", "ab"));
		//System.out.println(r.canConstruct("aa", "aab"));
		//System.out.println(r.canConstruct("aaaa", "aabc"));
		System.out.println(r.canConstructLetter("The quick brown fox jumps over the lazy dog", "visa"));
		System.out.println(r.canConstructLetter("abcd", "a"));
		System.out.println(r.canConstructLetter("ddd", "a"));
		System.out.println(r.canConstructLetter("d", "a"));
		System.out.println(r.canConstructLetter("da", "a"));
		System.out.println(r.canConstructLetter("da", "a"));
	}

}
