
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
		if (getNdigits(number) == 6) {
			int leftPartSum = 0;
			int rightPartSum = 0;
			for (int i = 1; i <= 100000; i *= 10) {
				if (i <= 100) {
					rightPartSum += number / i % 10;
				} else {
					leftPartSum += number / i % 10;
				}
			}
			if (leftPartSum == rightPartSum) {
				isHappy = true;
			}
		}
		return isHappy ;
	}
}