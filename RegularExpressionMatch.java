
public class RegularExpressionMatch {

	public boolean isMatch(String s, String p) {
        
		boolean isMatch = false;
		
		if((s == null || s == "") && (p == null || p == "")) { //Empty String and Empty pattern is match
			return true;
		}
		
		if(s!=null && s!="" && s.length() > 0 && p!=null && p!="" && p.length() > 0) {
			
			int numOfRows = s.length() + 1;
			int numOfCols = p.length() + 1;
			
			boolean dpTable[][] = new boolean[numOfRows][numOfCols];
			
			dpTable[0][0] = true; //Empty String and Empty pattern is match
			
			int i = 0; 
			int j = 1; //First Col
			
			while(j < numOfCols) {
				if(p.charAt(j-1) == '*') {
					dpTable[i][j] = dpTable[i][j-2];
				}
				j++;
			}
			
			
			i = 1;
			while(i < numOfRows) {
				j = 1;
				while(j < numOfCols) {
					
					if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') { //Match
						dpTable[i][j] = dpTable[i-1][j-1];
					}
					else if(p.charAt(j-1) == '*') {
						
						if(dpTable[i][j-2]) {
							dpTable[i][j] = dpTable[i][j-2];
						}
						else if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') {
							dpTable[i][j] = dpTable[i-1][j];
						}
					}
					
					j++;
				}
				
				i++;
			}
			
			isMatch = dpTable[numOfRows-1][numOfCols-1];
		}
		
		return isMatch;
    }
	
	
	
	public static void main(String []args) {
		RegularExpressionMatch r = new RegularExpressionMatch();
		System.out.println(r.isMatch("aa", "a"));
		System.out.println(r.isMatch("aa", "a*"));
		System.out.println(r.isMatch("ab", ".*"));
		System.out.println(r.isMatch("aab", "c*a*b"));
		System.out.println(r.isMatch("mississippi", "mis*is*p*."));
		
		
		System.out.println(r.isMatch("xaabyc", "xa*b.c"));
	}
}
