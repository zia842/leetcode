import java.util.ArrayList;
import java.util.List;

public class LeafSimilar {

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> resultListOne = new ArrayList<Integer>();
		List<Integer> resultListTwo = new ArrayList<Integer>();
		leafTraversal(root1, resultListOne);
		leafTraversal(root2, resultListTwo);
		return resultListOne.equals(resultListTwo);
	}
	
	public void leafTraversal(TreeNode root, List<Integer> resultList) {
		if(root!=null) {
			if(root.left == null && root.right == null) //If Both Left & Right child does not exist its leaf node
				resultList.add(root.val);
			
			leafTraversal(root.left, resultList);
			leafTraversal(root.right, resultList);
		}
	}

}
