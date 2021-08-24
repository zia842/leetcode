import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

	private static List<String> combinations = new ArrayList<>();
    private static Map<Character, String> letters = new HashMap<>();
    private String phoneDigits;
    
    static 
    {
    	letters.put('2', "abc");
    	letters.put('3', "def");
    	letters.put('4', "ghi");
    	letters.put('5', "jkl");
    	letters.put('6', "mno");
    	letters.put('6', "mno");
    	letters.put('7', "pqrs");
    	letters.put('8', "tuv");
    	letters.put('9', "wxyz");
    }
    
    public List<String> letterCombinations(String digits) {
    	combinations.clear();
    	if(digits!=null && digits!="" && digits.length() > 0) {
    		letterCombinations(digits, 0, new StringBuilder());
    	}
    	return combinations;
        
    }
    
    public static void letterCombinations(String digits, int k, StringBuilder result) {
    	
    	if(result.length() == digits.length()) {
    		combinations.add(result.toString());
    		return;
    	}
    	
    	String t = letters.get(digits.charAt(k));
    	
    	for(int i=0;i<t.length();i++) {
    		
    		
    		result.append(t.charAt(i));
    		
    		letterCombinations(digits, k+1, result);
    		
    		
    		result.deleteCharAt(result.length()-1);
    	}
    }
    
    
    
    public static void main(String []args) {
    	LetterCombinations l = new LetterCombinations();
    	System.out.println(l.letterCombinations("23"));
    	combinations.clear();
    	System.out.println(l.letterCombinations("2"));
    	combinations.clear();
    	System.out.println(l.letterCombinations(""));
    	combinations.clear();
    	System.out.println(l.letterCombinations("234"));
    	combinations.clear();
    	System.out.println(l.letterCombinations("2345"));
    	System.out.println(combinations.size());
    }
    
    
    public void permutationsOfString(int index, StringBuilder path) {
    	
    }
}
