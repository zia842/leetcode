import java.util.Stack;

public class SimplifyPath {

	public String simplifyPath(String path) {
		StringBuilder result = new StringBuilder();
		
		Stack<String> stack = new Stack<String>();
		
		//Split the path based on / 
		String[] components = path.split("/");
		
		//Process 
		for(String directory : components) {
			if(directory.equals(".") || directory.isEmpty()) {
				continue;
			}
			else if(directory.equals("..")) {
				if(!stack.isEmpty()) {
					stack.pop();
				}
			}
			else {
				stack.add(directory);
			}
		}
		
		for(String dir : stack) {
			result.append("/");
			result.append(dir);
		}
		return result.length() > 0 ? result.toString() : "/";
	}
	
	public static void main(String []args) {
		SimplifyPath s = new SimplifyPath();
		System.out.println(s.simplifyPath("/home/"));
		System.out.println(s.simplifyPath("/../"));
		System.out.println(s.simplifyPath("/home//foo/"));
	}

}
