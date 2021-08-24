
public class WildCardMatch {

	public boolean isMatch(String s, String p) {
		boolean isMatch = true;

		//Base Conditions
		if ((s == null && p == null) || (s == "" && p == "") || (s == p) || (s.equals(p))) {
			return isMatch;
		}

	
		if (p.length() > 0 && p.chars().allMatch(c -> c == '*')) {
            return true;
        }
    
        if (p.isEmpty() || s.isEmpty()) {
            return false;
        }
		 
		//End Base Conditions

		if (s != null && p != null && s.length() > 0 && p.length() > 0) {

			boolean dpTable[][] = new boolean[s.length() + 1][p.length() + 1];

			dpTable[0][0] = true; //Empty Pattern & Empty String is always a match

			dpTable[0][1] = p.charAt(0) == '*' ? true : false; //If Pattern has first char * its always true
			
			for(int i=1;i<dpTable.length;i++) {
				if(dpTable[0][1] && p.charAt(i-1) == p.charAt(i) && p.charAt(i) == '*') { //If Pattern is **ho & String is ho because * followed by * is true
					dpTable[0][i+1] = true;
				}
				else {
					break;
				}
			}

			for (int i = 1; i < dpTable.length; i++) {

				for (int j = 1; j < dpTable[0].length; j++) {

					if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
						dpTable[i][j] = dpTable[i - 1][j - 1]; // Copy Diagonal Value
					} 
					else if (p.charAt(j - 1) == '*') {
						dpTable[i][j] = dpTable[i - 1][j] || dpTable[i][j - 1];
					}

				}

			}
			return dpTable[s.length()][p.length()]; // Give me the last row, last col
		}
		return isMatch;
	}

	public static void main(String[] args) {
		WildCardMatch w = new WildCardMatch();
		
		
		
		
		  System.out.println("false " +w.isMatch("aa", "a"));
		  System.out.println("true " +w.isMatch("aa", "*"));
		  System.out.println("false " +w.isMatch("cb", "?a"));
		  System.out.println("true " +w.isMatch("adceb", "*a*b"));
		  System.out.println("false " +w.isMatch("acdcb", "a*c?b"));
		  System.out.println("true " +w.isMatch("xaylmz", "x?y*z"));
		  
		  
		  System.out.println("false " +w.isMatch("", "a")); 
		  System.out.println("true "+ w.isMatch("", "******")); 
		  System.out.println("false " + w.isMatch("", "*a*"));
		 
		  System.out.println("true " + w.isMatch("ho", "**ho"));

	}

}
