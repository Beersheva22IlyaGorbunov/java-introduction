
public class IsraelIdentity {
	// ID_LENGTH can be equal to every odd number more than 1
	public static final int ID_LENGTH = 9;
/**
 * 
 * @param id
 * @return true for right id otherwise false
 * control sum should be multiple on 10 (sum % 10 == 0)
 * for even indexes digit as is
 * for odd indexes digit = digit * 2, if > 9 calculate sum of two digits
 * example 123456782 => 1 + 4 + 3 + 8 + 5 + 3 ( 6 * 2 = 12, 1 + 2 = 3) + 7 + 7 + 2 = 40
 * 
 */
	public static boolean verify(int id) {
		int[] digits = Numbers.getDigits(id);
		boolean res = false;
		
		if (ID_LENGTH == digits.length) {
			int controlSum = getControlSum(digits);
			res = controlSum % 10 == 0 ? true : false;
		}
		
		return res;
	}
	
	private static int getControlSum(int[] digits) {
		return sumEvenIndexes(digits) + sumOddIndexes(digits);
	}
	
	private static int sumOddIndexes(int[] digits) {
		int sum = 0;
		for(int i = 0; i < digits.length; i += 2) {
			sum += digits[i];
		}
		return sum;
	}

	private static int sumEvenIndexes(int[] digits) {
		int sum = 0;
		for(int i = 1; i < digits.length; i += 2) {
			sum += Numbers.getSumDigits(digits[i] * 2);
		}
		return sum;
	}

/**
 * 
 * @return random number of 9 digits, which matched right IsraelId
 * cannot be 0 on first position
 * cycle not more than 9 iterations
 */
	public static int generateRandomId() {		
		int randomMin = (int) Math.pow(10, ID_LENGTH - 2);
		int randomMax = (int) Math.pow(10, ID_LENGTH - 1);
		int res = (int) Numbers.getRandomNumber(randomMin, randomMax);
		
		int controlSum = getControlSum(Numbers.getDigits(res));
		int lastDigit = getLastDigit(controlSum);
		
		res = res * 10 + lastDigit;
		
		return res;
	}
	
	private static int getLastDigit(int controlSum) {
		return controlSum % 10 == 0 ? 0 : 10 - controlSum % 10;
	}
}
