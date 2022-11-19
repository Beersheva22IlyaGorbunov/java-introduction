import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ObjectTests {

	@Test
	void isAnagramTest() {
		String word = "yellow";
		assertTrue(Strings.isAnagram(word, "loweyl"));
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
}
