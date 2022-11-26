package telran.text;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import static telran.text.Strings.*;

class StringsTest {

	@Test
	void isAnagramTest() {
		String word = "yellow";
		assertTrue(isAnagram(word, "loweyl"));
		assertTrue(Strings.isAnagram(word, "elolyw"));
		assertTrue(Strings.isAnagram(word, "wolley"));
		assertTrue(Strings.isAnagram(word, "loleyw"));
		assertFalse(Strings.isAnagram(word,""));
		assertFalse(Strings.isAnagram(word, "yellob"));
		assertFalse(Strings.isAnagram(word,"yello"));
		assertFalse(Strings.isAnagram(word,"yelllo"));
	}
	
	@Test 
	void sortStringNumbersTest() {
		String[] strArray = {"8", "12", "-23", "5", "3", "8", "-4"};
		Strings.sortStringNumbers(strArray);
		assertArrayEquals(strArray, new String[]{"-23", "-4", "3", "5", "8", "8", "12"});
	}
	
	@Test
	void javaVariableTest() {
		assertTrue("java".matches(Strings.javaNameExp()));
		assertTrue("java_1_2".matches(Strings.javaNameExp()));
		assertTrue("$".matches(Strings.javaNameExp()));
		assertTrue("__".matches(Strings.javaNameExp()));
		assertFalse("_".matches(Strings.javaNameExp()));
		assertFalse("1java".matches(Strings.javaNameExp()));
		assertFalse("sdf das".matches(Strings.javaNameExp()));	
	}
	
	@Test
	void ipv4OctetTest() {
		assertTrue("255".matches(Strings.ipv4Octet()));
		assertTrue("005".matches(Strings.ipv4Octet()));
		assertTrue("098".matches(Strings.ipv4Octet()));
		assertTrue("243".matches(Strings.ipv4Octet()));
		assertTrue("0".matches(Strings.ipv4Octet()));
		assertFalse("".matches(Strings.ipv4Octet()));
		assertFalse("2444".matches(Strings.ipv4Octet()));
		assertFalse("1111".matches(Strings.ipv4Octet()));
		assertFalse("198 100".matches(Strings.ipv4Octet()));
		assertFalse("256".matches(Strings.ipv4Octet()));
		assertFalse("369".matches(Strings.ipv4Octet()));
		assertFalse("0000".matches(Strings.ipv4Octet()));	
	}
	
	@Test
	void ipv4Test() {
		assertTrue("255.255.255.255".matches(Strings.ipv4()));
		assertTrue("000.000.000.000".matches(Strings.ipv4()));
		assertTrue("255.000.000.000".matches(Strings.ipv4()));
		assertTrue("5.255.255.5".matches(Strings.ipv4()));
		assertTrue("0.249.054.098".matches(Strings.ipv4()));
		assertFalse("256.255.255.255".matches(Strings.ipv4()));	
		assertFalse("".matches(Strings.ipv4()));
		assertFalse(".255.255.255".matches(Strings.ipv4()));
		assertFalse("256.255.255.".matches(Strings.ipv4()));
		assertFalse("256.255.255.256".matches(Strings.ipv4()));
		assertFalse("256.255.255.2555".matches(Strings.ipv4()));
		assertFalse("255.255.255.255.245".matches(Strings.ipv4()));
		assertFalse("256.255.255".matches(Strings.ipv4()));
		assertFalse("256.255".matches(Strings.ipv4()));
	}
	
	@Test
	void isArithmeticExpressionTest() {
		assertTrue(isArithmeticExpression("   5 +    .23 "));
		assertTrue(isArithmeticExpression("((5 + ((.23)"));
	}
	
	@Test
	void computeExpressionTest() {
		assertEquals(10, computeArithmeticExpression("2 + 2 + 1 * 2 + 0.5", null, null));
		assertEquals(10.5, computeArithmeticExpression("a + 2 + c * 2 + 0.5", new double[] {2, 1},
				new String[] {"a", "c"}));
		assertEquals(10.5, computeArithmeticExpression("((a + 2 + c * 2 + 0.5))", new double[] {2, 1},
				new String[] {"a", "c"}));
		assertEquals(10.5, computeArithmeticExpression("(a + 2) + c * 2 + 0.5", new double[] {2, 1},
				new String[] {"a", "c"}));
		assertTrue(Double.isNaN(computeArithmeticExpression("2 # 2 ++ 10", null, null)));
		assertTrue(Double.isNaN(computeArithmeticExpression("(2 + 2 + 10", null, null)));
		assertTrue(Double.isNaN(computeArithmeticExpression("2( + 2 + 10", null, null)));
		assertTrue(Double.isNaN(computeArithmeticExpression("2 (+ 2 + 10", null, null)));
		assertTrue(Double.isNaN(computeArithmeticExpression(")2 + 2 + 10", null, null)));
		assertTrue(Double.isNaN(computeArithmeticExpression("2 + 2 + 10(", null, null)));
		assertTrue(Double.isNaN(computeArithmeticExpression("2 +() 2 + 10", null, null)));
		assertTrue(Double.isNaN(computeArithmeticExpression("((2 + 2 + 10)", null, null)));
		assertTrue(Double.isNaN(computeArithmeticExpression("a + 2 + c * 2 + d23", new double[] {2, 1},
				new String[] {"a", "c"})));
		assertTrue(Double.isNaN(computeArithmeticExpression(")a + 2 + c * 2", new double[] {2, 1},
				new String[] {"a", "c"})));
		assertTrue(Double.isNaN(computeArithmeticExpression("(())a + 2 + c * 2", new double[] {2, 1},
				new String[] {"a", "c"})));
	}
}
