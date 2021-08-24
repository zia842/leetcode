import java.util.Hashtable;

public class TwoSum {
	
	 public static int[] twoSum(int[] nums, int target) {
        Hashtable<Integer,Integer> tableA = new Hashtable<Integer,Integer>();
        int[] result = new int[2];
        if(nums!=null && nums.length > 0){
        
            for(int i=0;i<nums.length;i++){
                tableA.put(nums[i],Integer.valueOf(i));
            }
            
            for(int i=0;i<nums.length;i++){
                
                if(tableA.get(target-nums[i])!= null
                            && tableA.get(target-nums[i])!= i){
                    result[0] = i;
                    result[1] = tableA.get(target-nums[i]);
                    break;
                }
                
            }
            
        }
        return result;
	 }
	 
	 public static void main(String []args) {
		 
		 int arr[] = {2,7,11,15};
		 int target = 9;
		 
		 int []result = twoSum(arr, target);
		 
		 System.out.println(result[0] + " " + result[1]);
		 
		 result = twoSum(new int[]{3,3}, 6);
		 System.out.println(result[0] + " " + result[1]);
		 
		 result = twoSum(new int[]{3,2,4}, 6);
		 System.out.println(result[0] + " " + result[1]);
		 
		 
	 }

}
