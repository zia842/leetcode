
public class Occurrence {

	public boolean solution(String S) {
		// write your code in Java SE 8
		
		if(S!=null && S!="" && S.length() > 0) {
			
			for(int i=0;i<S.length();i++) {
				if(i+1 < S.length() && S.charAt(i)!= S.charAt(i+1) && S.charAt(i)!='a' ) {
					return false;
				}
			}
			
			
		}
		
		return true;
	}
	
	public static void main(String []args) {
		Occurrence o = new Occurrence();
		System.out.println(o.solution("abba"));
		System.out.println(o.solution("ba"));
		System.out.println(o.solution("aaabbbaa"));
		System.out.println(o.solution("bbbbba"));
		System.out.println(o.solution("aba"));
		System.out.println(o.solution("ab"));
		System.out.println(o.solution("aaa"));
		System.out.println(o.solution("bbb"));
		System.out.println(o.solution("a"));
		System.out.println(o.solution("b"));
	}

}
