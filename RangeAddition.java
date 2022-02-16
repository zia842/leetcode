
public class RangeAddition {

	public int[] getModifiedArray(int length, int[][] updates) {
		int result[] = new int[length];
		
		for(int[] u : updates) {
			
			int start = u[0];
			int end = u[1] + 1;// We will update till end + 1 but with counter part if value is 2 end+1 will have -2
			result[start] += u[2] ;//Updated with value
			
			if(end == length) continue; //Skip for last element
			result[end] -= u[2]; //end + 1
		}
		
		for(int i=1;i<length;i++) { //Start from 1 to avoid ArrayIndexOutOfBoundException
			result[i] += result[i-1]; //Prefix Sum
		}
		
		return result;
	}

}
