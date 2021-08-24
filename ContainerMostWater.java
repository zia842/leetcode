
public class ContainerMostWater {

	public int maxArea(int[] height) {
        int maxArea = 0;
        
        if(height!=null && height.length > 0) {
        	
        	int i = 0; //Left Pointer
        	int j = height.length - 1; //Right Pointer
        	
        	while(i < j) { //Do this as long as left < right
        		
        		int minHeight = Math.min(height[i], height[j]); //Consider minimum height of both boundaries
        		
        		maxArea = Math.max(maxArea, minHeight * (j-i)); //Calculate Area and always store max
        		
        		if(height[i] < height[j]) {
        			i++;
        		}
        		else {
        			j--;
        		}
        		
        	}
        	
        }
        
        return maxArea;
    }
	
	public static void main(String []args) {
		ContainerMostWater c = new ContainerMostWater();
		System.out.println(c.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
		System.out.println(c.maxArea(new int[] {1,1}));
		System.out.println(c.maxArea(new int[] {4,3,2,1,4}));
		System.out.println(c.maxArea(new int[] {1,2,1}));
	}
}
