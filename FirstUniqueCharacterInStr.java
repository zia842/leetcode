/**
 * 387. First Unique Character in a String
 * 
 * Given a string s, find the first non-repeating character in it and return its index. 
 * If it does not exist, return -1.
 * 
Example 1:

Input: s = "leetcode"
Output: 0

Example 2:

Input: s = "loveleetcode"
Output: 2

Example 3:

Input: s = "aabb"
Output: -1

Constraints:

    1 <= s.length <= 105
    s consists of only lowercase English letters.

 * 
 */
import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInStr {

	public int firstUniqChar(String s) {
		int result = -1;
		if(s!=null && s.length() > 0) {
			Map<Character,int[]> map = new HashMap<Character,int[]>();

			for(int i=0;i<s.length();i++) {
				Character c = s.charAt(i);
				int []indexAndOccurence = map.get(c);
				if(indexAndOccurence == null) {
					indexAndOccurence = new int[2];
					indexAndOccurence[0] = i;
				}
				indexAndOccurence[1] = indexAndOccurence[1] + 1;
				map.put(c, indexAndOccurence);
			}

			for(Character c : s.toCharArray()) {
				int[] indexAndOccurence = map.get(c);
				if(indexAndOccurence[1] == 1) {
					return indexAndOccurence[0];
				}
			}

		}

		return result;

	}

	public static void main(String []args) {
		FirstUniqueCharacterInStr f = new FirstUniqueCharacterInStr();
		System.out.println(f.firstUniqChar("leetcode"));
		System.out.println(f.firstUniqChar("loveleetcode"));
		System.out.println(f.firstUniqChar("aabb"));

	}

}
