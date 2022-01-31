import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement {

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int result[] = new int[nums1.length];
		Arrays.fill(result, -1);
		
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums2.length;i++) {
			map.put(nums2[i], i);
		}
		
		int counter = 0;
		for(int i=0;i<nums1.length;i++) {
			int index = map.get(nums1[i]);
			/*
			 * if(index == nums2.length-1) { counter++; }
			 */
			
			for(int j=index+1;j<nums2.length;j++) {
				if(nums2[j] > nums1[i]) {
					result[counter] = nums2[j];
					break;
				}
			}
			counter++;
		}
		return result;

	}
	
	public static void main(String []args) {
		NextGreaterElement n = new NextGreaterElement();
		int result[] = n.nextGreaterElement(new int[] {4,1,2}, new int[] {1,3,4,2});
		for(int r : result) {
			System.out.println(r);
		}
		
		result = n.nextGreaterElement(new int[] {2,4}, new int[] {1,2,3,4});
		for(int r : result) {
			System.out.println(r);
		}
		
		result = n.nextGreaterElement(new int[] {4,1,2}, new int[] {1,2,3,4});
		for(int r : result) {
			System.out.println(r);
		}
		
		result = n.nextGreaterElement(new int[] {1,3,5,2,4}, new int[] {6,5,4,3,2,1,7});
		for(int r : result) {
			System.out.println(r);
		}
		


	}

}
