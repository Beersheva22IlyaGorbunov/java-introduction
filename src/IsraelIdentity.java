
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
		int controlSum = getControlSum(id);
		
		return controlSum % 10 == 0 ? true : false;
	}
	
	private static int getControlSum(int number) {
		int controlSum = 0;
		int[] idDigits = Numbers.getDigits(number);
		for(int i = 0; i < idDigits.length; i++) {
			if (i % 2 == 0) {
				controlSum += idDigits[i];
			} else {
				controlSum += Numbers.getSumDigits(idDigits[i] * 2);
			}
		}
		return controlSum;
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
		int id = SportLotoAppl.getRandomInt(randomMin, randomMax) * 10;
		
		int controlSum = getControlSum(id / 10);
		id += controlSum % 10 == 0 ? 0 : 10 - controlSum % 10;
		
		return id;
	}
}
