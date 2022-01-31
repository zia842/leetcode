import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

	public int subarraySum(int[] nums, int k) {
		int count = 0;
		for(int start=0;start<nums.length;start++) {
			for(int end=start+1;end<=nums.length;end++) {
				int sum = 0;
				for(int i=start;i<end;i++) 
					sum += nums[i];
				if(sum == k) 
					count++;
			}
		}
		return count;
	}
	
	public int subarraySumMap(int[] nums, int k) {
		int count = 0;
		int sum = 0;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		map.put(0, 1);
		for(int i=0;i<nums.length;i++) {
			sum += nums[i];
			if(map.containsKey(sum-k))
				count+= map.get(sum-k);
			map.put(sum, map.getOrDefault(sum, 0)+1);
		}
		
		return count;
	}
	
	public static void main(String []args) {
		String arr[] = new String[] {"aaac","aaab","aaaa"};
		Arrays.sort(arr);
		for(String s : arr) {
			System.out.println(s);
		}
		
	}

}
