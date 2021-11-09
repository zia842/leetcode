/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it can trap after raining.
 * 
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped.

Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9

Constraints:

    n == height.length
    1 <= n <= 2 * 104
    0 <= height[i] <= 105


 * 
 * @author zia84
 *
 */

/**
 * Observations :
 * 
 * 1. Water Not Trapped if numbers are Ascending 1,2,3,4,5 OR Descending 5,4,3,2,1
 * 2. Water Not Trapped if all numbers are same that means its at same level 5,5,5,5 Pockets can't be formed
 * 3. Minimum 3 indexes are are required to trap water
 * 4. Water Level is Minimum of Max Left, Max Right
 * 
 * @author zia84
 *
 */

public class TrappingRainWater {

	
	public int trap(int[] height) {
		int trappedRainWater = 0;

		if(height!=null && height.length > 2) { //If height < 3 no water can be trapped
			
			
			if(isSorted(height) || isSortedDesc(height)) { //If Heights are increasing or decreasing no water can be trapped
				return trappedRainWater;
			}
			
			int globalMaxLeft = height[0];
			int globalMaxRight = height[height.length-1];
			int waterLevelLeftArr[] = new int[height.length];
			int waterLevelRightArr[] = new int[height.length];
			
			for(int i=1;i<height.length;i++) {
				waterLevelLeftArr[i] = Math.max(height[i-1], globalMaxLeft);
				globalMaxLeft = waterLevelLeftArr[i];
			}
			
			for(int i=height.length-2;i>=0;i--) {
				waterLevelRightArr[i] = Math.max(height[i+1], globalMaxRight);
				globalMaxRight = waterLevelRightArr[i];
			}
			
			for(int i=1;i<height.length-1;i++) {
				int waterlevel = Math.min(waterLevelLeftArr[i], waterLevelRightArr[i]);
				
				if(waterLevelLeftArr[i] == 0 || waterLevelRightArr[i] == 0 || height[i] >= waterlevel) { //If water level at left is zero or at right is zero or current height is > water level water cannot be trapped
					continue;
				}
				trappedRainWater += (waterlevel - height[i]) * 1;
			}
			
			//System.out.println(trappedRainWater);
			
		}
		
		return trappedRainWater;
    }
	
	boolean isSorted(int[] array) {
	    for (int i = 0; i < array.length - 1; i++) {
	        if (array[i] < array[i + 1])
	            return false;
	    }
	    return true;
	}
	
	boolean isSortedDesc(int[] array) {
	    for (int i = 0; i < array.length - 1; i++) {
	        if (array[i] > array[i + 1])
	            return false;
	    }
	    return true;
	}
	
	public static void main(String []args) {
		TrappingRainWater t = new TrappingRainWater();
		t.trap(new int []{4,2,0,3,2,5});
		t.trap(new int []{0,1,0,2,1,0,1,3,2,1,2,1});
		
		System.out.println(t.isSorted(new int []{5,4,3,2,1}));
		System.out.println(t.isSorted(new int []{4,2,0,3,2,5}));
	}
	
}
