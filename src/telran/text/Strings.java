package telran.text;
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
		return "([a-zA-Z$][\\w$]*|_[\\w$_]+)";
	}
	
	public static String ipv4Octet() {
		return "([01]?\\d{1,2}|2([0-4]\\d|5[0-5]))";
	}
	
	public static String ipv4() {
		String checkOctet = ipv4Octet();
		return String.format("(%1$s\\.){3}%1$s", checkOctet);
	}
	
	private static String arithmeticExp() {
		String operatorExp = operator();
		String operandExp = operand();
		return String.format("\\(*%1$s(%2$s\\(*%1$s\\)*)*", operandExp, operatorExp);
	}

	private static String numberOperand() {
		return "(\\d+\\.?\\d*|\\.\\d+)";
	}
	
	private static String operand() {
		String numberOperandExp = numberOperand();
		String varNameExp = javaNameExp();
		return String.format("(%1$s|%2$s)", numberOperandExp, varNameExp);
	}
	
	private static String operator() {
		return "([-+*/])";
	}
	
	public static Boolean isArithmeticExpression(String expression) {
		expression = expression.replaceAll("\\s", "");
		return expression.matches(arithmeticExp());
	}
	/**
	 * 
	 * @param expression
	 * @param values
	 * @param sortedNames - variable names sorted
	 * @return
	 */
	public static double computeArithmeticExpression(String expression, 
													 double[] values, 
													 String[] names) {
		Double res = Double.NaN;
		if (isArithmeticExpression(expression) && checkBraces(expression)) {
			expression = expression.replaceAll("[\\s()]+", "");
			String[] operands = expression.split(operator());
			String[] operators = expression.split(operand());
			res = getOperandValue(operands[0], values, names);
			int index = 1;
			while (index < operands.length && !res.isNaN()) {
				double secondOperand = getOperandValue(operands[index], values, names);
				if (!Double.isNaN(secondOperand)) {
					res = computeOperation(res, operators[index], secondOperand);
					index++;
				} else {
					res = Double.NaN;
				}
			}
		}
		return res;
	}

	private static Double computeOperation(Double firstOperand, String operation, Double secondOperand) {
		switch(operation) {
			case "+": firstOperand += secondOperand; break;
			case "-": firstOperand -= secondOperand; break;
			case "/": firstOperand /= secondOperand; break;
			case "*": firstOperand *= secondOperand; break;
			default: firstOperand = Double.NaN;
		}
		return firstOperand;
	}

	private static Double getOperandValue(String operand, double[] values, String[] names) {
		double res = Double.NaN;
		if (operand.matches(numberOperand())) {
			res = Double.parseDouble(operand);
		} else {
			int i = 0;
			while (i < names.length && Double.isNaN(res)) {
				if (names[i].compareTo(operand) == 0) {
					res = values[i];
				}
				i++;
			}
		}
		return res;
	}
	
	private static boolean checkBraces(String expression) {
		int counter = 0;
		boolean res = true;
		int i = 0;
		while (i < expression.length() && res) {
			if (expression.charAt(i) == '(') {
				counter ++;
			} else if (expression.charAt(i) == ')') {
				counter--;
			}
			if (counter < 0) {
				res = false;
			}
			i++;
		}
		return res && counter == 0;
	}
}
