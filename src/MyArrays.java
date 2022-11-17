import java.util.Arrays;

public class MyArrays {
	/**
	 * 
	 * @param array
	 * @param number
	 * @return new array, which include old array with added a given number
	 */
	public static int[] addsNumber(int[] array, int number) {
		int[] res = Arrays.copyOf(array, array.length + 1);
		res[array.length] = number;
		return res;
	}
	/**
	 * 
	 * @param array
	 * @param index
	 * @return new array, without element with a given index
	 * if index doesn't exist in given array, return array
	 */
	public static int[] removeNumber(int[] array, int index) {
		int res[] = array;
		
		if (array.length != 0 && index < array.length && index > -1) {
			res = new int[array.length - 1];
			System.arraycopy(array, 0, res, 0, index);
			System.arraycopy(array, index + 1, res, index, array.length - index - 1);
		}
		
		return res;
	}
	/**
	 * 
	 * @param arraySorted - already sorted array 
	 * @param number
	 * @return new array with inserted a given number at a right position
	 */
	public static int[] insertSorted(int[] arraySorted, int number) {
		int tempIndex = Arrays.binarySearch(arraySorted, number);
		tempIndex = tempIndex < 0 ? -(tempIndex + 1) : tempIndex;
		
		return insertAtIndex(arraySorted, number, tempIndex);
	}
	
	private static int[] insertAtIndex(int[] array, int number, int index) {
		int[] res = new int[array.length + 1];
		
		System.arraycopy(array, 0, res, 0, index);
		res[index] = number;
		System.arraycopy(array, index, res, index + 1, array.length - index);

		return res;
	}
	/**
	 * 
	 * @param arraySorted
	 * @param number
	 * @return index value if number exists otherwise -1 
	 * O[N] - search number in unsorted array
	 * O[log(N)] - search number in sorted (binary search)
	 * 
	 */
	public static int binarySearch(int[] arraySorted, int number) {
		int left = 0;
		int right = arraySorted.length - 1;
		int middle = right / 2;
		while (left <= right && arraySorted[middle] != number) {
			if (number < arraySorted[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (left + right) / 2;
		}
		return arraySorted[middle] != number ? -1 : middle;
	}
	
	public static int binarySearchLeftIndex(int[] arraySorted, int number) {
		int left = 0;
		int right = arraySorted.length - 1;
		int middle = right / 2;
		while (left <= right && arraySorted[left] != number) {
			if (number <= arraySorted[middle]) {
				right = middle - 1;
			}
			else {
				left = middle + 1;
			}
			middle = (left + right) / 2;
		}
		return left < arraySorted.length && arraySorted[left] == number ? left : -left - 1;
	}
	/**
	 * 
	 * @param array - array, which is needed to be sort
	 * @return sorted array
	 */
	public static int[] bubbleSort(int[] array) {
		int[] resultArray = new int[array.length];
		System.arraycopy(array, 0, resultArray, 0, array.length);
		int unsortedLength = resultArray.length;
		
		do {
			unsortedLength = moveGreaterRight(resultArray, unsortedLength - 1);
		} while (unsortedLength != 0);
		
		return resultArray;
	}
	/**
	 * 
	 * @param array - which mutates by function, compare each pair
	 * of numbers and bigger move right
	 * @return int number of last swap
	 */
	private static int moveGreaterRight(int[] array, int length) {
		int lastSwap = 0;
		for (int i = 0; i < length; i++) {
			if (array[i] > array[i + 1]) {
				lastSwap = i + 1;
				swap(array, i, i + 1);
			}
		}
		return lastSwap;
	}
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	/**
	 * 
	 * @param array
	 * @return true, only if array would be sorted after one swap
	 */
	public static boolean isOneSwapForSorted(int[] array) {
		boolean res = false;
		int firstNumber = -1;
		int secondNumber = -1;
		int conflictCount = 0;
		
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				if (conflictCount == 0) {
					firstNumber = i - 1;
					secondNumber = i;
				
					conflictCount ++;
				} else {
					secondNumber = i;
					
					conflictCount ++;
				}
			}
			if (array[i] == array[i - 1] && array[i] == array[secondNumber]) {
				secondNumber = i;
			}
		}
		
		if (conflictCount > 0 && conflictCount < 3) {
			res = checkNewPlace(array, array[firstNumber], secondNumber) 
			   && checkNewPlace(array, array[secondNumber], firstNumber);
		} else {
			res = false;
		}
		
		return res;
	}
	/**
	 * 
	 * @param array 
	 * @param number which we need to check in position
	 * @param position
	 * @return true, if number in position makes sorted order
	 */
	private static boolean checkNewPlace(int[] array, int number, int position) {
		boolean res = false;
		if (position > 0 && position < array.length - 1) {
			if (number >= array[position - 1] && number <= array[position + 1]) {
				res = true;
			}
		} else {
			if (position == 0) {
				if (number <= array[position + 1]) {
					res = true;
				}
			} else {
				if (number >= array[position - 1]) {
					res = true;
				}
			}
		}
		return res;
	}
	/**
	 * 
	 * @param array of short positive numbers
	 * @param sum
	 * @return true, if exist pair of elements in array,
	 * 		   sum of which equals to param sum
	 */
	public static boolean isSum2(short[] array, short sum) {
		boolean[] foundedElements = new boolean[sum >= 0 ? sum + 1 : 0x7fff + 1];
		boolean result = false;
		int i = 0;
		while (result == false && i < array.length) {
			if (array[i] <= sum) {
				short searchedElement = (short) (sum - array[i]);
				if (foundedElements[searchedElement] == false) {
					foundedElements[array[i]] = true;
				} else {
					result = true;
				}
			}
			i++;
		}
		return result;
	}
}
