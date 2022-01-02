
public class LemonadeChange {

	public boolean lemonadeChange(int[] bills) {
		int fives = 0;
		int tens  = 0;
		for(int i=0;i<bills.length;i++) {
			if(bills[i] == 5) {
				fives++;
			}
			else if(bills[i] == 10) {
				if(fives > 0) {
					fives--;
					tens++;
				}
				else {
					return false;
				}
			}
			else if(bills[i] == 20) {
				if(fives >= 3 && tens == 0) {
					fives-=3;
				}
				else if(fives > 0 && tens > 0) {
					fives--;
					tens--;
				}
				else {
					return false;
				}
				
			}
		}
		
		return true;
	}

}
