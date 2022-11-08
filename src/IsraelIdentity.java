import java.util.Arrays;

public class IsraelIdentity {
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
		int controlSum = 0;
		int[] idDigits = Numbers.getDigits(id);
		for(int i = 0; i < idDigits.length; i++) {
			if (i % 2 == 0) {
				controlSum += idDigits[i];
			} else {
				controlSum += getDoubledOdd(idDigits[i] * 2);
			}
		}
		return controlSum % 10 == 0 ? true : false;
	}
	
	public static int getDoubledOdd(int number) {
		int result = 0;
		if (number > 9) {
			result = number % 10 + number / 10;
		} else {
			result = number;
		}
		return result;
	}
/**
 * 
 * @return random number of 9 digits, which matched right IsraelId
 * cannot be 0 on first position
 * cycle not more than 9 iterations
 */
	public static int generateRandomId() {
		int[] idArr = new int[9];
		int controlSum = 0;
		
		idArr[0] = SportLotoAppl.getRandomInt(1, 9);
		controlSum += idArr[0];
		
		for (int i = 1; i < 8; i ++) {
			idArr[i] = SportLotoAppl.getRandomInt(0, 9);
			if (i % 2 == 0) {
				controlSum += idArr[i];
			} else {
				controlSum += getDoubledOdd(idArr[i] * 2);
			}
		}
		idArr[idArr.length - 1] = controlSum % 10 == 0 ? 0 : 10 - controlSum % 10;
		return Numbers.getNumberFromDigits(idArr);
	}
}
