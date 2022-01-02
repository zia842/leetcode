import java.util.HashMap;
import java.util.Map;

public class TopVotedCandidate {
	
	int [] winners; //Keep the winner at given point-in time
	int [] times;
	
	public TopVotedCandidate(int []persons, int []times) {
		this.times = times;
		this.winners = new int[times.length];
		
		Map<Integer, Integer> voteCountMap = new HashMap<Integer, Integer>();
		
		int maxVote = 0;
		int winningCandidated = -1;
		
		for(int i=0;i<persons.length;i++) {
			
			int candidate = persons[i];
			
			int totalVotes = voteCountMap.merge(persons[i], 1, Integer::sum); //If exist add 1 otherwise 1
			
			if(maxVote <= totalVotes) { //If total votes are greater than or equal(as per requirement latest candidate) then winning candidate at that point in time
				winningCandidated = candidate;
				maxVote = totalVotes;
			}
			
			this.winners[i] = winningCandidated; // winning candidate at that point in time
			
		}
		
	}
	
	/**
	 * Binary Search to narrow down where number lies
	 * As per constraint provided times is sorted strictly increasing order
	 * @param t
	 * @return
	 */
	public int q(int t) {
		int low = 0;
		int high = winners.length-1;
		int result = -1;
		
		while(low <= high) {
			
			int mid = (low + high) / 2;
			
			if(times[mid] <= t) {
				result = Math.max(result, mid);
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
			
		}
		
		return winners[result];
	}
	
	public static void main(String []args) {
		TopVotedCandidate topVotedCandidate = new TopVotedCandidate(new int[] {0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
		System.out.println(topVotedCandidate.q(3)); // return 0, At time 3, the votes are [0], and 0 is leading.
		System.out.println(topVotedCandidate.q(12)); // return 1, At time 12, the votes are [0,1,1], and 1 is leading.
		System.out.println(topVotedCandidate.q(25)); // return 1, At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
		System.out.println(topVotedCandidate.q(15)); // return 0
		System.out.println(topVotedCandidate.q(24)); // return 0
		System.out.println(topVotedCandidate.q(8)); // return 1
	}
	

}
