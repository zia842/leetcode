
public class BeautifulArrangment {

	public int countArrangement(int n) {
		boolean []visited = new boolean[n+1];
		return calculate(n, 1, visited);
	}
	
	public int calculate(int n, int pos, boolean []visited) {
		int count = 0;
		if(pos > n) {
			return 1;
		}
		
		for(int i=1;i<=n;i++) {
			if(!visited[i] && (pos%i == 0 || i%pos == 0)) {
				visited[i] = true;
				count += calculate(n, pos+1, visited);
				visited[i] = false;
			}
		}
		return count;
	}
	
	public static void main(String []args) {
		BeautifulArrangment b = new BeautifulArrangment();
		System.out.println(b.countArrangement(2));
	}

}
