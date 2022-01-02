import java.util.Arrays;

public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {

		int sumOfGas = Arrays.stream(gas).sum();
		int sumOfCost = Arrays.stream(cost).sum();

		/*
		 * If sum of gas < sum of cost there does not exist any solution because u cannot make loop/full circle
		 */

		if(sumOfGas < sumOfCost){
			return -1;
		}

		int total = 0;
		int start = 0;
		for(int i=0;i<gas.length;i++){

			total += gas[i] - cost[i];

			if(total < 0){
				total = 0;
				start = i+1;
			}

		}
		return start;
	}
	
	public static void main(String []args) {
		GasStation g = new GasStation();
		System.out.println(g.canCompleteCircuit(new int[] {1,2,3,4,5}, new int[] {3,4,5,1,2}));
		System.out.println(g.canCompleteCircuit(new int[] {2,3,4}, new int[] {3,4,3}));
	}

}
