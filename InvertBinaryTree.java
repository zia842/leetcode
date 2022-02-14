import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		if(root == null) {
			return root;
		}
		TreeNode right = invertTree(root.right);
		TreeNode left = invertTree(root.left);
		root.left = right;
		root.right = left;
		return root;
	}
	
	public TreeNode invertTreeIterative(TreeNode root) {
		if(root == null) {
			return root;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode current = queue.poll();
			TreeNode temp = current.left;
			current.left = current.right;
			current.right = temp;
			if(current.left!=null) {
				queue.add(current.left);
			}
			if(current.right!=null) {
				queue.add(current.right);
			}
			
		}
		
		return root;
	}
	
	
	public static void main(String []args) {
		InvertBinaryTree i = new InvertBinaryTree();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		
		root = i.invertTree(root);
		System.out.println();
		
	}

}
