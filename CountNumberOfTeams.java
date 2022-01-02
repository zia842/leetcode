public class CountNumberOfTeams {

	public int numTeams(int[] rating) {

		int increasing[] = new int[rating.length];
		int decreasing[] = new int[rating.length];

		int result = 0;
		for(int i=0;i<rating.length;i++) {
			for(int j=0;j<i;j++) {
				if(rating[j] > rating[i]) {
					increasing[i]++;
					result += increasing[j];
				}
				else if(rating[j] < rating[i]){
					decreasing[i]++;
					result += decreasing[j];
				}
			}
			
		}
		return result;
	}
	
	public static void main(String []args) {
		CountNumberOfTeams c = new CountNumberOfTeams();
		System.out.println(c.numTeams(new int[] {2,5,3,4,1}));
		System.out.println(c.numTeams(new int[] {2,1,3}));
		System.out.println(c.numTeams(new int[] {1,2,3,4}));
	}

}
