
public class EditDistance {

	public int minDistance(String word1, String word2) {
		int minDistance = 0;
		
		if(word2!=null && word2!="" && (word1 == null || word1 == "")) {
			return word2.length();
		}
		
		if(word1!=null && word1!="" && (word2 == null || word2 == "")) {
			return word1.length();
		}
		
		if(word1 == null || word1 == "" || word2 == null || word2 == "") {
			return minDistance;
		}
		
		int numOfRows = word2.length() + 1;
		int numOfCols = word1.length() + 1;
		
		int dpTable [][] = new int [numOfRows][numOfCols];
		
		//Initialization
		int j = 0;
		for(int i=0;i<numOfRows;i++) {
			dpTable[i][j] = i;
		}
		
		int i = 0;
		for(j=0;j<numOfCols;j++) {
			dpTable[i][j] = j;
		}
		
		
		i = 1; //First Row
		j = 1; //First Col
		
		while(j < numOfCols) {
			i = 1;
			while(i < numOfRows) {
				if(word2.charAt(i-1) == word1.charAt(j-1)) {
					dpTable[i][j] = minOfThree(dpTable[i-1][j-1], dpTable[i-1][j] + 1, dpTable[i][j-1] + 1);
				}
				else 
				{
					dpTable[i][j] = minOfThree(dpTable[i-1][j-1] + 1, dpTable[i-1][j] + 1, dpTable[i][j-1] + 1);
				}
				i++;
			}
			j++;
		}
		return dpTable[numOfRows-1][numOfCols-1];
    }
	
	public static int minOfThree(int i, int j, int k) {
		int min = Integer.MAX_VALUE;
		min = Math.min(i, min);
		min = Math.min(j, min);
		min = Math.min(k, min);
		return min;
	}
	
	
	public static void main(String []args) {
		EditDistance e = new EditDistance();
		
		System.out.println(e.minDistance("horse", "ros"));
		System.out.println(e.minDistance("ros","horse"));
		
		System.out.println(e.minDistance("intention", "execution"));
		System.out.println(e.minDistance("execution","intention"));
		
		System.out.println(e.minDistance("", "execution"));
		System.out.println(e.minDistance("execution",""));
		
		System.out.println(e.minDistance("", ""));
		System.out.println(e.minDistance(null,null));
		
		System.out.println(e.minDistance("", null));
		System.out.println(e.minDistance(null, ""));
		
		
		
		
		/*
		 * System.out.println(minOfThree(2, 1, 3)); System.out.println(minOfThree(1, 2,
		 * 3)); System.out.println( minOfThree(3, 2, 1));
		 */
		
	}
}
