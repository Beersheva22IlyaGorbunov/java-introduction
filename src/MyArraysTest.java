import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MyArraysTest {
	@Test
	void addsNumberTest() {
		int[] expectedResult = {1, 2, 3, 8};
		assertArrayEquals(expectedResult, MyArrays.addsNumber(new int[] {1,2,3}, 8));
	}
	
	@Test
	void removeNumberTest() {
		int[] expectedResult = {1, 2, 3, 8};
		assertArrayEquals(expectedResult, MyArrays.removeNumber(new int[] {1,2,3,16,8}, 3));
		assertArrayEquals(new int[] {}, MyArrays.removeNumber(new int[] {1}, 0));
	}
	
	@Test
	void insertSortedTest() {
		int[] expectedResult = {1, 2, 3, 5, 8};
		assertArrayEquals(expectedResult, MyArrays.insertSorted(new int[] {1,2,3,8}, 5));
		int[] expectedResult2 = {1, 1, 2, 3, 8};
		assertArrayEquals(expectedResult2, MyArrays.insertSorted(new int[] {1,2,3,8}, 1));
		int[] expectedResult3 = {1, 3, 5, 10, 8};
		assertArrayEquals(expectedResult3, MyArrays.insertSorted(new int[] {1,3,10,8}, 5));
	}
}
