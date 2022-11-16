
public class Matrices {
	public static int[][] getRandomMatrix(int rows, int columns, int minValue, int maxValue) {
		int[][] result = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				result[i][j] = (int) Numbers.getRandomNumber(minValue, maxValue);
			}
		}
		return result;
	}
	public static int[][] transp(int[][] matrix) {
		int[][] result = new int[matrix[0].length][matrix.length];
		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				result[i][j] = matrix[j][i];
			}
		}
		return result;
	}
}
