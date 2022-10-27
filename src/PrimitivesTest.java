import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
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

}
