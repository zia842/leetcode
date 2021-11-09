import java.util.HashMap;
import java.util.Map;

public class RemoveAllAdjacentDuplicates {
	
	public Map<String, Boolean> charMap = new HashMap<String, Boolean>();

	public String removeDuplicates(String s, int k) {
		StringBuilder sb = new StringBuilder(s);
		
		int i = 0;
		while(i<sb.length()) {
			
			/*
			 * if(i+2 < sb.length() && sb.charAt(i) == sb.charAt(i+1) && sb.charAt(i+1) ==
			 * sb.charAt(i+2)) { sb.deleteCharAt(i); sb.deleteCharAt(i); sb.deleteCharAt(i);
			 * i = 0; continue; }
			 */
			
			if(i+k <= sb.length()) {
				String t = sb.substring(i,i+k); 
				if(allCharEqual(t)) {
					/*
					 * int j = 0; while(j < k) { sb.deleteCharAt(i); j++; }
					 * 
					 * if(j == k) { i = 0; continue; }
					 */
					sb.delete(i, i+k);
					i = 0;
					continue;
				}
				
			}
			i++;
		}
		
		return sb.toString();
		
	}
	
	public String removeDuplicatesMemo(String s, int k) {
	    StringBuilder sb = new StringBuilder(s);
	    int count[] = new int[sb.length()];
	    for (int i = 0; i < sb.length(); ++i) {
	        if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
	            count[i] = 1;
	        } else {
	            count[i] = count[i - 1] + 1;
	            if (count[i] == k) {
	                sb.delete(i - k + 1, i + 1);
	                i = i - k;
	            }
	        }
	    }
	    return sb.toString();
	}
	
	public boolean allCharEqual(String s) {
		if(charMap.containsKey(s)) {
			return Boolean.valueOf(charMap.get(s));
		}
		int i = 0;
		while(i < s.length()) {
			if(s.charAt(0) != s.charAt(i)) {
				charMap.put(s, Boolean.FALSE);
				return false;
			}
			i++;
		}
		charMap.put(s, Boolean.TRUE);
		return true;
	}
	
	public static void main(String []args) {
		RemoveAllAdjacentDuplicates r = new RemoveAllAdjacentDuplicates();
		System.out.println(r.removeDuplicatesMemo("deeedbbcccbdaa", 3));
		//System.out.println(r.removeDuplicates("abcd", 2));
		//System.out.println(r.removeDuplicates("pbbcggttciiippooaais", 2));
		//System.out.println(r.removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4));

	}

}
