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
	@Disabled
	void getBitValueTest() {
		long number = 0x3ab7f5; // 001110101011_0_11111_1_101_0_1
		assertEquals(1, BitOperations.getBitValue(number, 5));
		assertEquals(0, BitOperations.getBitValue(number,11));
		assertEquals(0, BitOperations.getBitValue(number, 1));
		assertEquals(1, BitOperations.getBitValue(number, 2));
		assertEquals(-1, BitOperations.getBitValue(number, 100));
	}
	
	@Test
	@Disabled
	void setBitValueTest() {
		long number = 0x3ab7f5; // 001_1_10101011011111110101
		assertEquals(0x3ab7d5, BitOperations.setBitValue(number, 5, false));  // 001110101011011111_0_10101
		assertEquals(0x3ab7f5, BitOperations.setBitValue(number, 5, true));   // 001110101011011111_1_10101
		assertEquals(0x3aa7f5, BitOperations.setBitValue(number, 12, false)); // 00111010101_0_011111110101
		assertEquals(0x2ab7f5, BitOperations.setBitValue(number, 20, false)); // 001_1_10101010011111110101
		assertEquals(0x7ab7f5, BitOperations.setBitValue(number, 22, true));  // 0_0_1110101010011111110101
	}
	
	@Test
	@Disabled
	void invertBitValueTest() {
		long number = 0x3ab7f5; // 001110101011011111_1_10101
		assertEquals(0x3ab7d5, BitOperations.invertBitValue(number, 5));
		assertEquals(0x3ab7f4, BitOperations.invertBitValue(number, 0));
		assertEquals(0x3aa7f5, BitOperations.invertBitValue(number, 12));
		number = -1;
		assertEquals(1, BitOperations.getBitValue(number, 63));
		number = BitOperations.invertBitValue(number, 63);
		assertEquals(0, BitOperations.getBitValue(number, 63));
	}
	
	@Test
	void digitsNumberTest() {
		//TODO
		assertEquals(6, Numbers.getNdigits(123321));
		assertEquals(1, Numbers.getNdigits(0));
		assertEquals(4, Numbers.getNdigits(2334));
		assertEquals(8, Numbers.getNdigits(12333421));
	}
	
	@Test
	void leadingZerosTest() {
		//TODO
		assertEquals(64, BitOperations.leadingZeros(0));
		assertEquals(0, BitOperations.leadingZeros(-1));
		assertEquals(42, BitOperations.leadingZeros(0x3ab7f5)); // 001110101011011111110101
		assertEquals(48, BitOperations.leadingZeros(0xb7f5));   // 1011011111110101
		assertEquals(16, BitOperations.leadingZeros(BitOperations.invertBitValue(0xb7f5, 47)));
		assertEquals(32, BitOperations.leadingZeros(BitOperations.invertBitValue(0, 31)));
	}
	
	@Test
	void onesInNumberTest() {
		//TODO
		assertEquals(16, BitOperations.onesInNumber(0x3ab7f5)); // 001110101011011111110101
		assertEquals(1, BitOperations.onesInNumber(1));
		assertEquals(0, BitOperations.onesInNumber(0));
		assertEquals(64, BitOperations.onesInNumber(-1));
		assertEquals(63, BitOperations.onesInNumber(BitOperations.invertBitValue(-1, 63)));
	}
	
	@Test
	void isHappyNumberTest() {
		assertEquals(true, Numbers.isHappyNumber(123321));
		assertEquals(false, Numbers.isHappyNumber(123456));
		assertEquals(false, Numbers.isHappyNumber(000000));
		assertEquals(false, Numbers.isHappyNumber(1239742));
		assertEquals(true, Numbers.isHappyNumber(834717));
		assertEquals(true, Numbers.isHappyNumber(999999));
	}
	
	@Test
	@Disabled
	void getDigitsTest() {
		int expected[] = {1, 2, 3, 4};
		assertArrayEquals(expected, Numbers.getDigits(1234));
 	}
	
	@Test
	void getNumberFromDigitsTest() {
		int expectedNumber = 1234;
		assertEquals(expectedNumber, Numbers.getNumberFromDigits(new int[]{1, 2, 3, 4}));
	}
}
