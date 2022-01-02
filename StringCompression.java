
public class StringCompression {

	public int compress(char[] chars) {
		int index = 0, count = 0;
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			count++;
			// if the next character is different or we are at the end of string
			if (i == chars.length - 1 || chars[i] != chars[i+1]) {
				chars[index++] = chars[i];
				if (count > 1) {
					String s = String.valueOf(count);
					for (int j = 0; j < s.length(); j++)
						chars[index++] = s.charAt(j);
				}
				count = 0;
			}
		}
		return index;
	}
	
	public static void main(String []args) {
		StringCompression s = new StringCompression();
		System.out.println(s.compress(new char[] {'a','a','b','b','c','c','c'}));
		System.out.println(s.compress(new char[] {'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
	}

}
