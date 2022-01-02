import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DegreeOfArray {
	
	class IndexAndFrequency{
		int startIndex;
		int endIndex;
		int frequency;
		
		public IndexAndFrequency(int startIndex, int endIndex, int frequency) {
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.frequency = frequency;
		}
	}
	
	public int findShortestSubArray(int[] nums) {
		Map<Integer, IndexAndFrequency> map = new HashMap<Integer, IndexAndFrequency>();
		int maxFrequency = 0;
		int result = Integer.MAX_VALUE;
		Set<Integer> maxFrequencyNumbers = new HashSet<Integer>();
		for(int i=0;i<nums.length;i++) {
			IndexAndFrequency indexAndFreq =  null;
			if(map.containsKey(nums[i])) {
				indexAndFreq = map.get(nums[i]);
				indexAndFreq.endIndex = i;
				indexAndFreq.frequency = indexAndFreq.frequency + 1;
			}
			else 
			{
				indexAndFreq = new IndexAndFrequency(i, i, 1);
				map.put(nums[i], indexAndFreq);
			}
			
			maxFrequency = Math.max(maxFrequency, indexAndFreq.frequency);
		}
		
		for(int i=0;i<nums.length;i++) {
			if(map.get(nums[i]).frequency == maxFrequency) {
				maxFrequencyNumbers.add(nums[i]);
			}
		}
		for(Integer i : maxFrequencyNumbers) {
			IndexAndFrequency indexAndFreq = map.get(i);
			result = Math.min((indexAndFreq.endIndex - indexAndFreq.startIndex) + 1, result);
		}
		
		return result;
	}
	
	public static void main(String []args) {
		DegreeOfArray d = new DegreeOfArray();
		System.out.println(d.findShortestSubArray(new int[] {1,2,2,3,1}));
		System.out.println(d.findShortestSubArray(new int[] {1,2,2,3,1,4,2}));
		System.out.println(d.findShortestSubArray(new int[] {2,1,1,2,1,3,3,3,1,3,1,3,2}));
	}

}
