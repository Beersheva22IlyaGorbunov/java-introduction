
public class Numbers {
	static public int getNdigits(long number) {
		int result = 0;
		do {
			number /= 10;
			result++;
		} while (number != 0);
		return result;
	}
	/**
	 * 
	 * @param number
	 * @return true only if number comprises of 6 digits
	 * and sum of first three digits equals the sum of last three digits
	 */
	static public boolean isHappyNumber(int number) {
		boolean isHappy = false;
		number = Math.abs(number);
		if (getNdigits(number) % 2 == 0) {
			int halfNumberDivider = (int) Math.pow(10, getNdigits(number) / 2);
			int leftPartSum = getSumDigits(number / halfNumberDivider);
			int rightPartSum = getSumDigits(number % halfNumberDivider);
			if (leftPartSum == rightPartSum) {
				isHappy = true;
			}
		}
		return isHappy ;
	}
	
	static private int getSumDigits(int number) {
		int result = 0;
		do {
			result += number % 10;
			number /= 10;
		} while (number != 0);
		return result;
	}
	
	public static int[] getDigits(int number) {
		int result[] = new int[getNdigits(number)];
		for (int i = result.length - 1; i >= 0; i--) { 
			result[i] = number % 10;
			number /= 10;
		}
		return result;
	}
	
	public static int getNumberFromDigits(int[] digits) {
		int res = 0;
		for (int i = 0; i < digits.length; i++) {
			res = res * 10 + digits[i];
		}
		return res;
	}
}