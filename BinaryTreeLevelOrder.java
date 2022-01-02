import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeNode {
	int val;
	BinaryTreeNode left;
	BinaryTreeNode right;
	BinaryTreeNode() {}
	BinaryTreeNode(int val) { this.val = val; }
	BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
public class BinaryTreeLevelOrder {

	public List<List<Integer>> levelOrder(BinaryTreeNode root) {
		List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);
		queue.add(new BinaryTreeNode(1002)); //Marking end anything can be taken which does not have constraint
		
		List<Integer> resultList = new ArrayList<Integer>();
		while(queue!=null && !queue.isEmpty()) {
			BinaryTreeNode node = queue.poll();
		
			if(node.val == 1002) {
				if(!resultList.isEmpty() && resultList.size() > 0) {
					levelOrderList.add(resultList);
					resultList = new ArrayList<Integer>();
					queue.offer(node);
				}
				continue;
			}
			resultList.add(node.val);
			/*
			 * if(queue.isEmpty()) { levelOrderList.add(resultList); resultList = new
			 * ArrayList<Integer>(); }
			 */
			if(node.left!=null) {
				queue.add(node.left);
			}
			if(node.right!=null) {
				queue.add(node.right);
			}
			
		}
		
		return levelOrderList;

	}
	
	public static void main(String []args) {
		BinaryTreeLevelOrder b = new BinaryTreeLevelOrder();
		BinaryTreeNode root = new BinaryTreeNode(3);
		root.left = new BinaryTreeNode(9);
		root.right = new BinaryTreeNode(20);
		root.right.left = new BinaryTreeNode(15);
		root.right.right = new BinaryTreeNode(7);
		System.out.println(b.levelOrder(root));
		
		
		root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		
		System.out.println(b.levelOrder(root));
		
		root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.right.right = new BinaryTreeNode(5);
		
		System.out.println(b.levelOrder(root));
		
	}

}
