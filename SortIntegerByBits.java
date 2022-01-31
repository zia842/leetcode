import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortIntegerByBits {

	public int[] sortByBits(int[] arr) {

		List<Num> resultList = new ArrayList<Num>();
		
		int numOfBits = 0;
		for(int i=0;i<arr.length;i++) {
			numOfBits = getNumberOfBits(arr[i]);
			Num num = new Num(arr[i], i, numOfBits);
			resultList.add(num);
		}

		Collections.sort(resultList);
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = resultList.get(i).value;
		}

		return arr;
	}

	public int getNumberOfBits(int num) {
		int numOfBits = 0;
		while(num > 0) {
			numOfBits = numOfBits + (num % 2);
			num = num/2;
		}
		return numOfBits;
	}

	class Num implements Comparable<Num>{

		int value;
		int position;
		int numOfBits;

		public Num(int value, int position, int numOfBits) {
			this.value = value;
			this.position = position;
			this.numOfBits = numOfBits;
		}

		@Override
		public int compareTo(Num num) {
			int position = num.position;
			int numOfBits = num.numOfBits;
			int value = num.value;

			if (this.numOfBits > numOfBits){
				return 1;   
			}
			if (this.numOfBits < numOfBits){
				return -1;   
			}

			if (this.numOfBits == numOfBits){ 

				if(this.value > value){ 
					return 1; 
				}

				if(this.value < value){ 
					return -1; 
				} 
			}

			return 0;  
		}

	}

	public static void main(String []args) {
		SortIntegerByBits s = new SortIntegerByBits();
		int result[] = s.sortByBits(new int[] {0,1,2,3,4,5,6,7,8});
		for(int r : result) {
				System.out.println(r);
		}

		result = s.sortByBits(new int[] {1024,512,256,128,64,32,16,8,4,2,1});
		for(int r : result) {
			System.out.println(r);
		}

	}

}
