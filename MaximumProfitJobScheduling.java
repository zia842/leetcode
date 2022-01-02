import java.util.Arrays;
import java.util.Comparator;

class Job
{
	
	int startTime;
	int endTime;
	int profit;
	public Job(int startTime, int endTime, int profit) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.profit = profit;
	}
}

class EndTimeComparator implements Comparator<Job>{

	@Override
	public int compare(Job jobOne, Job jobTwo) {
		if(jobOne.endTime <= jobTwo.endTime){
			return -1;
		}
		else{
			return 1;
		}
	}
	
}

public class MaximumProfitJobScheduling {

	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		int maxProfit = 0;
		
		if(startTime!=null && startTime.length > 0
				&& endTime!=null && endTime.length > 0
				&& profit!=null && profit.length > 0) {
			
			Job jobs[] = new Job[startTime.length];
			
			for(int i=0;i<startTime.length;i++) {
				jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
			}
			
			Arrays.sort(jobs, new EndTimeComparator()); //Sort based on End time
			
			int dpTable[] = new int[profit.length];
			dpTable[0] = jobs[0].profit;
			
			for(int i=1;i<profit.length;i++) {
				dpTable[i] = Math.max(jobs[i].profit, dpTable[i-1]);
				for(int j=i-1;j>=0;j--) {
					if(jobs[j].endTime <= jobs[i].startTime) { //If Jobs do not overlap
						dpTable[i] = Math.max(dpTable[i], jobs[i].profit + dpTable[j]);
						break;
					}
				}
			}
			
			maxProfit = Integer.MIN_VALUE;
			for(int i=0;i<dpTable.length;i++) {
				maxProfit = Math.max(maxProfit, dpTable[i]);
			}
		}
		return maxProfit;

	}
	
	public static void main(String []args) {
		MaximumProfitJobScheduling m = new MaximumProfitJobScheduling();
		System.out.println(m.jobScheduling(new int[] {1,2,3,3}, new int[] {3,4,5,6}, new int[] {50,10,40,70}));
		System.out.println(m.jobScheduling(new int[] {1,2,3,4,6}, new int[] {3,5,10,6,9}, new int[] {20,20,100,70,60}));
		
	}

}
