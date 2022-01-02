
public class StrStr {
	
	 public int strStr(String haystack, String needle) {
		 if(haystack!=null && haystack!="" && needle!=null && needle!="") {
			 
			/*
			 * while(j < needle.length() && i < haystack.length()) {
			 * 
			 * if(needle.charAt(j) == haystack.charAt(i)) { j++; i++; while(j <
			 * needle.length() && i < haystack.length()) { if(needle.charAt(j) ==
			 * haystack.charAt(i)) { i++; j++; } else { return -1; } }
			 * 
			 * } else { i++; } }
			 */
			 
			 if(haystack.contains(needle)) {
				 return haystack.indexOf(needle);
			 }
			 
		 }
		 
	     return -1;   
	 }
	 
	 
	 public static void main(String []args) {
		 StrStr s = new StrStr();
		 System.out.println(s.strStr("hello", "ll")); //2
		 System.out.println(s.strStr("thepigflewwow", "flew")); //6
		 System.out.println(s.strStr("twocanplay", "two")); //0
		 System.out.println(s.strStr("wherearemyshorts", "pork")); //-1
	 }

}
