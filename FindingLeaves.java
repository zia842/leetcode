import java.util.ArrayList;
import java.util.List;

public class FindingLeaves {
	
	private List<List<Integer>> resultList;
	
	public int calculateHeight(TreeNode root) {
		
		if(root == null) { //Base case for Recursion
			return -1;
		}
		
		 //Post Order Left, Right, Root
		
		int leftChild = calculateHeight(root.left);
		int rightChild = calculateHeight(root.right);
		
		//Count the actual Node in case of leaf node both left and right will return -1 max of (-1,-1) + 1
		int result = Math.max(leftChild, rightChild) + 1;
		
		//Set the output 
		if(this.resultList.size() == result) {
			this.resultList.add(new ArrayList<Integer>());
		}
		
		this.resultList.get(result).add(root.val);
		
		return result;
		
	}
	

	public List<List<Integer>> findLeaves(TreeNode root) {
		this.resultList = new ArrayList<List<Integer>>();
		calculateHeight(root);
		return this.resultList;
	}
	
	public static void main(String []args) {
		TreeNode root = new TreeNode(1);
		root.left =  new TreeNode(2);
		root.right =  new TreeNode(3);
		root.left.left =  new TreeNode(4);
		root.left.right =  new TreeNode(5);
		FindingLeaves f = new FindingLeaves();
		List<List<Integer>> outputList = f.findLeaves(root);
		System.out.println(outputList);
		
	}

}
