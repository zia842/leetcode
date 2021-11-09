import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subsets 
{
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		generateSubsets(0,nums,new ArrayList<Integer>(),subsets);
		return subsets;
    }

	private void generateSubsets(int index, int[] nums, ArrayList<Integer> current, List<List<Integer>> subsets) {
		subsets.add(new ArrayList<>(current));
		for(int i=index;i<nums.length;i++) {
			current.add(nums[i]);
			generateSubsets(i+1, nums, current, subsets);
			current.remove(current.size()-1);
		}
	}
	
	
	public static void main(String []args) {
		Subsets s = new Subsets();
		s.subsets(new int[] {1,2,3});
		
		Map<String,String> testMap = new HashMap<String,String>();
		testMap.put("abc", "xys");testMap.put("def", "test");
		testMap.put("bca", "rza");
		System.out.println(testMap);
		System.out.println("************");
		Map<String,String> testMap2 = new HashMap<String,String>();
		System.out.println("************"+testMap2);
		testMap2.forEach((key,value) -> {
			System.out.println(key);
		});
	}
}
