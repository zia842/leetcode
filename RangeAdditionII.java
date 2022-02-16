
public class RangeAdditionII {
	
	/**
	 * The maximum element will be the one on which all the operations have been performed
	 *  the maximum elements will be the ones which lie in the 
	 *  intersection region of the rectangles representing the operations
	 *  
	 *  we don't actually need to perform the operations, but we need to determine the lower right 
	 *  corner of the intersecting region only. 
	 *  This corner is given by 
	 *  (x,y)=(min(op[0]),min(op[1])
	 *   where min(op[i])\text{min}(\text{op[i]})min(op[i]) 
	 *  represents the minimum value of op[i]\text{op[i]}op[i] from among all the op[i]\text{op[i]}op[i]'s 
	 *  in the given set of operations.
	 * @param m
	 * @param n
	 * @param ops
	 * @return
	 */

	public int maxCount(int m, int n, int[][] ops) {

		for(int[] op : ops) {
			m = Math.min(m, op[0]);
			n = Math.min(n, op[1]);
		}
		
		return m * n;
	}

}
