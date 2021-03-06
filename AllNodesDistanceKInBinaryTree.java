import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AllNodesDistanceKInBinaryTree {

	Map<TreeNode, TreeNode> parent;

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		this.parent = new HashMap<TreeNode, TreeNode>();
		dfs(root, null);

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(null);
		queue.add(target);

		Set<TreeNode> seen = new HashSet<TreeNode>();
		seen.add(target);
		seen.add(null);

		int dist = 0;
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				if (dist == k) {
					List<Integer> ans = new ArrayList();
					for (TreeNode n: queue)
						ans.add(n.val);
					return ans;
				}
				queue.offer(null);
				dist++;
			}
			else {
				if (!seen.contains(node.left)) { //Left
					seen.add(node.left);
					queue.offer(node.left);
				}
				if (!seen.contains(node.right)) { //Right
					seen.add(node.right);
					queue.offer(node.right);
				}
				TreeNode par = parent.get(node);
				if (!seen.contains(par)) { //From Node
					seen.add(par);
					queue.offer(par);
				}
			}

		}
		return new ArrayList<Integer>();

	}

	public void dfs(TreeNode node, TreeNode p) {
		if(node!=null) {
			this.parent.put(node, p);
			dfs(node.left, node);
			dfs(node.right, node);
		}
	}

}
