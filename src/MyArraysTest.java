import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

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
		assertArrayEquals(expectedResult, MyArrays.removeNumber(new int[] {1,2,3,8}, 10));
		assertArrayEquals(expectedResult, MyArrays.removeNumber(new int[] {1,2,3,8,5}, 4));
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
	
	
	@Test
	void bubbleSortTest() {
		int[] expectedResult = {1, 4, 9, 16, 24, 32, 83, 123};
		assertArrayEquals(expectedResult, MyArrays.bubbleSort(new int[] {1, 123, 9, 83, 4, 24, 16, 32}));
		
		int[] progressionToMillionSorted = new int[999999];
		for (int i = 0; i < progressionToMillionSorted.length; i++) {
			progressionToMillionSorted[i] = i;
		}
		int[] progressionToMillionChanged = new int[999999];
		System.arraycopy(progressionToMillionSorted, 0, progressionToMillionChanged, 0, progressionToMillionSorted.length);
		progressionToMillionChanged[0] = progressionToMillionSorted[5];
		progressionToMillionChanged[5] = progressionToMillionSorted[0];
		
		assertArrayEquals(progressionToMillionSorted, MyArrays.bubbleSort(progressionToMillionChanged));
	}
	
	@Test
	void binarySearchLeftIndexTest() {
		int[] array = {1, 5, 5, 5, 5, 10};
		assertEquals(1, MyArrays.binarySearchLeftIndex(array, 5));
		assertEquals(-6, MyArrays.binarySearchLeftIndex(array, 6));
		assertEquals(0, MyArrays.binarySearchLeftIndex(array, 1));
		assertEquals(5, MyArrays.binarySearchLeftIndex(array, 10));
		assertEquals(0, MyArrays.binarySearchLeftIndex(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1}, 1));
		assertEquals(-10, MyArrays.binarySearchLeftIndex(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1}, 3));
		assertEquals(-6, Arrays.binarySearch(array, 6));
		assertEquals(-10, Arrays.binarySearch(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1}, 3));
	}
	
	
	@Test
	void isOneSwapTestFalse() {
		int ar1[] = { 1, 2, 3, 10, -1, 5, 6 };
		int ar2[] = { 1, 2, 3, 4, 5, 10 };
		int ar3[] = { 5, 1, 2, 4, 6, 10 };
		int ar4[] = { 1, 5, 2, 4, 3, 10 };
		int ar5[] = { 1, 3, 2, 5, 4, 10, 8 };
		int ar6[] = {1, 3, 20, 4, 5, 6, 10};
		int ar7[] = {1, 3, 20, 4, 5, 11, 2};
		assertFalse(MyArrays.isOneSwapForSorted(ar1));
		assertFalse(MyArrays.isOneSwapForSorted(ar2));
		assertFalse(MyArrays.isOneSwapForSorted(ar3));
		assertFalse(MyArrays.isOneSwapForSorted(ar4));
		assertFalse(MyArrays.isOneSwapForSorted(ar5));
		assertFalse(MyArrays.isOneSwapForSorted(ar6));
		assertFalse(MyArrays.isOneSwapForSorted(ar7));
	}
	
	@Test
	void isOneSwapTestTrue() {
		int ar1[] = { 10, 2, 3, 4, 1 };
		int ar2[] = { 1, 2, 4, 3, 5, 10 };
		int ar3[] = { 1, 2, 3, 10, 5, 4 };
		int ar4[] = { 1, 5, 3, 4, 2, 10 };
		int ar5[] = { 1, 2, 3, 4, 10, 5 };
		int ar6[] = { 2, 1, -3, 4, 5, 10 };
		int ar7[] = { 3, 2, 1, 4, 5, 6 };
		int ar8[] = { 6, 5, 5, 5, 5, 6 };
		assertTrue(MyArrays.isOneSwapForSorted(ar1));
		assertTrue(MyArrays.isOneSwapForSorted(ar2));
		assertTrue(MyArrays.isOneSwapForSorted(ar3));
		assertTrue(MyArrays.isOneSwapForSorted(ar4));
		assertTrue(MyArrays.isOneSwapForSorted(ar5));
		assertTrue(MyArrays.isOneSwapForSorted(ar6));
		assertTrue(MyArrays.isOneSwapForSorted(ar7));
		assertTrue(MyArrays.isOneSwapForSorted(ar8));
	}
	
	@Test
	void isSum2TestTrue() {
		short[] arr1 = { 3, 5, 5, 8, 10, 25, 13};
		short[] arr2 = { 3, 8, 20, 3455, 32, 34, 90, 875};
		assertTrue(MyArrays.isSum2(arr1, (short) 16));
		assertTrue(MyArrays.isSum2(arr2, (short) 3487));
	}
	
	@Test
	void isSum2TestFalse() {
		short[] arr1 = { 3, 5, 5, 8, 10, 25, 13};
		short[] arr2 = { 3, 8, 20, 3455, 32, 34, 90, 875};
		assertFalse(MyArrays.isSum2(arr1, (short) 2));
		assertFalse(MyArrays.isSum2(arr2, (short) 3000));
	}
	
	@Test
	void isSum2TestByBooleanTrue() {
		short[] arr1 = { 3, 5, 5, 8, 10, 25, 13};
		short[] arr2 = { 3, 8, 20, 3455, 32, 34, 90, 875};
		assertTrue(MyArrays.isSum2ByBooleans(arr1, (short) 16));
		assertTrue(MyArrays.isSum2ByBooleans(arr2, (short) 3487));
	}
	
	@Test
	void isSum2TestByBooleanFalse() {
		short[] arr1 = { 3, 5, 5, 8, 10, 25, 13};
		short[] arr2 = { 3, 8, 20, 3455, 32, 34, 90, 875};
		assertFalse(MyArrays.isSum2ByBooleans(arr1, (short) 2));
		assertFalse(MyArrays.isSum2ByBooleans(arr2, (short) 3000));
	}
}
