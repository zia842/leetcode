import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	
	private class LargestNumberComparator implements Comparator<String>{
		@Override
		public int compare(String s1, String s2) {
			String order1 = s1 + s2;
			String order2 = s2 + s1;
			return order2.compareTo(order1); //Reverse Order
		}
	}

	public String largestNumber(int[] nums) {
		
		String result[] = new String[nums.length];
		
		for(int i=0;i<nums.length;i++) {
			result[i] = String.valueOf(nums[i]);
		}
		
		Arrays.sort(result, new LargestNumberComparator());
		
		if(result[0].equals("0")) {
			return "0";
		}
		
		String largestNumber = new String();
		for(String s : result) {
			largestNumber += s;
		}
		
		return largestNumber;
	}
	
	public static void main(String []args) {
		LargestNumber l = new LargestNumber();
		System.out.println(l.largestNumber(new int[] {10,2}));
		System.out.println(l.largestNumber(new int[] {3,30,34,5,9}));
	}
}
