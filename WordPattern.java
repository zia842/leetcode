import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	
	public boolean wordPattern(String pattern, String s) {
		
		boolean result = true;
		
		Map<String,String> patternMap = new HashMap<String,String>();
		Map<String,String> charMap = new HashMap<String,String>();
		
		String str[] = s.split(" ");
		
		if(str.length != pattern.length()) {
			return false;
		}
		for(int i=0;i<pattern.length();i++) {
			
			if(!patternMap.containsKey(String.valueOf(pattern.charAt(i)))) {
				patternMap.put(String.valueOf(pattern.charAt(i)), str[i]);
			}
			
			if(!charMap.containsKey(str[i])) {
				charMap.put(str[i], String.valueOf(pattern.charAt(i)));
			}
			
			
			if(patternMap.get(String.valueOf(pattern.charAt(i)))!=null && 
					!patternMap.get(String.valueOf(pattern.charAt(i))).equals(str[i])){
				return false;
			}
			
			if(charMap.get(str[i])!=null 
					&& !String.valueOf(pattern.charAt(i)).equals(charMap.get(str[i]))) {
				return false;
			}
			
			
		}
		
		return result;
		
	}
	
	public static void main(String []args) {
		WordPattern w = new WordPattern();
		System.out.println(w.wordPattern("abba", "dog cat cat dog"));
		System.out.println(w.wordPattern("abba", "dog cat cat fish"));
		System.out.println(w.wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(w.wordPattern("abba", "dog dog dog dog"));
		System.out.println(w.wordPattern("aaa", "aa aa aa aa"));
		BigInteger bd = new BigInteger("2432432432432432432432432432432432432432432432432432432432439");
		BigInteger bd2 = new BigInteger("5642432432432432432432432432432432432432432432432432432439999");
		System.out.println(bd.add(bd2));
	}
}
