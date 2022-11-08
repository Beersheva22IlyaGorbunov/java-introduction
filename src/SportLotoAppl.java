
public class SportLotoAppl {
	/**
	 * Application displays out 6 random numbers from 1 to 49
	 * numbers can not be repeated in a sequence of 6 random numbers
	 * without using collections and arrays
	 */
	public static long usedNumbers = 0;
	public static void main(String[] args) {
		for (int i = 0; i < 6; i++) {
			System.out.print(getUniqueInt(1,49) + " ");
		}
	}
	
	private static int getUniqueInt(int min, int max) {
		int tempNumber = 0;
		do {
			tempNumber = getRandomInt(min, max);	
		} while (BitOperations.getBitValue(usedNumbers, tempNumber) == 1);
		usedNumbers = BitOperations.invertBitValue(usedNumbers, tempNumber);
		return tempNumber;
	}
	
	public static int getRandomInt(int min, int max) {
		return (int)(min + Math.random() * (max - min + 1));
	}
}
