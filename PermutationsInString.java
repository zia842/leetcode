
public class PermutationsInString {

	public boolean checkInclusion(String s1, String s2) {
		
		if (s1.length() > s2.length())
            return false;
		
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++; //Count frequency of characters
            s2map[s2.charAt(i) - 'a']++; //Slide for first time
        }
        
        for (int i = 0; i < s2.length() - s1.length(); i++) { //Sliding Window
            if (matches(s1map, s2map))
                return true;
            s2map[s2.charAt(i + s1.length()) - 'a']++; //Add one character
            s2map[s2.charAt(i) - 'a']--; //Subtract character
        }
        
        return matches(s1map, s2map);
	}
	
	public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
	
	public static void main(String []args) {
		PermutationsInString p = new PermutationsInString();
		System.out.println(p.checkInclusion("ab", "eidbaooo"));
		System.out.println(p.checkInclusion("ab", "eidboaoo"));
		
	}

}
