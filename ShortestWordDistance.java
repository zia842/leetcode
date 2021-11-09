import java.util.HashMap;
import java.util.Map;

/**
 * 243. Shortest Word Distance
 * 
 * Given an array of strings wordsDict and two different strings that already exist in the array word1 and word2, 
 * return the shortest distance between these two words in the list.

Example 1:

Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
Output: 3

Example 2:

Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
Output: 1

Constraints:

    1 <= wordsDict.length <= 3 * 104
    1 <= wordsDict[i].length <= 10
    wordsDict[i] consists of lowercase English letters.
    word1 and word2 are in wordsDict.
    word1 != word2


 * @author zia84
 *
 */

public class ShortestWordDistance {

	public int shortestDistance(String[] wordsDict, String word1, String word2) {
		int distance = Integer.MAX_VALUE;

		if(wordsDict!=null && wordsDict.length > 0) {

			Map<String,Integer> dictionaryMap = new HashMap<String,Integer>();
			for(int i=0;i<wordsDict.length;i++) {
				dictionaryMap.put(wordsDict[i], Integer.valueOf(i));
				if(dictionaryMap.containsKey(word1) && dictionaryMap.containsKey(word2)) {
					distance = Math.min(distance, Math.abs(dictionaryMap.get(word1) - dictionaryMap.get(word2)));
				}

			}
		}


		return distance;
	}

	public static void main(String []args) {
		ShortestWordDistance s = new ShortestWordDistance();
		System.out.println(s.shortestDistance(new String[] {"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice"));
		System.out.println(s.shortestDistance(new String[] {"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding"));
		System.out.println(s.shortestDistance(new String[] {"a","a","b","b"}, "a", "b"));



	}

}
