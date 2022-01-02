import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {

	public int deleteAndEarn(int[] nums) {
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<nums.length;i++){
			max = Math.max(max, nums[i]);
		}
		
		int[] arr = new int[max+2];
		arr[0]=0;
		
		for(int i=0;i<nums.length;i++){
			arr[nums[i]] = arr[nums[i]] + nums[i];
		}
		
		int[] dp = new int[arr.length];
		
		for(int i=0;i<arr.length;i++){
			if(i==0)
				dp[i] = arr[i];
			else if(i==1)
				dp[i] = Math.max(arr[i-1],arr[i]);
			else
				dp[i] = Math.max(arr[i]+dp[i-2],dp[i-1]);
		}
		
		return dp[arr.length-1];

	}
	
	public int deleteAndEarnFrequency(int[] nums) {
		
		int max =  Arrays.stream(nums).max().getAsInt();
		int freqArr[] = new int[max+2];
		int dpTable[] = new int[max+2];
		
		for(int i=0;i<nums.length;i++){
			freqArr[nums[i]]++; //Count the frequency
		}
		
		dpTable[1] = freqArr[1];
		dpTable[2] = Math.max(dpTable[1], freqArr[2]*2);
		
		for(int i=3;i<=max;i++) {
			dpTable[i] = Math.max(dpTable[i-1], dpTable[i-2]+freqArr[i]*i);
		}
		
		return Arrays.stream(dpTable).max().getAsInt();
	}

	public static void main(String []args) {
		DeleteAndEarn d = new DeleteAndEarn();
		System.out.println(d.deleteAndEarnFrequency(new int [] {3,4,2}));
		System.out.println(d.deleteAndEarnFrequency(new int [] {2,2,3,3,3,4}));
	}

}
