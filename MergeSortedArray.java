
public class MergeSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		
		if(nums1!=null && nums1.length > 0 && nums2!=null && nums2.length > 0) {
			
			int p1 = m - 1;
			int p2 = n - 1;
			
			for(int p=nums1.length-1;p>=0;p--) {
				
				if(p2 < 0) {
					break;
				}
				
				if(p1>=0 && nums1[p1] > nums2[p2]) {
					nums1[p] = nums1[p1--];
				}
				else {
					nums1[p] = nums2[p2--];
				}
				
			}
			
			
		}
		System.out.println("Test");
	}
	
	public static void main(String []args) {
		MergeSortedArray m = new MergeSortedArray();
		//m.merge(new int[] {1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3);
		//m.merge(new int[] {1}, 1, new int[] {}, 0);
		//m.merge(new int[] {0}, 0, new int[] {1}, 1);
		//m.merge(new int[] {2,0}, 1, new int[] {1}, 1);
		m.merge(new int[] {1,2,4,5,6,0}, 5, new int[] {3}, 1);
	}
	
}
