
public class ValidateBinarySearch {

	public boolean isValidBST(TreeNode root) {
		return validBinaryTree(root, null, null);
	}
	
	public boolean validBinaryTree(TreeNode root, Integer min, Integer max) {
		
		if(root == null) {
			return true;
		}
		
		if((min!=null && root.val <= min) || (max!=null && root.val >= max)){
			return false;
		}
		
		return validBinaryTree(root.left, min, root.val) && validBinaryTree(root.right, root.val, max);
		
	}
	
	public static void main(String []args) {
		ValidateBinarySearch v = new ValidateBinarySearch();
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		System.out.println(v.isValidBST(root));
		root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(6);
		System.out.println(v.isValidBST(root));
	}

}
