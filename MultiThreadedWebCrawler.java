import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadedWebCrawler {

	private AtomicInteger counter = new AtomicInteger();
	private ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	private final Set<String> visited = Collections.synchronizedSet(new HashSet<>());

	public List<String> crawl(String startUrl, HtmlParser htmlParser) {
		String[] split = startUrl.split("/");
		String domain = split[0] + "//" + split[2];
		visited.add(startUrl);
		Task starter = new Task(startUrl, domain, htmlParser);
		executor.execute(starter);
		counter.set(1);
		while(counter.get() > 0) {
			try {
				Thread.sleep(10);
				//executor.awaitTermination(0, TimeUnit.SECONDS);
			} catch(Exception e) {

			}
		}

		executor.shutdownNow();
		return new ArrayList(visited);
	}
	
	class Task implements Runnable {
		String domain;
		HtmlParser parser;
		String startUrl;
		Task(String startUrl, String domain, HtmlParser parser) {
			this.startUrl = startUrl;
			this.domain = domain;
			this.parser = parser;
		}

		public void run() {
			for(String next: parser.getUrls(startUrl)) {
				if(!next.startsWith(domain) || visited.contains(next)) continue;
				counter.incrementAndGet();
				visited.add(next);
				executor.execute(new Task(next, domain, parser));
			}
			counter.decrementAndGet();
		}
	}

}


