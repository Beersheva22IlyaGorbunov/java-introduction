package telran.digital.numbers;

public class DigitalNumbersPrinting {
	private static final String SYMBOL = "*";

	public static void displayDigitalNumber(int number, int offset, int height, int width, boolean adaptive) {
		height = checkHeight(height);
		width = checkWidth(height, width);
		offset = checkOffset(offset, width);
		
		if (adaptive) {
			width = adaptWidth(height, width);
			offset = adaptOffset(offset, width);
		}
		
		String[] res = getStringsToPrint(number, offset, height, width);

		displayStrings(res);
	}
	
	public static void displayDigitalNumber(int number, int offset, int height, int width) {
		height = checkHeight(height);
		width = checkWidth(height, width);
		offset = checkOffset(offset, width);
		
		width = adaptWidth(height, width);
		offset = adaptOffset(offset, width);
		
		String[] res = getStringsToPrint(number, offset, height, width);

		displayStrings(res);
	}

	private static String[] getStringsToPrint(int number, int offset, int height, int width) {
		String[] res = new String[height];
		int[] digits = getDigits(number);

		String[] firstDigit = printDigit(digits[0], offset, height, width);
		for (int j = 0; j < res.length; j++) {
			res[j] = firstDigit[j];
		}

		for (int i = 1; i < digits.length; i++) {
			String[] currentDigit = printDigit(digits[i], offset, height, width);
			for (int j = 0; j < res.length; j++) {
				res[j] += currentDigit[j];
			}
		}
		return res;
	}

	private static int checkHeight(int height) {
		if (height < 5) {
			height = 5;
		}

		if (height % 2 != 1) {
			height++;
		}
		return height;
	}

	private static int checkWidth(int height, int width) {
		if (width < 3) {
			width = 3;
		}
		return width;
	}

	private static int checkOffset(int offset, int width) {
		if (offset < 1) {
			offset = 1;
		}
		return offset;
	}
	
	private static int adaptWidth(int height, int width) {
		if (height / width > 2) {
			width = height / 3 + 2;
		}
		if (width > height) {
			width = height;
		}
		return width;
	}

	private static int adaptOffset(int offset, int width) {
		if (offset < width / 3) {
			offset = width / 3;
		}
		if (offset > width) {
			offset = width;
		}
		return offset;
	}

	private static String[] printDigit(int digit, int offset, int height, int width) {
		String[] res = new String[height];
		switch (digit) {
		case 0:
			res = zero(offset, width, height);
			break;
		case 1:
			res = one(offset, width, height);
			break;
		case 2:
			res = two(offset, width, height);
			break;
		case 3:
			res = three(offset, width, height);
			break;
		case 4:
			res = four(offset, width, height);
			break;
		case 5:
			res = five(offset, width, height);
			break;
		case 6:
			res = six(offset, width, height);
			break;
		case 7:
			res = seven(offset, width, height);
			break;
		case 8:
			res = eight(offset, width, height);
			break;
		case 9:
			res = nine(offset, width, height);
			break;
		default:
			res = null;
		}
		return res;
	}

	public static String line(int offset, int length) {
		return " ".repeat(offset) + SYMBOL.repeat(length);
	}

	public static String[] verticalLine(int offset, int fullWidth, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(fullWidth - offset - 1);
		}
		return res;
	}

	public static String[] twoVerticalLines(int offset, int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 2) + SYMBOL;
		}
		return res;
	}

	private static String[] zero(int offset, int width, int height) {
		String[] res = new String[height];
		res = twoVerticalLines(offset, width, height);
		res[0] = line(offset, width);
		res[height - 1] = line(offset, width);
		return res;
	}

	private static String[] one(int offset, int width, int height) {
		return verticalLine(offset + width - 1, width + offset, height);
	}

	private static String[] two(int offset, int width, int height) {
		String[] res = new String[height];
		int vertCenter = (height - 1) / 2;

		String[] rightVerticalLine = verticalLine(offset + width - 1, width + offset, vertCenter);
		System.arraycopy(rightVerticalLine, 0, res, 0, vertCenter);

		String[] leftVerticalLine = verticalLine(offset, width + offset, vertCenter);
		System.arraycopy(leftVerticalLine, 0, res, vertCenter + 1, vertCenter);

		res[0] = line(offset, width);
		res[vertCenter] = line(offset, width);
		res[height - 1] = line(offset, width);
		return res;
	}

	private static String[] three(int offset, int width, int height) {
		String[] res = new String[height];
		int vertCenter = (height - 1) / 2;
		res = verticalLine(offset + width - 1, width + offset, height);
		res[0] = line(offset, width);
		res[vertCenter] = line(offset, width);
		res[height - 1] = line(offset, width);
		return res;
	}

	private static String[] four(int offset, int width, int height) {
		String[] res = new String[height];
		int vertCenter = (height - 1) / 2;

		String[] topVerticalLines = twoVerticalLines(offset, width, vertCenter);
		System.arraycopy(topVerticalLines, 0, res, 0, vertCenter);

		String[] bottomVerticalLine = verticalLine(offset + width - 1, width + offset, vertCenter);
		System.arraycopy(bottomVerticalLine, 0, res, vertCenter + 1, vertCenter);
		res[vertCenter] = line(offset, width);
		return res;
	}

	private static String[] five(int offset, int width, int height) {
		String[] res = new String[height];
		int vertCenter = (height - 1) / 2;

		String[] topVerticalLine = verticalLine(offset, width + offset, vertCenter);
		System.arraycopy(topVerticalLine, 0, res, 0, vertCenter);

		String[] bottomVerticalLine = verticalLine(offset + width - 1, width + offset, vertCenter);
		System.arraycopy(bottomVerticalLine, 0, res, vertCenter + 1, vertCenter);

		res[0] = line(offset, width);
		res[vertCenter] = line(offset, width);
		res[height - 1] = line(offset, width);
		return res;
	}

	private static String[] six(int offset, int width, int height) {
		String[] res = new String[height];
		int vertCenter = (height - 1) / 2;

		String[] topVerticalLine = verticalLine(offset, width + offset, vertCenter);
		System.arraycopy(topVerticalLine, 0, res, 0, vertCenter);

		String[] bottomVerticalLines = twoVerticalLines(offset, width, vertCenter);
		System.arraycopy(bottomVerticalLines, 0, res, vertCenter + 1, vertCenter);
		res[0] = line(offset, width);
		res[vertCenter] = line(offset, width);
		res[height - 1] = line(offset, width);
		return res;
	}

	private static String[] seven(int offset, int width, int height) {
		String[] res = new String[height];
		res = verticalLine(offset + width - 1, width + offset, height);
		res[0] = line(offset, width);
		return res;
	}

	private static String[] eight(int offset, int width, int height) {
		String[] res = new String[height];
		int vertCenter = (height - 1) / 2;
		res = twoVerticalLines(offset, width, height);
		res[0] = line(offset, width);
		res[vertCenter] = line(offset, width);
		res[height - 1] = line(offset, width);
		return res;
	}

	private static String[] nine(int offset, int width, int height) {
		String[] res = new String[height];
		int vertCenter = (height - 1) / 2;

		String[] topVerticalLines = twoVerticalLines(offset, width, vertCenter);
		System.arraycopy(topVerticalLines, 0, res, 0, vertCenter);

		String[] bottomVerticalLine = verticalLine(offset + width - 1, width + offset, vertCenter);
		System.arraycopy(bottomVerticalLine, 0, res, vertCenter + 1, vertCenter);
		res[0] = line(offset, width);
		res[vertCenter] = line(offset, width);
		res[height - 1] = line(offset, width);
		return res;
	}

	private static int getNdigits(long number) {
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
