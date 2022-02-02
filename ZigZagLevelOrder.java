import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrder {

	public List<List<Integer>> levelOrder(BinaryTreeNode root) {
		List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);
		queue.add(new BinaryTreeNode(1002)); //Marking end anything can be taken which does not have constraint
		int level = 0;

		List<Integer> resultList = new ArrayList<Integer>();
		while(queue!=null && !queue.isEmpty()) {
			BinaryTreeNode node = queue.poll();

			if(node!=null && node.val == 1002) {
				if(!resultList.isEmpty() && resultList.size() > 0) {
					if(level%2 != 0) {
						Collections.reverse(resultList);
					}
					levelOrderList.add(resultList);
					resultList = new ArrayList<Integer>();
					level++;
					queue.offer(node);
				}
				continue;
			}
			if(node!=null)
				resultList.add(node.val);

			if(node!=null && node.left!=null) { 
				queue.add(node.left); 
			}
			if(node!=null && node.right!=null) { 
				queue.add(node.right); 
			} 

		}
		return levelOrderList;

	}

	public static void main(String []args) {
		ZigZagLevelOrder z = new ZigZagLevelOrder();
		BinaryTreeNode root = new BinaryTreeNode(3);
		root.left = new BinaryTreeNode(9);
		root.right = new BinaryTreeNode(20);
		root.right.left = new BinaryTreeNode(15);
		root.right.right = new BinaryTreeNode(7);
		//System.out.println(z.levelOrder(root));


		root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);

		//System.out.println(z.levelOrder(root));

		root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.right.right = new BinaryTreeNode(5);

		//System.out.println(z.levelOrder(root));


		root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.right.left = new BinaryTreeNode(5);

		System.out.println(z.levelOrder(root));



	}

}
