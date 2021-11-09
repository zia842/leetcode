import java.util.LinkedList;

/**
 * 513. Find Bottom Left Tree Value
 * Bottom Left Node Value
 * Given the root of a binary tree, return the leftmost value in the last row of the tree.
Example 1:
Input: root = [2,1,3]
Output: 1

Example 2:
Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7

Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -231 <= Node.val <= 231 - 1


 * @author zia84
 *
 */

class BottomLeftTreeNode {
	int val;
	BottomLeftTreeNode left;
	BottomLeftTreeNode right;
	BottomLeftTreeNode() {}
	BottomLeftTreeNode(int val) { this.val = val; }
	BottomLeftTreeNode(int val, BottomLeftTreeNode left, BottomLeftTreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class BottomLeftTreeValue {

	public int findBottomLeftValue(BottomLeftTreeNode root) {
		
		LinkedList<BottomLeftTreeNode> queue = new LinkedList<BottomLeftTreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			root = queue.poll();
			
			if(root.right!=null) {
				queue.add(root.right);
			}
			
			if(root.left!=null) {
				queue.add(root.left);
			}
			
		}
		
		return root.val;
	}
	
	public static void main(String []args) {
		BottomLeftTreeValue b = new BottomLeftTreeValue();
		final BottomLeftTreeNode root = new BottomLeftTreeNode(4);
        root.left = new BottomLeftTreeNode(1);
        root.right = new BottomLeftTreeNode(3);
        root.right.left = new BottomLeftTreeNode(5);
        root.right.right = new BottomLeftTreeNode(9);
        
        System.out.println(b.findBottomLeftValue(root)); // 5
	}

}
