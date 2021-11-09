import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ShiftDuplicates {
	
	public int removeDuplicates(int []nums) {
		int count = 0;
		
		Set<Integer> set = new HashSet<Integer>();
		if(nums!=null && nums.length > 0) {
			
			for(int n : nums) {
				set.add(n);
			}
			
			List<Integer> resultList = new ArrayList<Integer>();
			Iterator<Integer> itr = set.iterator();
			while(itr.hasNext()) {
				//nums[count++] = (int)itr.next();
				resultList.add(itr.next());
			}
			
			Collections.sort(resultList);
			
			
			
			//System.out.println("Count " + count);
			for(int i : resultList) {
				nums[count++] = i;
			}
			
		}
		return count;
	}
	
	
	public static void main(String []args) {
		ShiftDuplicates s = new ShiftDuplicates();
		s.removeDuplicates(new int [] {1,1,2,2,4,7,7,9});
	}

}
