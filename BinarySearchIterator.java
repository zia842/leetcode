import java.util.ArrayList;
import java.util.List;

public class BinarySearchIterator {

	List<Integer> inOrderList;
	int pointer;
	
	public BinarySearchIterator(TreeNode root) {
		this.inOrderList = new ArrayList<Integer>();
		this.pointer = -1;
		this.inOrder(root);
	}
	
	public void inOrder(TreeNode root) {
		if(root!=null) {
			inOrder(root.left);
			this.inOrderList.add(root.val);
			inOrder(root.right);
		}
	}

	public int next() {
		return this.inOrderList.get(++this.pointer); //Advance the Pointer and return the element
	}

	public boolean hasNext() {
		return this.pointer + 1 < this.inOrderList.size();
	}

}
