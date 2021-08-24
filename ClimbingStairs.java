
public class ClimbingStairs {

	 public int climbStairs(int n) {

		 if(n <= 2) {
			 return n;
		 }
		 
		 int stairs[] = new int[n+1];
		 stairs[0] = 1;
		 stairs[1] = 1;
		 
		 for(int i=2;i<=n;i++) {
			 stairs[i] = stairs[i-1] + stairs[i-2];
		 }
		 return stairs[stairs.length-1];
	 }
	 
	 public static void main(String []args) {
		 ClimbingStairs c = new ClimbingStairs();
		 System.out.println(c.climbStairs(1));
		 System.out.println(c.climbStairs(2));
		 System.out.println(c.climbStairs(3));
		 System.out.println(c.climbStairs(4));
	 }
	
}
