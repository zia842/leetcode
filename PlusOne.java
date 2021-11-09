import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PlusOne {
	
	public int[] plusOneB(int[] digits) {
		int result[] = null;
		BigInteger digit = new BigInteger("0");
		
		if(digits!=null && digits.length > 0) {
			int numberOfPlaces = digits.length - 1;
			for(int d : digits) {
				BigInteger k = BigDecimal.valueOf(Math.pow(10, numberOfPlaces--)).toBigInteger();
				digit = digit.add(k.multiply(BigInteger.valueOf(d)));
			}
			digit = digit.add(BigInteger.valueOf(1));
			
			Stack<Integer> stack = new Stack<Integer>();
			while(!digit.equals(BigInteger.ZERO)) {
				stack.push(digit.mod(BigInteger.valueOf(10)).intValue());
				digit = digit.divide(BigInteger.valueOf(10));
			}
			
			result = new int[stack.size()];
			int count = 0;
			while(!stack.isEmpty()) {
				result[count++] = stack.pop();
			}
		}
		
		
		return result;
	}

	public int[] plusOne(int[] digits) {
		int result[] = null;
		
		//Long inital = 0L;
		Long digit = 0L;
		for(int i=0;i<digits.length;i++) {
			digit = (10 * digit) + digits[i];
		}
		
		digit = digit + 1;
		List<Long> resultList = new ArrayList<Long>();
		
		while(digit > 0) {
			resultList.add(digit%10);
			digit = digit / 10;
		}
		
		//Reverse
		
		return result;
		
	}
	
	public static void main(String []args) {
		PlusOne p = new PlusOne();
		p.plusOneB(new int [] {4,3,2,1});
		
		List testList = Arrays.asList(8,9,10,12,2,3,5);
		Collections.sort(testList);
		//testList.forEach(s->System.out::print(s+","));
		testList.forEach(s -> System.out.print(s + ","));
		
		List<String> strings = Arrays.asList("ab", "", "cb", "", "c");
		System.out.println("\n");
		
		strings.stream().filter(s -> s.length() > 1).forEach(s -> System.out.print(s + ","));
		
	}
}
