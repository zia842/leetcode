
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

	public int reverseCorrect(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
			if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
			rev = rev * 10 + pop;
		}
		return rev;
	}
}
