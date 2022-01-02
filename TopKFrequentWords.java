import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentWords {

	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> wordCountMap = new HashMap<String, Integer>();
		List<String> resultList = new ArrayList<String>();

		for(String s : words) {
			Integer count = wordCountMap.getOrDefault(s, 0);
			wordCountMap.put(s, count+1);
		}

		List<String> list = new ArrayList<>(wordCountMap.keySet());
		//Sort based on the frequency 
		Collections.sort( list , new Comparator<String>(){
			public int compare( String x, String y ){
				if(wordCountMap.get(x) == wordCountMap.get(y))
					return x.compareTo( y );
				else
					return (wordCountMap.get(y) - wordCountMap.get(x));
			}
		});

		for(String s:list){ //Add k elements till it is 0
			resultList.add(s);
			k--;
			if(k==0)
				break;
		}

		return resultList;

	}

	public static void main(String []args) {
		TopKFrequentWords top = new TopKFrequentWords();
		System.out.println(top.topKFrequent(new String[] {"i","love","leetcode","i","love","coding"}, 2));
		System.out.println(top.topKFrequent(new String[] {"the","day","is","sunny","the","the","the","sunny","is","is"}, 4));
	}

}
