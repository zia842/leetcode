import java.util.Arrays;

public class RankTeamsByVotes {
	
	public String rankTeamsDifferent(String []votes) {
		int n = votes.length;
		String firstVote = votes[0];

		if(n == 1) //If only 1 vote exist
			return firstVote;
	
		int numVotes = firstVote.length();
		int[][] voteCount = new int[26][27];
		for(char c : firstVote.toCharArray()){
			int index = c - 'A';
			voteCount[index][0] = index + 1;
		}
		
		for(String vote : votes){
			// represent the possible vote positions with 1 - 26 in the voteCount 2d array.
			for(int i = 1; i <= numVotes; i++){
				int index = vote.charAt(i - 1) - 'A';
				voteCount[index][i] ++;
			}
		}
		
		Arrays.sort(voteCount, (a,b) -> {
			for(int i = 1; i < 27; i++){
				if(a[i] != b[i])
					return b[i] - a[i];
			}

			return a[0] - b[0];
		});
		
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < 26; i++){

			if(voteCount[i][0] > 0)


				sb.append((char)('A' + (voteCount[i][0] - 1)));  
		}

		return sb.toString();
		
	}

	public String rankTeams(String[] votes) {

		// check the number of votes cast, if only one, then return the vote and end.
		int n = votes.length;
		String firstVote = votes[0];

		if(n == 1)
			return firstVote;

		// with more than on vote to cast, get the total number of teams to rank
		int numVotes = firstVote.length();

		// create a 2d array that states how many votes a given team recived at a given rank across all votes
		// this will be sorted to find the final correct order. The first index in each array is reserved for 
		// an int representing a team id which can be used for sorting and will be transformed back to a character
		// at the end of the method when the final order is being rendered and returned.
		int[][] voteCount = new int[26][27];

		// using the first vote, mark all the letters that are actually part of this vote (and all others) with
		// and id so any letters in the alphabet not in the vote can be ignored when rendering the final order.
		// Note that letter 'A' will be represented as 1 so any index with a value of 0 is a letter not part 
		// of this paritical list of teams and can be ignored.
		for(char c : firstVote.toCharArray()){
			int index = c - 'A';
			voteCount[index][0] = index + 1;
		}

		// for each vote, collect the total number of votes for each team at each position, this will provide
		// the basis for ranking the teams as the team with the most votes in the first positions will be ranked 
		// in front of a team with less votes in the first positions.
		for(String vote : votes){

			// represent the possible vote positions with 1 - 26 in the voteCount 2d array.
			for(int i = 1; i <= numVotes; i++){

				int index = vote.charAt(i - 1) - 'A';
				voteCount[index][i] ++;
			}
		}

		// with all the votes for each position tallied, use a lambda functiuon to sort the 2d vote count array
		// first compare two arrays by which of the two has a larger vote total in the indices 1 - 26. If the two
		// happen to be tied on every vote position, then compare the actual team letter order via their id 
		// at index 0.
		Arrays.sort(voteCount, (a,b) -> {
			for(int i = 1; i < 27; i++){
				if(a[i] != b[i])
					return b[i] - a[i];
			}

			return a[0] - b[0];
		});

		// with the array of votes per team per position sorted, we can build the final correct team ranking.
		// use a string builder to efficently construct the final string. Recall that the team id corresponds to
		// its letter's difference from the letter 'A' + 1, so we subtract 1 from the team id to get the correct 
		// letter.
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < 26; i++){

			if(voteCount[i][0] > 0)


				sb.append((char)('A' + (voteCount[i][0] - 1)));  
		}

		return sb.toString();
	}
	
	public static void main(String []args) {
		RankTeamsByVotes r = new RankTeamsByVotes();
		//System.out.println(r.rankTeamsDifferent(new String[] {"ABC","ACB","ABC","ACB","ACB","ABC","ACB","ABC","ACB","ACB","ABC","ACB","ABC","ACB","ACB","ABC","ACB","ABC","ACB","ACB","ABC","ACB","ABC","ACB","ACB","ABC","ACB","ABC","ACB","ACB","ABC","ACB","ABC","ACB","ACB"}));
		System.out.println(r.rankTeamsDifferent(new String[] {"ABC","ACB","ABC","ACB","ACB"}));
		System.out.println(r.rankTeamsDifferent(new String[] {"ABCD","DCBA","ABCD","BCDA","CBDA"}));
	}

}
