
public class MedianTwoSortedArrays 
{
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
		double median = 0;
		int result[] = merge(nums1, nums2);
		if(result!=null && result.length > 0) {
			int middle = result.length / 2;
			median = result.length%2 == 0 ?( (double)(result[middle-1] + result[middle]) / 2) : result[middle];
		}
		return median;
		
    }
	
	public static int[] merge(int[] nums1, int[] nums2){
		int sizeFirstArr = nums1!=null && nums1.length > 0 ? nums1.length : 0;
		int sizeSecondArr = nums2!=null && nums2.length > 0 ? nums2.length : 0;
		int []result = new int[sizeFirstArr + sizeSecondArr];
		int k = 0;
		
		if(nums1!=null && nums1.length > 0 && nums2!=null && nums2.length > 0) {
			
			int i = 0; //nums1
			int j = 0; //nums2
			
			while(i < sizeFirstArr && j < sizeSecondArr) {
				if(nums1[i] < nums2[j]) {
					result[k++] = nums1[i++]; 
				}
				else 
				{
					result[k++] = nums2[j++]; 
				}
			}
			
			//Copy Remaining Elements
			while(i < sizeFirstArr) {
				result[k++] = nums1[i++]; 
			}
			
			while(j < sizeSecondArr) {
				result[k++] = nums2[j++]; 
			}
			
			
		}
		else 
		{   //Either Nums1 is null or Nums2 is null
			if(nums1!=null && nums1.length > 0) {
				return nums1;
			}
			if(nums2!=null && nums2.length > 0) {
				return nums2;
			}
		}
		
		
		return result;
	}
	
	
	public static void main(String []args) {
		
		MedianTwoSortedArrays m = new MedianTwoSortedArrays();
		System.out.println(m.findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
		System.out.println(m.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
		System.out.println(m.findMedianSortedArrays(new int[]{0,0}, new int[]{0,0}));
		System.out.println(m.findMedianSortedArrays(new int[]{}, new int[]{1}));
		System.out.println(m.findMedianSortedArrays(new int[]{2}, new int[]{}));
	}

}
