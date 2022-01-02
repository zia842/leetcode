import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class KeysAndRooms {

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {

		HashSet<Integer> visited = new HashSet<Integer>();
		visited.add(0);
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(0);
		
		while(!stack.isEmpty()) {
			
			List<Integer> keys = rooms.get(stack.pop());
			for(int key : keys) {
				if(!visited.contains(key)) {
					visited.add(key);
					stack.add(key);
				}
				
			}
			
		}
		
		return visited.size() == rooms.size();
	}
	
	public static void main(String []args) {
		KeysAndRooms k = new KeysAndRooms();
		List<List<Integer>> inputList = new ArrayList<List<Integer>>();
		inputList.add(0, Arrays.asList(new Integer[] {1}));
		inputList.add(1, Arrays.asList(new Integer[] {2}));
		inputList.add(2, Arrays.asList(new Integer[] {3}));
		inputList.add(3, Arrays.asList(new Integer[] {}));
		System.out.println(k.canVisitAllRooms(inputList));
		inputList = new ArrayList<List<Integer>>();
		inputList.add(0, Arrays.asList(new Integer[] {1,3}));
		inputList.add(1, Arrays.asList(new Integer[] {3,0,1}));
		inputList.add(2, Arrays.asList(new Integer[] {2}));
		inputList.add(3, Arrays.asList(new Integer[] {0}));
		System.out.println(k.canVisitAllRooms(inputList));
	}

}
