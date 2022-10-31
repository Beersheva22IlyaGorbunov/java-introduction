
/**
 * 
 * Right nBit value [0, 63]
 * All methods will return -1 in the case of wrong nBit value.
 *
 */
public class BitOperations {
	/**
	 * 
	 * @param number - any number
	 * @param nBit - number of bit
	 * @return value of bit with number nBit
	 */
	static public int getBitValue(long number, int nBit) {
		//TODO
		int result = -1;
		if (checkNbit(nBit)) {
			long mask = getMask(nBit); // all bits are 0 except bit number nBit
			if ((number & mask) != 0) {
				result = 1;
			} else {
				result = 0;
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param nBit - number of bit
	 * @return true if number of bit is valid
	 */
	private static boolean checkNbit(int nBit) {
		return nBit < 64 && nBit >= 0;
	}
	
	/**
	 * 
	 * @param nBit - number of bit
	 * @return mask where all bits are 0 except bit number nBit
	 */
	static private long getMask(int nBit) {
		return 1L << nBit;
	}

	/**
	 * 
	 * @param number - any number
	 * @param nBit - number of bit which will be changed
	 * @param value - true/false (0 or 1) of bit which will be changed
	 * @return changed number with nBit = value
	 */
	static public long setBitValue(long number, int nBit, boolean value) {
		//TODO
		long result = -1;
		long mask = getMask(nBit); // all bits are 0 except bit number nBit
		if (checkNbit(nBit)) {
			if (value) {
				result = number | mask;
			} else {
				result = number & ~mask;
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param number - any number
	 * @param nBit - bit's number
	 * @return new number in which nBit will be inverse
	 */
	static public long inverseBitValue(long number, int nBit) {
		//TODO
		long result = -1;
		if (checkNbit(nBit)) {
			long mask = getMask(nBit);// all bits are 0 except bit number nBit
			result = number ^ mask;
		}
		return result;
	}
}
