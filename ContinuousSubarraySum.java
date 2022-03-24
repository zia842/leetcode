import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

	public boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer,Integer> hm=new HashMap<>();
		int sum=0;
		hm.put(sum,-1);
		for(int i=0;i<nums.length;i++){
			sum+=nums[i];
			int rem=sum%k;
			if(hm.containsKey(rem)){
				if(i-hm.get(rem)>=2){
					return true;
				}
			}
			else{
				hm.put(rem,i);
			}
		}
		return false;
	}
	
	public static void main(String []args) {
		ContinuousSubarraySum c = new ContinuousSubarraySum();
		System.out.println(c.checkSubarraySum(new int[] {23,2,4,6,7}, 6));
		System.out.println(c.checkSubarraySum(new int[] {23,2,6,4,7}, 6));
		System.out.println(c.checkSubarraySum(new int[] {23,2,6,4,7}, 13));
	}

}
