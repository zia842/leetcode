
public class PowerOfThree {

	public static boolean powerOfThree(int num) {
		int currentQuotient = num;
		if (currentQuotient == 1) {
			return true;
		}
		while (currentQuotient > 0) {
			currentQuotient = currentQuotient / 3;
			if (currentQuotient == 1) {
				return true;
			}
		}

		return false;
	}

	public static void main(String []args) {
		PowerOfThree p = new PowerOfThree();
		System.out.println(p.powerOfThree(9));
		System.out.println(p.powerOfThree(6));
	}

}
