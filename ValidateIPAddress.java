import java.util.regex.Pattern;

public class ValidateIPAddress {

	/**
	 * [0-9]        - Represents 0-9 Single Digit
	 * [1-9][0-9]   - Represents 10-99 Double Digit
	 * 1[0-9][0-9]  - Represents 100-199 Three Digit
	 * 25[0-5]      - Represents 250-255 
	 */
	String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";

	/**
	 * Example IPV4 - 192.168.1.1
	 * {3} - Represents example 192.168.1 (Because Dot is repeated thrice)
	 * chunkIPv4 - Represents - 1 
	 */
	Pattern pattenIPv4 =
			Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$"); 

	/**
	 * Example IPV6 - 2001:0db8:85a3:0000:0000:8a2e:0370:7334
	 * Can be 0-9, a-f, A-F max of 4 {1, 4}
	 */
	String chunkIPv6 = "([0-9a-fA-F]{1,4})"; 

	/**
	 * {7} - Colons 
	 */
	Pattern pattenIPv6 =
			Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");


	public String validIPAddress(String queryIP) {
		if (pattenIPv4.matcher(queryIP).matches()) return "IPv4";
		return (pattenIPv6.matcher(queryIP).matches()) ? "IPv6" : "Neither";
	}
	
	public static void main(String []args) {
		ValidateIPAddress v = new ValidateIPAddress();
		System.out.println(v.validIPAddress("192.168.1.1")); //Valid
		System.out.println(v.validIPAddress("192.168.1.00")); //Invalid
		System.out.println(v.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334")); //Valid
		System.out.println(v.validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334")); //Invalid
	}

}
