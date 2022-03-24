import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	
	/**
	 * Time Complexity O(N)
	 * Space Complexity O(N)
	 * @param root
	 * @return
	 */

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> visibleValues = new ArrayList<Integer>();

		if(root == null) {
			return visibleValues;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0;i<size;i++) {
				TreeNode current = queue.poll();
				if(i == size-1) {
					visibleValues.add(current.val);
				}
				if(current.left!=null) {
					queue.offer(current.left);
				}

				if(current.right!=null) {
					queue.offer(current.right);
				}
			}
		}
		return visibleValues;
	}

}
