import java.util.HashSet;
import java.util.Set;

public class DollarSignDeletion {
	
	public boolean isDollarDeleteEqual(String []str) {
		Set<String> removedDollar = new HashSet<String>();
		if(str!=null && str.length > 0) {
			for(String s : str) {
				int i = 0;
				StringBuilder sb = new StringBuilder(s);
				while(i<sb.length()) {
					if(sb.charAt(i) == '$') {
						if(i-1 >= 0) {
							sb.deleteCharAt(i-1);
							sb.deleteCharAt(i-1);
							i = 0; //Reset
							continue;
						}
					}
					i++;
				}
				removedDollar.add(sb.toString());
				if(removedDollar.size() > 1) {
					return false;
				}
			}
		}
		
		return removedDollar.size() == 1;
	}
	
	public static void main(String []args) {
		DollarSignDeletion d = new DollarSignDeletion();
		System.out.println(d.isDollarDeleteEqual(new String[] {"f$st", "st"}));
		System.out.println(d.isDollarDeleteEqual(new String[] {"ab$$", "c$d$"}));
		System.out.println(d.isDollarDeleteEqual(new String[] {"a90$n$c$se", "a90n$cse"}));
		System.out.println(d.isDollarDeleteEqual(new String[] {"f$ec", "ec"}));
		System.out.println(d.isDollarDeleteEqual(new String[] {"b$$p", "$b$p"}));
	}

}
