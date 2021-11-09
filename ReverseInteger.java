
public class ReverseInteger {
	public int reverse(int x) {
		int reverseNumber  = 0;
		while(x != 0) {  //342
			int pop = x % 10;  //2  //4 //3
			x = x / 10; //34  //3 //0
			reverseNumber = reverseNumber * 10 + pop; //2 //20+4=24  //240 + 3 = 243
		}
		return reverseNumber;
	}
}
