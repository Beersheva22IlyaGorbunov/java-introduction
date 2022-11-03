
public class SportLotoAppl {
	/**
	 * Application displays out 6 random numbers from 1 to 49
	 * numbers can not be repeated in a sequence of 6 random numbers
	 * without using collections and arrays
	 */
	public static void main(String[] args) {
		long usedNumbers = 0;
		for (int i = 0; i < 6; i++) {
			int tempNumber = getRandomInt(1, 49);
			if (BitOperations.getBitValue(usedNumbers, tempNumber) == 0) {
				usedNumbers = BitOperations.invertBitValue(usedNumbers, tempNumber);
				System.out.print(tempNumber + " ");
			}
		}
	}
	
	public static int getRandomInt(int min, int max) {
		return (int)(min + Math.random() * (max - min + 1));
	}
}
