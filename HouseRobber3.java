
/**
 * 
 * @author zia84
 *   
 *   	[104, 104]									  3
 *  	[20, 100] 								20 			4			[4, 1]
 *  	[100, 0]							100					1		[1, 0]						
 *   	[0,0]
 *   
 * 
 */

public class HouseRobber3 {

	public int rob(TreeNode root) {
		int resultPair[] = dfs(root);
		return Math.max(resultPair[0], resultPair[1]);
	}
	
	public int[] dfs(TreeNode root){
		
		int resultPair[] = new int[2];
		if(root == null) {
			return resultPair;
		}
		
		int leftPair[] = dfs(root.left);
		int rightPair[] = dfs(root.right);
		
		int withRoot = root.val + leftPair[1] + rightPair[1];
		int withoutRoot = Math.max(leftPair[0], leftPair[1]) + Math.max(rightPair[0], rightPair[1]);

		resultPair[0] = withRoot;
		resultPair[1] = withoutRoot;
		
		return resultPair;
	}

}
