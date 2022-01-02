
public class LowestCommonAncestor {
	private TreeNode ans;
	
	public boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
		if(currentNode == null) {
			return false;
		}
		
		// Left Recursion. If left recursion returns true, set left = 1 else 0
		int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;
		
		// Right Recursion. If right recursion returns true, set right = 1 else 0
		int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;
		
		// If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;
        
        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }
        
        return (left+ mid + right) > 0;
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		this.recurseTree(root, p, q);
        return this.ans;
	}
	
	public static void main(String []args) {
		LowestCommonAncestor l = new LowestCommonAncestor();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left= new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		System.out.println(l.lowestCommonAncestor(root, root.left, root.right).val);
		System.out.println(l.lowestCommonAncestor(root, root.left, root.left.right.right).val);
	}
}
