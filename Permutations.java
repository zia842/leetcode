import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Permutations {

	public List<List<Integer>> permute(int[] nums) {
        
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		flagArr = new boolean[nums.length];
		permutations(0, nums, resultList, new int[nums.length]);
		return resultList;
		
    }
	private static boolean flagArr[];
	public static void permutations(int k, int[] nums, List<List<Integer>> resultList, int []resultArr) {
		
		//Base Condition
		if(k >= resultArr.length) {
			List<Integer> singleList = Arrays.stream(resultArr)
				      .boxed()
				      .collect(Collectors.toList());
			if(!resultList.contains(singleList)) {
				resultList.add(singleList);
			}
			return;
		}
		
		//Loop thru
		for(int i=0;i<nums.length;i++) {
			
			if(!flagArr[i]) {
				
				flagArr[i] = true;
				resultArr[k] = nums[i]; //TODO: Fix this
				
				permutations(k+1, nums, resultList, resultArr);
				
				flagArr[i] = false; //Backtracking
				
			}
			
		}
	}
	
	public static void main(String []args) {
		Permutations p = new Permutations();
		System.out.println(p.permute(new int[] {1,2,3}));
		System.out.println(p.permute(new int[] {0,1}));
		System.out.println(p.permute(new int[] {1}));
		System.out.println(p.permute(new int[] {1,1,2}));
		
		System.out.println(p.permuteUnique(new int[] {1,1,2}));
	}
	
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        // count the occurrence of each number
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (!counter.containsKey(num))
                counter.put(num, 0);
            counter.put(num, counter.get(num) + 1);
        }

        LinkedList<Integer> comb = new LinkedList<>();
        this.backtrack(comb, nums.length, counter, results, 0);
        return results;
    }

    protected void backtrack(
            LinkedList<Integer> comb,
            Integer N,
            HashMap<Integer, Integer> counter,
            List<List<Integer>> results,
            int k) {

        if (comb.size() == N) {
            // make a deep copy of the resulting permutation,
            // since the permutation would be backtracked later.
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            
            System.out.println("k-> "+k);
            
            if (count == 0)
                continue;
            // add this number into the current combination
            comb.addLast(num);
            counter.put(num, count - 1);

            // continue the exploration
            backtrack(comb, N, counter, results, k+1);
            
            

            // revert the choice for the next exploration
            comb.removeLast();
            counter.put(num, count);
        }
    }
}
