
public class WordLadder {
	
	public void generateAllCombinations(String s) {
		if(s!=null && s.length() > 0) {
			char charArr[] = s.toCharArray();
			for(int i=0;i<charArr.length;i++) {
				char temp = charArr[i];
				for(char c='a';c<='z';c++) {
					charArr[i] = c;
					if(!s.equals(String.valueOf(charArr))) {
						System.out.println(String.valueOf(charArr));
					}
				}
				charArr[i] = temp;
			}
			
		}
	}
	
	public static void main(String []args) {
		WordLadder w = new WordLadder();
		w.generateAllCombinations("hot");
	}

}
