import java.util.Collections;
import java.util.HashMap;

public class MaxNoOfOccurSubStr {

	public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
		int i=0;
		int start=0;
		HashMap<String, Integer> res=new HashMap<>();
		HashMap<Character, Integer> hm = new HashMap<>();
		//MaxSize doesn't matter
		while(i<s.length()) {
			char ch = s.charAt(i);
			hm.put(ch, hm.getOrDefault(ch, 0)+1);
			if(i-start+1==minSize) {
				if(hm.size()<=maxLetters) {
					String str = s.substring(start,i+1);
					res.put(str, res.getOrDefault(str, 0)+1);
				}
				if(hm.get(s.charAt(start))-1==0) //If decreasing count leads to Zero remove element
					hm.remove(s.charAt(start));
				else
					hm.put(s.charAt(start),hm.get(s.charAt(start))-1);
				start++; //For Sliding 
			}
			i++; //Keep moving pointer
		}
		return res.size()==0?0:Collections.max(res.values());
	}

	public static void main(String []args) {
		MaxNoOfOccurSubStr m = new MaxNoOfOccurSubStr();
		System.out.println(m.maxFreq("aababcaab", 2, 3, 4));
	}

}
