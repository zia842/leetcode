
public class MissingNumber {

	public int solution(int[] A) {
		// write your code in Java SE 8
		int sizeRequired = Integer.MIN_VALUE;
		boolean isAllNegative = true;


		for(int i=0;i<A.length;i++) {
			sizeRequired = Math.max(sizeRequired, A[i]);
			if(A[i] > 0) {
				isAllNegative = false; //Atleast 1 positive
			}
			else {
				sizeRequired = Integer.MAX_VALUE;
			}
		}

		if(isAllNegative) {
			return 1;
		}

		int tempArr[] = new int[sizeRequired+1];
		for(int i=0;i<A.length;i++) {
			tempArr[A[i]] = tempArr[A[i]] + 1;
		}

		for(int i=1;i<tempArr.length;i++) {
			if(tempArr[i] == 0) {
				return i;
			}
		}



		return A.length + 1;
	}

	public int soln(int[] A) {
		int n = A.length;

		boolean[] present = new boolean[n + 1];

		for (int i = 0; i < n; i++) {

			if (A[i] > 0 && A[i] <= n)
				present[A[i]] = true;
		}

		for (int i = 1; i <= n; i++)
			if (!present[i])
				return i;

		return n + 1;
	}

	public static void main(String []args) {
		MissingNumber m = new MissingNumber();
		System.out.println(m.soln(new int[]{1, 3, 6, 4, 1, 2}));
		System.out.println(m.soln(new int[]{1, 2, 3}));
		System.out.println(m.soln(new int[]{-1,-3}));
		System.out.println(m.soln(new int[]{-1,-3,1}));
	}

}
