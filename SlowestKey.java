import java.util.HashMap;
import java.util.Map;

public class SlowestKey {

	public char slowestKey(int[] releaseTimes, String keysPressed) {
		char result = ' ';
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put(keysPressed.charAt(0), releaseTimes[0]);
		
		for(int i=1;i<releaseTimes.length;i++) {
			int timeTaken = releaseTimes[i] - releaseTimes[i-1];
			int currentTimeTaken = map.getOrDefault(keysPressed.charAt(i), 0);
			map.put(keysPressed.charAt(i), Math.max(timeTaken, currentTimeTaken));
		}
		
		int timeTaken = Integer.MIN_VALUE;
		
		for(int i=0;i<releaseTimes.length;i++) {
			if(map.get(keysPressed.charAt(i)) > timeTaken) {
				timeTaken = map.get(keysPressed.charAt(i));
				result = keysPressed.charAt(i);
			}
			else if(map.get(keysPressed.charAt(i)) == timeTaken && keysPressed.charAt(i) > result) {
				result = keysPressed.charAt(i);
			}
		}
		
		return result;

	}
	
	public static void main(String []args) {
		SlowestKey k = new SlowestKey();
		System.out.println(k.slowestKey(new int[] {9,29,49,50}, "cbcd"));
		System.out.println(k.slowestKey(new int[] {12,23,36,46,62}, "spuda"));
		System.out.println(k.slowestKey(new int[] {10,19,20,21,22,32}, "abodzo"));
		System.out.println(k.slowestKey(new int[] {1,2}, "ba"));
		
		//a -> 10-0 = 10
		//b -> 19-10 = 9
		//o -> 20-19 = 1
		//d -> 21-20 = 1
		//z -> 22-21 = 1
		//o -> 32-22 = 10

	}

}
