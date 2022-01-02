import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubArray {
	public int shortestSubarray(int[] A, int K) {
		int N = A.length;
		long[] P = new long[N+1];
		for (int i = 0; i < N; ++i)
			P[i+1] = P[i] + (long) A[i];

		// Want smallest y-x with P[y] - P[x] >= K
		int ans = N+1; // N+1 is impossible
		Deque<Integer> monoq = new LinkedList(); //opt(y) candidates, as indices of P

		for (int y = 0; y < P.length; ++y) {
			// Want opt(y) = largest x with P[x] <= P[y] - K;
			while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
				monoq.removeLast();
			while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
				ans = Math.min(ans, y - monoq.removeFirst());

			monoq.addLast(y);
		}

		return ans < N+1 ? ans : -1;
	}
	
	/**
	 * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/discuss/143726/C++JavaPython-O%28N%29-Using-Deque
	 * https://ttzztt.gitbooks.io/lc/content/design-tic-tac-toe.html
	 * 
	 * Using Deque + keeping increasing order: only larger index in the queue can have larger sum value. 
	 * We use cumulative sum and priority queue that maintains minimal value within the window of a given length. 
	 * We then iterate over all possible ends of windows and check, 
	 * what is the maximal possible sum across all windows of length l <= L that end at this element.
	 * @param A
	 * @param K
	 * @return
	 */
	
	public int shortestSubarrayLinear(int[] A, int k) {
		int n = A.length, result = n + 1;
		long[] B = new long[n + 1];
		
        for (int i = 0; i < n; i++) //Prefix Sum
        	B[i + 1] = B[i] + A[i];
        
        /**
         *  Basic idea, for array starting at every A[i], 
         *  find the shortest one with sum at least K.
			In my solution, for B[i], find the smallest j that B[j] - B[i] >= K.
         */
        
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n + 1; i++) {
        	
        	
            /**
             * What is the purpose of first while loop?
             * 
             * For the current prefix sum B[i], it covers all subarray ending at A[i-1].
		       We want know if there is a subarray, which starts from an index, ends at A[i-1] and has at least sum K.
               So we start to compare B[i] with the smallest prefix sum in our deque, which is B[D[0]], hoping that [i] - B[d[0]] >= K.
               So if B[i] - B[d[0]] >= K, we can update our result res = min(res, i - d.popleft()).
               The while loop helps compare one by one, until this condition isn't valid anymore.
             */
        	/**
        	 * Why we pop left in the first while loop?
        	 * This the most tricky part that improve my solution to get only O(N).
				D[0] exists in our deque, it means that before B[i], we didn't find a subarray whose sum at least K.
				B[i] is the first prefix sum that valid this condition.
				In other words, A[D[0]] ~ A[i-1] is the shortest subarray starting at A[D[0]] with sum at least K.
				We have already find it for A[D[0]] and it can't be shorter, so we can drop it from our deque.
        	 */
        	
        	while (d.size() > 0 && B[i] - B[d.getFirst()] >=  k)
        		result = Math.min(result, i - d.pollFirst());
            
            while (d.size() > 0 && B[i] <= B[d.getLast()])
                d.pollLast();
            d.addLast(i);
        }
        
        return result <= n ? result : -1;
	}
	
	public static void main(String []args) {
		ShortestSubArray s = new ShortestSubArray();
		System.out.println(s.shortestSubarrayLinear(new int [] {2,-1,2}, 3));
	}
}
