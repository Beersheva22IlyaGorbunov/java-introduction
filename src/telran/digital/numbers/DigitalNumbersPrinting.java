package telran.digital.numbers;

public class DigitalNumbersPrinting {
	private static final String SYMBOL = "*";
	private static final int MARGIN = 4;

	public static void displayDigitalNumber(int number, int offset, int height, int width) {
		String[] res = sizesAreValid(width, height) ? getStringsToPrint(number, offset, height, width) : new String[0];

		displayStrings(res);
	}
	
	private static boolean sizesAreValid(int width, int height) {
		return (width > 2 && height > 4) ? true : false;
	}

	public static String[] getStringsToPrint(int number, int offset, int height, int width) {
		String[] res = new String[height];
		int[] digits = getDigits(number);
		String[][] cachedDigits = new String[10][];

		String[] firstDigit = printDigit(digits[0], offset, height, width);
		cachedDigits[digits[0]] = createFirstDigit(res, firstDigit, offset);
		
		for (int i = 1; i < digits.length; i++) {
			String[] printableDigit = new String[digits.length];
			if (cachedDigits[digits[i]] == null) {
				printableDigit = printDigit(digits[i], offset, height, width);
				cachedDigits[digits[i]] = printableDigit;
			} else {
				printableDigit = cachedDigits[digits[i]];
			}
			joinDigit(res, printableDigit);

		}
		return res;
	}

	private static String[] createFirstDigit(String[] res, String[] firstDigit, int offset) {
		for (int j = 0; j < res.length; j++) {
			res[j] = " ".repeat(offset) + firstDigit[j];
		}
		return res;
	}

	private static void joinDigit(String[] res, String[] currentDigit) {
		for (int j = 0; j < res.length; j++) {
			res[j] += currentDigit[j];
		}
	}

	private static String[] printDigit(int digit, int offset, int height, int width) {
		switch (digit) {
			case 0: return zero(width, height);
			case 1: return one(width, height);
			case 2: return two(width, height);
			case 3: return three(width, height);
			case 4: return four(width, height);
			case 5: return five(width, height);
			case 6: return  six(width, height);
			case 7: return  seven(width, height);
			case 8: return  eight(width, height);
			case 9: return  nine(width, height);
		}
		return null;
	}

	public static String line(int length) {
		return " ".repeat(MARGIN) + SYMBOL.repeat(length);
	}

	public static String[] verticalLine(int padding, int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(padding + MARGIN) + SYMBOL + " ".repeat(width - padding - 1);
		}
		return res;
	}
	
	public static String[] twoVerticalLines(int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(MARGIN) + SYMBOL + " ".repeat(width - 2) + SYMBOL;
		}
		return res;
	}

	private static String[] zero(int width, int height) {
		String[] res = new String[height];
		res = twoVerticalLines(width, height);
		res[0] = line(width);
		res[height - 1] = line(width);
		return res;
	}

	private static String[] one(int width, int height) {
		return verticalLine(width - 1, width, height);
	}

	private static String[] two(int width, int height) {
		String[] res = new String[height];
		int vertCenter = (height - 1) / 2;

		String[] rightVerticalLine = verticalLine(width - 1, width, vertCenter);
		System.arraycopy(rightVerticalLine, 0, res, 0, vertCenter);

		String[] leftVerticalLine = verticalLine(0, width, vertCenter);
		System.arraycopy(leftVerticalLine, 0, res, vertCenter + 1, vertCenter);

		res[0] = line(width);
		res[vertCenter] = line(width);
		res[height - 1] = line(width);
		return res;
	}

	private static String[] three(int width, int height) {
		String[] res = new String[height];
		int vertCenter = (height - 1) / 2;
		res = verticalLine(width - 1, width, height);
		res[0] = line(width);
		res[vertCenter] = line(width);
		res[height - 1] = line(width);
		return res;
	}

	private static String[] four(int width, int height) {
		String[] res = new String[height];
		int vertCenter = (height - 1) / 2;

		String[] topVerticalLines = twoVerticalLines(width, vertCenter);
		System.arraycopy(topVerticalLines, 0, res, 0, vertCenter);

		String[] bottomVerticalLine = verticalLine(width - 1, width, height - vertCenter);
		System.arraycopy(bottomVerticalLine, 0, res, vertCenter, height - vertCenter);
		res[vertCenter] = line(width);
		return res;
	}

	private static String[] five(int width, int height) {
		String[] res = eight(width, height);
		int vertCenter = (height - 1) / 2;

		String[] topVerticalLine = verticalLine(0, width, vertCenter);
		System.arraycopy(topVerticalLine, 0, res, 0, vertCenter);

		String[] bottomVerticalLine = verticalLine(width - 1, width, vertCenter);
		System.arraycopy(bottomVerticalLine, 0, res, vertCenter + 1, vertCenter);

		res[0] = line(width);
		res[vertCenter] = line(width);
		res[height - 1] = line(width);

		return res;
	}

	private static String[] six(int width, int height) {
		String[] res = five(width, height);
		int vertCenter = (height - 1) / 2;

		String[] topVerticalLine = verticalLine(0, width, vertCenter);
		System.arraycopy(topVerticalLine, 0, res, 0, vertCenter);

		String[] bottomVerticalLines = twoVerticalLines(width, vertCenter);
		System.arraycopy(bottomVerticalLines, 0, res, vertCenter + 1, vertCenter);
		res[0] = line(width);
		res[vertCenter] = line(width);
		res[height - 1] = line(width);
		return res;
	}

	private static String[] seven(int width, int height) {
		String[] res = one(width, height);
		res[0] = line(width);
		return res;
	}

	private static String[] eight(int width, int height) {
		String[] res = zero(width, height);
		int vertCenter = (height - 1) / 2;
		res[vertCenter] = line(width);
		return res;
	}

	private static String[] nine(int width, int height) {
		String[] res = three(width, height);
		int vertCenter = (height - 1) / 2;

		String[] topVerticalLines = twoVerticalLines(width, vertCenter);
		System.arraycopy(topVerticalLines, 1, res, 1, vertCenter - 1);

		return res;
	}

	public static int getNdigits(long number) {
		int result = 0;
		do {
			number /= 10;
			result++;
		} while (number != 0);
		return result;
	}

	private static int[] getDigits(int number) {
		int result[] = new int[getNdigits(number)];
		for (int i = result.length - 1; i >= 0; i--) {
			result[i] = number % 10;
			number /= 10;
		}
		return result;
	}

	public static void displayStrings(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
	}
}
