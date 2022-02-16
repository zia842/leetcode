import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubDomainVisitCount {

	public List<String> subdomainVisits(String[] cpdomains) {
		Map<String, Integer> counts = new HashMap<String, Integer>();
		for (String domain: cpdomains) {
			String[] cpinfo = domain.split("\\s+"); //Split by Space
			String[] frags = cpinfo[1].split("\\."); //Split by .
			int count = Integer.valueOf(cpinfo[0]);
			String cur = "";
			for (int i = frags.length - 1; i >= 0; --i) { //Go Reverse
				cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
				counts.put(cur, counts.getOrDefault(cur, 0) + count);
			}
		}

		List<String> result = new ArrayList<String>();
		for (String dom: counts.keySet())
			result.add("" + counts.get(dom) + " " + dom);
		
		return result;
	}
	
	public static void main(String []args) {
		SubDomainVisitCount s = new SubDomainVisitCount();
		System.out.println(s.subdomainVisits(new String[] {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
		
	}

}
