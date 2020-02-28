package dynamicprog.bellnumber;

public class BellTriangleWithDP {

	private static int[][] array;

	static int bellNumberWithTabulation(int n) {
		// Base case.
		if (n == 0) {
			return 1;
		}
		array = new int[n + 1][n + 1];
		array[0][0] = 1;

		for (int i = 1; i <= n; i++) {
			array[i][0] = array[i - 1][i - 1];
			for (int j = 1; j <= i; j++) {
				array[i][j] = array[i][j - 1] + array[i - 1][j - 1];
			}
		}
		return array[n][0];
	}

	public static void main(String[] args) {
		// B0 = 1, B1 = 1, B2 = 2, B3 = 5, B4 = 15, B5 = 52, B6 = 203, B7 = 877
		for (int i = 0; i <= 7; i++) {
			System.out.println("B" + i + " = " + bellNumberWithTabulation(i));
		}
	}
}
