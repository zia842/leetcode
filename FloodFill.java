/**
 * 733. Flood Fill
 * 
 * An image is represented by an m x n integer grid image where 
 * image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor. 
You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally 
to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally 
to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.

Return the modified image after performing the flood fill.
 * @author zia84
 *
 */
public class FloodFill {

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if(image!=null && image.length > 0) {
			int oldColor = image[sr][sc];
			changeColorDfs(image, sr, sc, oldColor, newColor);
		}
		return image;
		
	}
	
	public void changeColorDfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
		if(sr>=0 && sr < image.length && sc >=0 && sc < image[0].length) {
			if(image[sr][sc] == oldColor && oldColor != newColor) {
				image[sr][sc] = newColor;
				changeColorDfs(image,sr+1,sc,oldColor,newColor);
				changeColorDfs(image,sr-1,sc,oldColor,newColor);
				changeColorDfs(image,sr,sc+1,oldColor,newColor);
				changeColorDfs(image,sr,sc-1,oldColor,newColor);
			}
		}
	}
	
	public static void main(String []args) {
		
		FloodFill f = new FloodFill();
		int[][] input = new int[][] {
			{1,1,1},
			{1,1,0},
			{1,0,1}
		};
		f.floodFill(input, 1, 1, 2);
		System.out.println();
		
	}

}
