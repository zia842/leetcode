
public class StrStr {
	
	 public int strStr(String haystack, String needle) {
		 int i = 0;
		 int j = 0;
	     
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
				 haystack.indexOf(needle);
			 }
			 
		 }
		 
	     return i;   
	 }
	 
	 
	 public static void main(String []args) {
		 StrStr s = new StrStr();
		 System.out.println(s.strStr("hello", "ll"));
	 }

}
