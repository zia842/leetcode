
public class ReverseStringUsingRecursion {

	public void reverseString(String s, int index) {
		if(s == null || s == "" || index >= s.length()) {
			return;
			
		}
		
		reverseString(s, index + 1);
		
		System.out.print(s.charAt(index));
	}
	
	public void reverseChars(char[] c, int start, int end) {
		
		if(start >= end) {
			return;
		}
		
		char t = c[start];
		c[start] = c[end];
		c[end] = t;
		reverseChars(c, start + 1, end - 1);
		
	}
	
	public static void main(String []args) {
		ReverseStringUsingRecursion r = new ReverseStringUsingRecursion();
		//System.out.println("abcde".charAt(5));
		r.reverseString("abcde", 0);
		System.out.println("\n");
		char c[] = new char[] {'a', 'b', 'c','d','e'};
		r.reverseChars(c, 0, 4);
		System.out.println(c);
	}
	
}
