import java.util.Stack;

public class ShuffledRepresentation {

	public int shuffledRepresentation(int a) {
		/**
		 * https://stackoverflow.com/questions/5444611/math-abs-returns-wrong-value-for-integer-min-value
		 * Integer.MIN_VALUE is -2147483648, but the highest value a 32 bit integer can contain is +2147483647. 
		 * Attempting to represent +2147483648 in a 32 bit int will effectively "roll over" to -2147483648. 
		 * This is because, when using signed integers, 
		 * the two's complement binary representations of +2147483648 and -2147483648 are identical. 
		 * This is not a problem, however, as +2147483648 is considered out of range.
		 * 
		 */
		String first = String.valueOf(Math.abs(a)); //TODO: Math.abs(Integer.MIN_VALUE) does not take out -ve sign
		first = first.contains("-") ? first.replace("-", "").trim() : first;
		int i = 0;
		int j = first.length() - 1;
		StringBuilder sb = new StringBuilder();
		int result = 0;

		while(i <= j) {

			sb.append(first.charAt(i));

			if (result > Integer.MAX_VALUE/10 || result < Integer.MIN_VALUE/10) return a; //TODO : Based on requirement either return input back or 0 if overflow occurs

			result = (i==0) ? Integer.valueOf(String.valueOf(first.charAt(i))) : result * 10 + Integer.valueOf(String.valueOf(first.charAt(i)));

			if(i!=j) {
				sb.append(first.charAt(j));

				if (result > Integer.MAX_VALUE/10 || result < Integer.MIN_VALUE/10) return a;

				result = result * 10 + Integer.valueOf(String.valueOf(first.charAt(j)));
			}


			//Move the pointers
			i++;
			j--; 
		}
		return a < 0 ? (-1) * Integer.valueOf(sb.toString()) : Integer.valueOf(sb.toString());

	}

	public int reverse(int x) {
		int reverseNumber  = 0;
		Stack<Integer> stackOne = new Stack<Integer>();
		Stack<Integer> stackTwo = new Stack<Integer>();
		while(x != 0) {  //342
			int pop = x % 10;  //2  //4 //3
			x = x / 10; //34  //3 //0
			stackOne.push(pop);
			stackTwo.push(x);
			reverseNumber = reverseNumber * 10 + pop; //2 //20+4=24  //240 + 3 = 243
		}
		return reverseNumber;
	}

	public static void main(String []args) {
		ShuffledRepresentation s = new ShuffledRepresentation();
		System.out.println(s.shuffledRepresentation(123456));
		System.out.println(s.shuffledRepresentation(-123456));
		System.out.println(s.shuffledRepresentation(130));
		System.out.println(s.shuffledRepresentation(-130));
		System.out.println(s.shuffledRepresentation(10));
		System.out.println(s.shuffledRepresentation(-10));
		System.out.println(s.shuffledRepresentation(1));
		System.out.println(s.shuffledRepresentation(-1));
		System.out.println(s.shuffledRepresentation(0));
		System.out.println(s.shuffledRepresentation(Integer.MAX_VALUE/2));
		System.out.println(s.shuffledRepresentation((Integer.MAX_VALUE/2)*100));
		System.out.println(s.shuffledRepresentation(Integer.MAX_VALUE-10000));
		System.out.println(s.shuffledRepresentation(Integer.MAX_VALUE));
		System.out.println(s.shuffledRepresentation(Integer.MIN_VALUE));
	}
}
