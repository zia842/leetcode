import java.util.HashMap;
import java.util.Map;

public class KDiffPairs {

	public int findPairs(int[] nums, int k) {
		int result = 0;
		if(nums!=null && nums.length > 0) {
			
			Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
			
			//Count the frequency
			for(int i=0;i<nums.length;i++) {
				Integer o = freqMap.getOrDefault(nums[i], Integer.valueOf(0)) + 1;
				freqMap.put(nums[i], o);
			}
			
			//Loop thru map
			for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
				Integer key = entry.getKey();
				Integer val = entry.getValue();
				
				if(k > 0 && freqMap.containsKey(key+k)) {
					result++;
				}
				else if(k == 0 && val > 1) {
					result++;
				}
				 
			}
		}
		return result;
	}
	
	public static void main(String []args) {
		KDiffPairs k = new KDiffPairs();
		System.out.println(k.findPairs(new int [] {3,1,4,1,5}, 2));
		System.out.println(k.findPairs(new int [] {1,2,3,4,5}, 1));
		System.out.println(k.findPairs(new int [] {1,3,1,5,4}, 0));
		System.out.println(k.findPairs(new int [] {1,2,4,4,3,3,0,9,2,3}, 3));
		System.out.println(k.findPairs(new int [] {-1,-2,-3}, 1));
		
	}

}
