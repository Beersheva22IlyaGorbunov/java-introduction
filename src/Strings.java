
public class Strings {
	/**
	 * 
	 * @param str
	 * @param anagram
	 * @return true if str2 is an anagram of str1
	 * 
	 */
	public static boolean isAnagram(String str1, String str2) {
		boolean result = true;
		char[] str1Arr = str1.toCharArray();
		if (str1Arr.length == str2.length()) {
			char[] str2Arr = str2.toCharArray();
			int[] helper = new int[256];
			for (int i = 0; i < str1Arr.length; i++) {
				helper[str1Arr[i]]++;
				helper[str2Arr[i]]--;
			}
			int j = 0;
			while (j < helper.length && result) {
				if (helper[j] != 0) {
					result = false;
				}
				j++;
			}
		} else {
			result = false;
		}
		return result;
	}
	/**
	 * 
	 * @param strArr which would be sorted by this method
	 */
	public static void sortStringNumbers(String[] strArr) {
		int helperLength = Byte.MAX_VALUE - Byte.MIN_VALUE;
		int[] helper = new int[helperLength + 1];
		for (int i = 0; i < strArr.length; i++) {
			byte number = Byte.parseByte(strArr[i]);
			helper[number + 128] ++ ;
		}
		int arrayIndex = 0;
		for (int j = 0; j < helper.length; j++) {
			for (int m = 0; m < helper[j]; m++) {
				strArr[arrayIndex] = Byte.toString((byte) (j - 128));
				arrayIndex ++;
			}
		}
	}
}
