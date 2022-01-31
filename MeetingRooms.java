import java.util.Arrays;

public class MeetingRooms {

	public int minMeetingRooms(int[][] intervals) {
		int usedRooms = 0;
		
		Integer []start = new Integer[intervals.length];
		Integer []end = new Integer[intervals.length];
		
		int startPtr = 0;
		int endPtr = 0;
		
		for(int i=0;i<intervals.length;i++) {
			start[i] = intervals[i][0];
			end[i] = intervals[i][1];
		}
		
		Arrays.sort(start);
		Arrays.sort(end);
		
		while(startPtr < intervals.length) {
			if(start[startPtr] >= end[endPtr]) {
				usedRooms -= 1;
				endPtr++;
			}
			
			usedRooms++;
			startPtr++;
		}
		return usedRooms;
		
	}
	
	public static void main(String []args) {
		MeetingRooms m = new MeetingRooms();
		System.out.println(m.minMeetingRooms(new int[][] {{0,30},{5,10},{15,20}}));
		System.out.println(m.minMeetingRooms(new int[][] {{7,10},{2,4}}));
	}

}
