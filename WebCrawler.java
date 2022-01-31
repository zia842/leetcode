import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WebCrawler {

	public List<String> crawl(String startUrl, HtmlParser htmlParser) {
		Set<String> result = new HashSet<>();
		result.add(startUrl);
		String hostName = getHostName(startUrl);
		Queue<String> queue = new ArrayDeque<>();
		queue.offer(startUrl);
		while(!queue.isEmpty()) {
			for(String html : htmlParser.getUrls(queue.poll())) {
				if(html.startsWith(hostName) && result.add(html))
					queue.offer(html);
			}

		}
		return new ArrayList<String>(result);

	}

	public String getHostName(String startUrl) {
		String []str = startUrl.split("/");
		return new StringBuilder().append(str[0]).append("//").append(str[2]).toString();
	}

	public static void main(String []args) {
		List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
		/*
		 * listOfNumbers.stream().forEach(number -> System.out.println(number + " " +
		 * Thread.currentThread().getName()) );
		 */
		listOfNumbers.stream().sorted().distinct().limit(3).forEach(System.out::println);
		
		listOfNumbers.parallelStream().forEach(number ->
			System.out.println(number + " " + Thread.currentThread().getName())
		);
	}
}


/**
 * Dummy Method to test it out
 * @author zia84
 *
 */
class HtmlParser{
	public List<String> getUrls(String hostName) {
		return new ArrayList<String>();
	}
}
