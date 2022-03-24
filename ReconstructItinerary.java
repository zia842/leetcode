import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ReconstructItinerary {

	public List<String> findItinerary(List<List<String>> tickets) {
		Map<String,List<String>>map = new HashMap<String,List<String>>();
		List<String> result = new ArrayList<String>();
		//Using stack to keep the track incase if lexicaly small elem leads to dead end
		//but we still have a path to reach dest          A  
		Stack<String> stack = new Stack<String>();          //   /   \ \
		//   B    C
		stack.push("JFK");

		for(int i = 0; i < tickets.size(); i++)  {

			List<String> arr = new ArrayList<String>();
			String fromCity =  tickets.get(i).get(0);
			String toCity   =  tickets.get(i).get(1); 

			if(map.containsKey(fromCity))
			{  
				arr = map.get(fromCity);
				arr.add(toCity);
				Collections.sort(arr);
				map.put(fromCity,arr);
			} 
			else 
			{
				arr.add(toCity);
				Collections.sort(arr);
				map.put(fromCity,arr);
			}
		}

		while(!stack.isEmpty()) {

			String city = stack.peek();
			List<String> routes = map.get(city);

			if(routes == null || routes.size() == 0) {

				result.add(city);
				stack.pop();

			} 
			else {
				String temp = routes.get(0).toString();
				stack.push(routes.get(0).toString());
				routes.remove(temp);
			}                 
		}

		Collections.reverse(result);

		return result;
	}

	public static void main(String []args) {
		//Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
		//Output: ["JFK","MUC","LHR","SFO","SJC"]

		//Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
		//Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
		//Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.
	}

}
