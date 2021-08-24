public class ZigZagConversion {

	public String convert(String s, int numRows) {
		StringBuilder result = new StringBuilder();
        
        if(s == null || s == "" || s.length() <= 1 || numRows <= 1) {
        	return s;
        }
        
        StringBuilder rows[] = new StringBuilder[Math.min(numRows, s.length())];
        
        for(int i=0;i<rows.length;i++) {
        	rows[i] = new StringBuilder();
        }
        
        boolean flag = false;
        int currentRowNum = 0;
        StringBuilder t = new StringBuilder();
        for(int i=0;i<s.length();i++) {

        	t = rows[currentRowNum];
        	rows[currentRowNum] = t.append(s.charAt(i));
        	
        	if(currentRowNum == 0 || currentRowNum == numRows-1) {
        		flag = !flag;
        	}
        	
        	if(flag) {
        		currentRowNum++;
        	}
        	else {
        		currentRowNum--;
        	}
        }
        
        for(StringBuilder sb : rows) {
        	result.append(sb);
        }
        
        
        return result.toString();
    }
	
	
	public static void main(String []args) {
		ZigZagConversion z = new ZigZagConversion();
		System.out.println(z.convert("PAYPALISHIRING", 3));
		System.out.println(z.convert("PAYPALISHIRING", 4));
		System.out.println(z.convert("PAYPALISHIRING", 5));
		
		System.out.println(z.convert("PAYPALISHIRING", 1));
		System.out.println(z.convert("P", 5));
		System.out.println(z.convert("P", 1));
		System.out.println(z.convert(null, 10));
		System.out.println(z.convert("", 1));
		System.out.println(z.convert("  PAYPALISHIRING", 3));
		System.out.println(z.convert(",AY.ALISHIRING", 3));
	}
	
}
