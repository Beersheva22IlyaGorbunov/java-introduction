import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
	@Disabled
	void dataTypeTest() {
		int i = 10;
		short a = 20;
		char c = 'd';
		long l = (long) 10.9;
		byte b = (byte) 1030;
		a = (short) l;
		float f = 12.3f;
		int i2 = 0x80000000;
		assertEquals(i, l);
	}
	
	@Test
	@Disabled
	void operatorsTest() {
		int number = 123;
		assertEquals(3, getThirdDigit(number));
		assertEquals(2, getSecondDigit(number));
		assertEquals(1, getFirstDigit(number));
	}

	private int getFirstDigit(int number) {
		// TODO Auto-generated method stub
		return number / 100;
	}

	private int getSecondDigit(int number) {
		// TODO Auto-generated method stub
		return number / 10 % 10;
	}

	private int getThirdDigit(int number) {
		// TODO Auto-generated method stub
		return number % 10;
	}

	@Test
	void getBitValueTest() {
		long number = 0x3ab7f5; // 001110101011_0_11111_1_101_0_1
		assertEquals(1, BitOperations.getBitValue(number, 5));
		assertEquals(0, BitOperations.getBitValue(number,11));
		assertEquals(0, BitOperations.getBitValue(number, 1));
		assertEquals(1, BitOperations.getBitValue(number, 2));
		assertEquals(-1, BitOperations.getBitValue(number, 100));
	}
	
	@Test
	void setBitValueTest() {
		long number = 0x3ab7f5; // 001110101011011111_1_10101
		assertEquals(0x3ab7d5, BitOperations.setBitValue(number, 5, false));
		assertEquals(0x3ab7f5, BitOperations.setBitValue(number, 5, true));
	}
	
	@Test
	void invertBitValueTest() {
		long number = 0x3ab7f5; // 001110101011011111_1_10101
		assertEquals(0x3ab7d5, BitOperations.inverseBitValue(number, 5));
		assertEquals(0x3ab7f4, BitOperations.inverseBitValue(number, 0));
	}
}
