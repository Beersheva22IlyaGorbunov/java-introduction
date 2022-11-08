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
		if (array.length == 0 || index >= array.length) {
			return array;
		}
		
		int[] res = new int[array.length - 1];
		System.arraycopy(array, 0, res, 0, index);
		System.arraycopy(array, index + 1, res, index, array.length - index - 1);
		
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
		int insertIndex = tempIndex < 0 ? -(tempIndex + 1) : tempIndex;
		int[] res = new int[arraySorted.length + 1];
		
		System.arraycopy(arraySorted, 0, res, 0, insertIndex);
		res[insertIndex] = number;
		System.arraycopy(arraySorted, insertIndex, res, insertIndex + 1, arraySorted.length - insertIndex);
		
		return res;
	}
}
