import java.util.Stack;

public class DecodeString {

	public String decodeString(String s) {
		Stack<Integer> counts = new Stack<Integer>(); //Push count
		Stack<String> result = new Stack<String>();
		String res = "";
		int index = 0;
		
		while(index < s.length()) {
			if(Character.isDigit(s.charAt(index))) {
				int count = 0;
				while(Character.isDigit(s.charAt(index))) {
					count = 10 * count + (s.charAt(index) - '0'); //There could be multiple digits like 2555
					index += 1;
				}
				counts.push(count);
			}
			else if(s.charAt(index) == '[') {
				result.push(res); //Push Characters
				res = "";
				index += 1;
			}
			else if(s.charAt(index) == ']') { //Pop characters based on count
				StringBuilder temp = new StringBuilder(result.pop());
				int count = counts.pop();
				for(int i=0;i<count;i++) {
					temp.append(res);
				}
				res = temp.toString();
				index += 1;
			}
			else 
			{
				res += s.charAt(index); //Append Character to result
				index += 1; //Move forward index
			}
		}
		return res;
	}
	
	public static void main(String []args) {
		
	}

}
