
/**
 * abcd
 * 0123
 * @author zia84
 *
 */
public class ReverseOnlyAlphabets {
	
	public String reverseOnlyAlphabets(String s) {
		if(s!=null && s.length() > 0) {
			
			int i = 0;
			int j = s.length()-1;
			char [] result = s.toCharArray();
			while(i<j) {
				
				if(!Character.isLetter(result[i])) {
					i++;
					continue;
				}
				if(!Character.isLetter(result[j])) {
					j--;
					continue;
				}
				char temp = result[i];
				result[i] = result[j];
				result[j] = temp;
				i++;
				j--;
			}
			
			return String.valueOf(result);
			
		}
		return s;
	}
	
	public static void main(String []args) {
		ReverseOnlyAlphabets r = new ReverseOnlyAlphabets();
		//System.out.println(r.reverseOnlyAlphabets("B!FDCEA2"));
		System.out.println(r.reverseOnlyAlphabets("sea!$hells3"));
		
	}

}
