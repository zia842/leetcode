import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
	
	public int[][] merge(int[][] intervals) {
        //Sort the Array by Starting Interval
		Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
		LinkedList<int[]> merge = new LinkedList<>();
		merge.add(intervals[0]);
		
		
		for(int i=1;i<intervals.length;i++) {
			int end = merge.getLast()[1];
			//Check if Merge Required else add array
			if(end >= intervals[i][0]) {
				merge.getLast()[1] = Math.max(end, intervals[i][1]);
			}
			else 
			{
				merge.add(intervals[i]);
			}
		}
		
		return merge.toArray(new int [merge.size()][]);
    }
	
	public static void main(String []args) {
		MergeIntervals m = new MergeIntervals();
		System.out.println(m.merge(new int [][] {{1,3},{2,6},{8,10},{15,18}}));
		System.out.println(m.merge(new int [][] {{1,4},{4,5}}));
	}

	@Override
	public String toString() {
		return "MergeIntervals [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
	
}
