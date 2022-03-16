import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {

		// store adjacency list with key as course and value of list of prerequisites needed before taking this course
		Map<Integer,List<Integer>> preMap = new HashMap<>();

		for(int i=0; i<numCourses; i++) {
			// initialize prereqs as empty initially
			preMap.put(i,new ArrayList<>());
		}

		for(int[] element : prerequisites) {
			int course = element[0];
			int preReq = element[1];
			// add prereqs to adjacency list
			preMap.get(course).add(preReq);
		}

		// boolean array to indicate if a course can be taken by default all is set to false
		boolean[] visitedSet = new boolean[numCourses];
		
		// call dfs on each course this is required in case if input data is not a complete or connected graph
		for(int i=0; i<numCourses; i++) {
			if(!dfs(i,preMap, visitedSet)) {
				return false;
			}
		}

		return true;
	}

	// dfs over courses 
	public boolean dfs(int course,Map<Integer, List<Integer>> preMap, boolean[] visitedSet) {
		// returns false if this course is already visited it means there is a cycle and it is not possible to complete all courses in this case
		if(visitedSet[course]) return false;

		// return true if this course can be taken i.e when prereqs are none or size is 0 it can be taken hence return true
		if(preMap.get(course).size() == 0) return true;

		// mark this course as visited
		visitedSet[course] = true;

		// for each course call its prereqs 
		for(Integer pre : preMap.get(course)) {
			// if result is false it means one of courses cant be taken so its not possible to complete all course hence return false 
			if(!dfs(pre,preMap,visitedSet)) return false;
		}

		// if you are here it means this course can be taken hence unmarking it from being visited
		visitedSet[course] = false;
		// clear course prereqs as it is considered to be takne
		preMap.get(course).clear();
		// finally return true 

		return true;
	}

	public static void main(String []args) {
		CourseSchedule c = new CourseSchedule();
		System.out.println(c.canFinish(2, new int[][] {{1,0}}));
		System.out.println(c.canFinish(2, new int[][] {{1,0},{0,1}}));
	}

}
