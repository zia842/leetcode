import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree {

	List<Integer> result;

	/**
	 * Time Complexity O(N)
	 * Space O(N)
	 * @param root
	 * @return
	 */
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		result = new ArrayList<>();

		if(root == null) return result;

		result.add(root.val);
		preOrder(root.left, true); 
		postOrder(root.right, true);
		
		return result;
	}
	
	/**
	 * 
	 * @param root
	 * @param isBoundary
	 */

	public void preOrder(TreeNode root, Boolean isBoundary) {

		//Left, Root, Right
		
		if(root == null) return;

		if(root.left == null && root.right == null) { //Add Leaf
			result.add(root.val);
			return;
		}

		if(isBoundary) { // Boundary Root / Parent Node
			result.add(root.val);
		}

		preOrder(root.left, isBoundary); //Left
		preOrder(root.right, isBoundary ? root.left == null ? true : false : false); //Right
		return;

	}

	public void postOrder(TreeNode root, Boolean isBoundary) {
		
		//Left, Right, Root
		
		if(root == null) return;

		if(root.left == null && root.right == null) { //Add Leaf
			result.add(root.val);
			return;
		}
		
		//Left
		postOrder(root.left, isBoundary ? root.right == null ? true : false : false);
		
		//Right
		postOrder(root.right, isBoundary);
		
		
		if(isBoundary) { // Boundary Root / Parent Node
			result.add(root.val);
		}
		
		return;

	}

}
