import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
	
	public boolean isSymmetric(TreeNode root) {
		return isMirror(root.left,root.right);
    }
	
	public boolean isMirror(TreeNode nodeOne, TreeNode nodeTwo) {
		
		if(nodeOne == null && nodeTwo == null) 
			return true;
		if(nodeOne == null || nodeTwo == null)
			return false;
		
		return nodeOne.val == nodeTwo.val 
					&& isMirror(nodeOne.right, nodeTwo.left) 
					&& isMirror(nodeOne.left, nodeTwo.right);
	}
	
	public boolean isSymmetricIterative(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode nodeOne = queue.poll();
			TreeNode nodeTwo = queue.poll();
			if(nodeOne == null && nodeTwo == null) 
					continue;
			
			if(nodeOne == null || nodeTwo == null)
					return false;
			
			if(nodeOne.val!=nodeTwo.val)
					return false;
			
			queue.add(nodeOne.left);
			queue.add(nodeTwo.right);
			queue.add(nodeOne.right);
			queue.add(nodeTwo.left);
			
		}
		
		return true;
	}

}
