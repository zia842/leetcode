import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VerbalArithmeticPuzzleV2 {


	public boolean isSolvable(String[] words, String result) {

		Map<Character, Integer> charIntMap = new HashMap<Character, Integer>();
		String unique = "";
		for(String word : words) {
			for(Character c : word.toCharArray()) {
				if(!charIntMap.containsKey(c)) {
					charIntMap.put(c, -1);
					unique += c;
				}
			}
		}
		
		for(Character c : result.toCharArray()) {
			if(!charIntMap.containsKey(c)) {
				charIntMap.put(c, -1);
				unique += c;
			}
		}
		
		boolean usedNumbers[] = new boolean[10];
		Set<Integer> resultSet = new HashSet<Integer>();
		backTrackingSolution(unique, 0, charIntMap, usedNumbers, words, result, resultSet);
		return resultSet.size() > 0;
	}
	
	public int getNumber(String s, Map<Character, Integer> charIntMap) {
		String num = "";
		for(int i=0;i<s.length();i++) {
			num += charIntMap.get(s.charAt(i));
		}
		return Integer.parseInt(num);
	}
	
	public void backTrackingSolution(String unique, int idx, 
										Map<Character, Integer> charIntMap,
										boolean []usedNumbers,
										String []words,
										String result,
										Set<Integer> resultSet) {
		
		if(idx == unique.length()) {
			int actualSum = 0;
			int expectedSum = getNumber(result, charIntMap);
			for(String word : words) {
				actualSum += getNumber(word, charIntMap);
			}
			if(expectedSum == actualSum) {
				//System.out.println("Actual Sum " + actualSum + " Expected Sum " + expectedSum);
				resultSet.add(1);
			}
			return;
		}
		
		char ch = unique.charAt(idx);
		for(int num=0;num<=9;num++) {
			if(!usedNumbers[num]) {
				charIntMap.put(ch, num);
				usedNumbers[num] = true;
				backTrackingSolution(unique, idx+1, charIntMap, usedNumbers, words, result,resultSet);
				charIntMap.put(ch, -1);
				usedNumbers[num] = false;
				if(resultSet.size() > 0) return;
			}
		}
		//return false;
	}
	
	public static void main(String []args) {
		VerbalArithmeticPuzzleV2 v2 = new VerbalArithmeticPuzzleV2();
		System.out.println(v2.isSolvable(new String[] {"SEND","MORE"}, "MONEY"));
		System.out.println(v2.isSolvable(new String[] {"SIX","SEVEN","SEVEN"}, "TWENTY"));
		System.out.println(v2.isSolvable(new String[] {"THIS","IS","TOO"}, "FUNNY"));
		System.out.println(v2.isSolvable(new String[] {"LEET","CODE"}, "POINT"));
	}

}
