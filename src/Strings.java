
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
		if (str1.length() == str2.length()) {
			int[] helper = fillHelper(str1, str2);
			result = checkHelper(result, helper);
		} else {
			result = false;
		}
		return result;
	}

	private static int[] fillHelper(String str1, String str2) {
		int[] helper = new int[Byte.MAX_VALUE];
		for (int i = 0; i < str1.length(); i++) {
			helper[str1.charAt(i)]++;
			helper[str2.charAt(i)]--;
		}
		return helper;
	}
	
	private static boolean checkHelper(boolean result, int[] helper) {
		int j = 0;
		while (j < helper.length && result) {
			if (helper[j] != 0) {
				result = false;
			}
			j++;
		}
		return result;
	}
	/**
	 * 
	 * @param strArr which would be sorted by this method
	 */
	public static void sortStringNumbers(String[] strArr) {
		int offset = Byte.MAX_VALUE + 1;
		int[] helper = new int[offset * 2];
		fillHelper(strArr, offset, helper);
		sortFromHelper(strArr, offset, helper);
	}

	private static void fillHelper(String[] strArr, int offset, int[] helper) {
		for (int i = 0; i < strArr.length; i++) {
			int number = Integer.parseInt(strArr[i]);
			helper[number + offset] ++ ;
		}
	}

	private static void sortFromHelper(String[] strArr, int offset, int[] helper) {
		int arrayIndex = 0;
		for (int j = 0; j < helper.length; j++) {
			for (int m = 0; m < helper[j]; m++) {
				strArr[arrayIndex] = Byte.toString((byte) (j - offset));
				arrayIndex ++;
			}
		}
	}
	
	public static String javaNameExp() {
		return "[a-zA-Z$][\\w$]*||_[\\w$_]+";
	}
	
	public static String ipv4Octet() {
		return "([\\d]{1,2}|([0-1]|2[0-4])[\\d]{1,2}|25[0-5])";
	}
	
	public static String ipv4() {
		return "(" + ipv4Octet() + "\\.){3}" + ipv4Octet();
	}
}
