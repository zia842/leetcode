import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenerateEmailAddress {

	public String solution(String S, String C) {
		// write your code in Java SE 8
		
		if(S!=null && S!="" && S.length() > 0 
				&& C!=null && C!="" && C.length() > 0) {
			
			//Split Name by ;
			String namesArr[] = S.split(";");
			Set<String> emailAddressSet = new HashSet<String>();
			List<String> emailAddressList = new ArrayList<String>();
			Map<String,Integer> emailAddressCount = new HashMap<String,Integer>();
			
			for(String n : namesArr) { 
				String nameArr[] = n.trim().split(" ");
				String firstName = "";
				String lastName = "";
				
				if(nameArr.length == 3) {
					firstName = nameArr[0];
					lastName = nameArr[2];
				}
				else if(nameArr.length == 2) {
					firstName = nameArr[0];
					lastName = nameArr[1];
					
				}
				lastName = lastName.replace("-", "");
				if(lastName.length() > 8) {
					lastName = lastName.substring(0,8);
				}
				
				
				StringBuilder emailAddress = new StringBuilder();
				emailAddress.append(firstName.toLowerCase().trim());
				emailAddress.append(".");
				emailAddress.append(lastName.toLowerCase().trim());
				emailAddress.append("@");
				emailAddress.append(C.trim().toLowerCase());
				emailAddress.append(".com");
				
				int count = emailAddressCount.getOrDefault(firstName+"."+lastName, 0);
				
				//emailAddressSet.add(firstName.toLowerCase().trim()+"." +lastName.toLowerCase().trim()+"@" + C.trim().toLowerCase() +".com");
				if(emailAddressSet.contains(emailAddress.toString())) {
				//  if(count > 0) {
					emailAddress = new StringBuilder();
					emailAddress.append(firstName.toLowerCase().trim());
					emailAddress.append(".");
					emailAddress.append(lastName.toLowerCase().trim());
					count = count + 1;
					if(count == 1) count = 2;
					emailAddress.append(count);
					emailAddress.append("@");
					emailAddress.append(C.trim().toLowerCase());
					emailAddress.append(".com");
					
				}
				
				emailAddressSet.add(emailAddress.toString());
				emailAddressList.add(emailAddress.toString());
				
				emailAddressCount.put(firstName+"."+lastName, count);
			}
			
			StringBuilder result = new StringBuilder();
			/*
			 * for(String r : emailAddressSet) { result.append(r); result.append("; "); }
			 */
			
			
			for(String r : emailAddressList) { result.append(r); result.append("; "); }
			
			
			if(result.length() > 1) {
				result.replace(result.length()-2, result.length(), "");
			}
			
			return result.toString();
		}
		
		return "";
	}
	
	public static void main(String []args) {
		GenerateEmailAddress g = new GenerateEmailAddress();
		System.out.println(g.solution("John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker", "Example"));
	}

}
