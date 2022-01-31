import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InOrderSuccessor {
	
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		List<TreeNode> inOrderList = new ArrayList<TreeNode>();
	    inOrder(root, inOrderList);
	    int index = -1;
	    for(int i=0;i<inOrderList.size();i++) {
	    	if(inOrderList.get(i).val == p.val) {
	    		index = i;
	    		break;
	    	}
	    }
	    return index+1 < inOrderList.size() ? inOrderList.get(index+1) : null;
	}
	
	public void inOrder(TreeNode root, List<TreeNode> inOrderList) {
		if(root == null) {
			return;
		}
		
		inOrder(root.left, inOrderList);
		inOrderList.add(root);
		inOrder(root.right, inOrderList);
		
	}
	
	public static void main(String []args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		InOrderSuccessor i = new InOrderSuccessor();
		System.out.println(i.inorderSuccessor(root, root.left).val); //2

		root = new TreeNode(5);
		root.right = new TreeNode(6);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left = new TreeNode(1);
		//System.out.println(i.inorderSuccessor(root, root.right).val); //null

		root = new TreeNode(7);

		root.left = new TreeNode(4);
		root.left.left = new TreeNode(2);
		root.left.left.right = new TreeNode(3);

		root.right = new TreeNode(10);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(12);
		System.out.println(i.inorderSuccessor(root, root.left.left).val); //3

		System.out.println(i.inorderSuccessor(root, root.left).val); //7

		System.out.println(i.inorderSuccessor(root, root).val); //8

		Integer value1 = null;
		Integer value2 = new Integer(10);

		//Optional.ofNullable - allows passed parameter to be null.
		Optional<Integer> a = Optional.ofNullable(value1);

		//Optional.of - throws NullPointerException if passed parameter is null
		Optional<Integer> b = Optional.of(value2);
		System.out.println(i.sum(a,b));
		 
	}
	
	public Integer sum(Optional<Integer> a, Optional<Integer> b) {
		//Optional.isPresent - checks the value is present or not

		System.out.println("First parameter is present: " + a.isPresent());
		System.out.println("Second parameter is present: " + b.isPresent());

		//Optional.orElse - returns the value if present otherwise returns
		//the default value passed.
		Integer value1 = a.orElse(new Integer(0));

		//Optional.get - gets the value, value should be present
		Integer value2 = b.get();
		return value1 + value2;
	}

}
