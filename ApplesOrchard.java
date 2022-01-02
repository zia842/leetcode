
public class ApplesOrchard {

	public int findMaximumApples(int A[], int k, int l){
		int ans1 = findMaximumApplesImpl(A, k, l);
		int ans2 = findMaximumApplesImpl(A, l, k);
		return Math.max(ans1, ans2);

	}
	private int findMaximumApplesImpl(int A[], int k, int l){

		if(k+l > A.length){ //If there are no elements to choose
			return -1;
		}
		int sum[] = new int[A.length + 1];
		sum[0] = A[0];

		for(int i=1;i<A.length;i++){
			sum[i] = sum[i-1] + A[i]; //Prefix Sum
		}

		int max = -1;
		int x = 0,y = 0;

		for(int i : sum) {
			System.out.print(i + " ");
		}
		System.out.println("\n");
		for(int a = 0;a+k-1 < A.length;a++){

			if(a > 0) {
				x = sum[a+k-1] - sum[a-1];
				System.out.println("\n");
				System.out.println("a-> " + a + " sum[a+k-1] -> " + sum[a+k-1] + " sum[a-1] " + sum[a-1]);
			}
			else {
				x = sum[a+k-1];
				System.out.println("a-> " + a + " sum[a+k-1] -> " + sum[a+k-1]);
			}

			for(int b = a+k;b+l-1 < A.length;b++){

				if(b > 0) {
					y = sum[b+l-1] - sum[b-1];
					System.out.println("b-> " + b + " sum[b+l-1] -> " + sum[b+l-1] + " sum[b-1] " + sum[b-1]);
				}
				else {
					y= sum[b+l-1];
					System.out.println("b-> " + b + " sum[b+l-1] -> " + sum[b+l-1]);
				}


				if(x+y > max){
					max = x + y;
				}
			}
		}

		return max;
	}

	public static void main(String[] args){
		ApplesOrchard applesOrchard = new ApplesOrchard();
		System.out.println(applesOrchard.findMaxApple(new int [] {6, 1, 4, 6, 3, 2, 7, 4}, 3, 3));
		//	System.out.println(applesOrchard.findMaximumApples(new int [] {10, 19, 15}, 2, 2));
	}

	private int findMaxApple(int A[], int K, int L){
		if (A.length < K + L) { //invalid
			return -1;
		}

		if (A.length == K + L) { //only one solution
			int sum = 0;
			for(int i : A) {
				sum += i;
			}
			return sum;
		}

		int sum = 0;
		int alice = 0;
		int bob = 0;

		for (int i=0;i<A.length-K-L;i++) {
			if (alice == 0) {
				for (int k = i;k<i+K;k++) {
					alice += A[k];
				}
			} else {
				alice += A[i + K - 1];
				alice -= A[i - 1];
			}
			bob = 0;
			for (int j=i+K;j<A.length-L;j++) {
				if (bob == 0) {
					for (int k=j;k<j + L;k++) {
						bob += A[k];
					}
				} else {
					bob += A[j + L - 1];
					bob -= A[j - 1];
				}
				sum = Math.max(sum, alice + bob);
			}

		}

		bob = 0;
		for (int i=0;i<A.length-K-L;i++) {
			if (bob == 0) {
				for (int k=i;k<i + L;k++) {
					bob += A[k];
				}
			} else {
				bob += A[i + L - 1];
				bob -= A[i - 1];
			}
			alice = 0;
			for (int j=i+L;j<A.length-K;j++) {
				if (alice == 0) {
					for (int k=j;k<j + K;j++) {
						alice += A[k];
					}
				} else {
					alice += A[j + K - 1];
					alice -= A[j - 1];
				}
				sum = Math.max(sum, alice + bob);
			}
		}

		return sum;
	}

}
