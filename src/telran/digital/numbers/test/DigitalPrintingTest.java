package telran.digital.numbers.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
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
		displayDigitalNumber(1234567890, -1, 8, 7);
	}
	
	
}
