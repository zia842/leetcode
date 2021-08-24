import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
	
	public List<String> generateParenthesis(int n) {
        
		List<String> combinationList = new ArrayList<String>();
		generateParanthesis(n, 0, 0, combinationList, new StringBuilder());
		return combinationList;
    }
	
	public void generateParanthesis(int n, int open, int close, List<String> combinationList, StringBuilder result) {
		
		if(result.length() == 2*n) { //Number of Opening Brackets + Number of Closing Brackets
			combinationList.add(result.toString());
			return;
		}
			
		if(open < n) {
			result.append("(");//Open the Bracket as long as i <= n
			generateParanthesis(n, open+1, close, combinationList, result);
			result.deleteCharAt(result.length()-1);
		}
		if(close < open) { //Close the Bracket as long as open bracket exist
			result.append(")");
			generateParanthesis(n, open, close+1, combinationList, result);
			result.deleteCharAt(result.length()-1);
		}
	}
	
	public static void main(String []args) {
		GenerateParanthesis g = new GenerateParanthesis();
		System.out.println(g.generateParenthesis(3));
		System.out.println(g.generateParenthesis(1));
	}

}
