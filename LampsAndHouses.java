import java.util.Arrays;

public class LampsAndHouses {

	public static int getRadius(int[] houses, int[] lamps) {

		Arrays.sort(houses);
		Arrays.sort(lamps);
		
		int i = 0;
		int radius = 0;
		for (int house : houses) {
			while (i < lamps.length - 1 && lamps[i] + lamps[i + 1] <= house * 2) {
				i = i + 1;
			}
			radius = Math.max(radius, Math.abs(lamps[i] - house));
		}
		return radius;
	}
	
	public static void main(String []args) {
		System.out.println(getRadius(new int[] {1,3,4}, new int[] {0,2}));
	}

}
