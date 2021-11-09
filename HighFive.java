import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Given a list of the scores of different students, items, where items[i] = [IDi, scorei] represents one score from a student with IDi, 
 * calculate each student's top five average.

  Return the answer as an array of pairs result, where result[j] = [IDj, topFiveAveragej] represents the student with IDj and their top five average. 
  Sort result by IDj in increasing order.

   A student's top five average is calculated by taking the sum of their top five scores and dividing it by 5 using integer division.
   
   Input: items = [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
   Output: [[1,87],[2,88]]
  
  Explanation: 
	The student with ID = 1 got scores 91, 92, 60, 65, 87, and 100. Their top five average is (100 + 92 + 91 + 87 + 65) / 5 = 87.
	The student with ID = 2 got scores 93, 97, 77, 100, and 76. Their top five average is (100 + 97 + 93 + 77 + 76) / 5 = 88.6, 
    but with integer division their average converts to 88.
    
    Constraints:

    1 <= items.length <= 1000
    items[i].length == 2
    1 <= IDi <= 1000
    0 <= scorei <= 100
    For each IDi, there will be at least five scores.

    
 * @author zia84
 *
 */

public class HighFive {
	
	public int[][] highFive(int[][] items) {
		int [][]result = null;

		if(items!=null && items.length > 0) {
			
			
			//Sort based on id if id(asc) is same sort based on score desc
			Arrays.sort(items, new Comparator<int[]>() {
				@Override
				public int compare(int[] entry1, int[] entry2) {
					if(entry1[0] == entry2[0]){
						return entry2[1] - entry1[1];
					}
					return entry1[0] - entry2[0];
				}
			});

			//ID - > List of Scores
			Map<Integer,ArrayList<Integer>> idAndScore = new HashMap<Integer,ArrayList<Integer>>();
			Map<Integer,Integer> map = new HashMap<Integer,Integer>();

			
			for(int i=0;i<items.length;i++) {
				Integer id = Integer.valueOf(items[i][0]);
				Integer s =  Integer.valueOf(items[i][1]);
				ArrayList<Integer> score = idAndScore.get(id) == null ? new ArrayList<Integer>() : idAndScore.get(id);
				Integer sc = map.get(id) == null ? Integer.valueOf(0) : map.get(id);
				if(score.size() == 5) { //Take 5 items only
					continue;
				}
				score.add(s);
				idAndScore.put(id, score);
				sc += s; //Sum the score
				map.put(id, sc);
			} 

			Set<Integer> keySet = idAndScore.keySet();
			result = new int[keySet.size()][2];
			int count = 0;
			Iterator<Integer> iterator = keySet.iterator();
			while(iterator.hasNext()) {
				Integer key = iterator.next();
				//ArrayList<Integer> score = idAndScore.get(key);
				//OptionalDouble avg = score.stream().mapToDouble(a -> a).average();
				int avg1 = map.get(key) / 5;
				// System.out.println(avg );
				// System.out.println(avg1 );
				result[count][0] = key;
				result[count++][1] = avg1;

			}

		}

		return result;
	}
	
	public static void main(String []args) {
		HighFive h = new HighFive();
		h.highFive(new int [][] {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}});
	}

}





