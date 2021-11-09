import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public List<String> summaryRanges(int[] nums) {
		
		List<String> resultList = new ArrayList<String>();
		List<String> actualResult = new ArrayList<String>();
		
		if(nums!=null && nums.length > 0) {
			
			resultList.add(nums[0]+"->"+nums[0]);
		
			for(int i=1;i<nums.length;i++) {
				int previousElement = resultList.size() - 1;
				String s = resultList.get(previousElement);
				int t = Integer.parseInt(s.split("->")[1]); //Get the previous element
				if(nums[i] - t == 1) { //If Difference is 1
					String temp = s.split("->")[0] + "->" + (t+1);
					resultList.remove(previousElement);
					resultList.add(previousElement, temp);
				}
				else 
				{
					resultList.add(nums[i]+"->"+nums[i]);
				}
			}
			
			
			for(String s : resultList) {
				
				if(s.split("->")[0].equals(s.split("->")[1])) {
					actualResult.add(s.split("->")[0]);
				}
				else {
					actualResult.add(s);
				}
			}
		}
		return actualResult;
		
	}
	
	public static void main(String []args) {
		SummaryRanges s = new SummaryRanges();
		System.out.println(s.summaryRanges(new int[] {0,1,2,4,5,7}));
		System.out.println(s.summaryRanges(new int[] {0,2,3,4,6,8,9}));
		System.out.println(s.summaryRanges(new int[] {}));
		System.out.println(s.summaryRanges(new int[] {-1}));
		System.out.println(s.summaryRanges(new int[] {0}));
		System.out.println(s.summaryRanges(new int[] {-3,-2,-1}));
		System.out.println(s.summaryRanges(new int[] {-3,-2,-1,2}));
	}
}
