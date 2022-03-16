import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII {
	
	boolean impossible = false; 
	
	/**
	 * 0 - Not Explored
	 * 1 - Being Explored
	 * 2 - Exploration Complete
	 * 
	 * Time Complexity O(V + E)
	 * Space Complexity O(N)
	 * 
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		
		int[] result = new int[numCourses];
		Stack<Integer> stack = new Stack<>();
		List<List<Integer>> graph = new ArrayList<>();
		int[] path = new int[numCourses];
		
		for (int i = 0; i < numCourses; i++) { // building the base.
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < prerequisites.length; i++) { // Building graph.
			graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
		
		for (int i = 0; i < numCourses; i++) { // Actual DFS calls.
			dfs(stack, graph, path, i);
			if (impossible)
				return new int[0];
		}
		
		for (int i = numCourses - 1; i >= 0; i--) // Build result.
			result[i] = stack.pop();
		
		return result;
	}
	
	private void dfs(Stack<Integer> stack, List<List<Integer>> graph, int[] path, int course) {
		
		if (path[course] == 2 || impossible) { //Already explored
			return;
		}
		
		if (path[course] == 1) { // Cycle Exists.
			impossible = true;
			return;
		}
		
		path[course] = 1; // '1' means being explored.
		
		for (int nextCourse : graph.get(course)) {
			dfs(stack, graph, path, nextCourse);
			if (impossible)
				return;
		}
		
		stack.push(course); // done exploring.
		path[course] = 2; // '2' means Exploration complete.
	}
	
	public static void main(String []args) {
		CourseScheduleII cII = new CourseScheduleII();
		cII.findOrder(2, new int[][] {{1, 0}});
	}

    
    

}
