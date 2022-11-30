package telran.digital.numbers.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.digital.numbers.DigitalNumbersPrinting.*;

public class DigitalPrintingTest {
	@Test
	@Disabled
	void lineTest() {
		System.out.println(line(30, 30));
	}
	
	@Test
	@Disabled
	void verticalLineTest() {
		displayStrings(verticalLine(10, 20, 30));
	}
	
	@Test
	@Disabled
	void twoVerticalLineTest() {
		displayStrings(twoVerticalLines(30, 10, 10));
	}

	
	@Test
	void displayDigitalNumberTest() {
		displayDigitalNumber(1234567890, 3, 7, 7);
	}
	
	@Test
	void checkArraysSize() {
		int number = 1234567890;
		int offset = 3;
		int width = 7;
		int height = 7;
		String[] stringsToDisplay = getStringsToPrint(number, offset, height, width);
		assertEquals(height, stringsToDisplay.length);
		for (int i = 0; i < stringsToDisplay.length; i++) {
			assertEquals(getNdigits(number) * (offset + width),stringsToDisplay[i].length());
		}
	}
	
	
}
