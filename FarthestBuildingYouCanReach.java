import java.util.PriorityQueue;

public class FarthestBuildingYouCanReach {

	public int furthestBuilding(int[] heights, int bricks, int ladders) {
		if(heights!=null && heights.length > 0) {
			
			PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
			for(int i=0;i<heights.length-1;i++) {
				
				int diff = heights[i+1] - heights[i];
				if(diff > 0) { //If Difference < 0 then its jump else its climb
					priorityQueue.add(diff);
				}
				
				if(priorityQueue.size() > ladders) {
					bricks -= priorityQueue.poll();
				}
				
				if(bricks < 0) {
					return i;
				}
			}
			
		}
		return heights.length - 1;

	}
	
	public static void main(String []args) {
		FarthestBuildingYouCanReach f = new FarthestBuildingYouCanReach();
		System.out.println(f.furthestBuilding(new int [] {4,2,7,6,9,14,12}, 5, 1));
		System.out.println(f.furthestBuilding(new int [] {4,12,2,7,3,18,20,3,19}, 10, 2));
		System.out.println(f.furthestBuilding(new int [] {14,3,19,3}, 17, 0));
	}

}
