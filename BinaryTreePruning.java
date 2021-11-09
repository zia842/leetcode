class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class BinaryTreePruning {

	public TreeNode pruneTree(TreeNode root) {
		return containsOne(root) ? root  : null;
	}
	
	public boolean containsOne(TreeNode node) {
		
		if(node == null) {
			return false;
		}
		
		boolean containsLeftOne = containsOne(node.left);
		if(!containsLeftOne) node.left = null;
		
		boolean containsRightOne = containsOne(node.right);
		if(!containsRightOne) node.right = null;
		
		return node.val == 1 || containsLeftOne || containsRightOne;
		
	}
	
	public static void main(String []args) {
		BinaryTreePruning b = new BinaryTreePruning();
		TreeNode root = new TreeNode(1);
		TreeNode right = new TreeNode(0);
		right.left = new TreeNode(0);
		right.right = new TreeNode(1);
		root.right = right;
		TreeNode pruneRoot = b.pruneTree(root);
		System.out.println(pruneRoot);
	}
}
