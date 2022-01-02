import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public int majorityElement(int[] nums) {
		int majorityElement = 0;
		if(nums!=null && nums.length > 0) {
			
			Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
			for(int i=0;i<nums.length;i++) {
				int count = frequencyMap.getOrDefault(nums[i], 0);
				frequencyMap.put(nums[i],count+1);
			}
			
			int maxCount = Integer.MIN_VALUE;
			
			for(int i=0;i<nums.length;i++) {
				if(frequencyMap.get(nums[i]) > maxCount) {
					maxCount = frequencyMap.get(nums[i]);
					majorityElement = nums[i];
				}
				
			}
			
		}
		return majorityElement;
	}

}
