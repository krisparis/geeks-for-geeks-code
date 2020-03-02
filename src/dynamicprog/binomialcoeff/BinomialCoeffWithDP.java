package dynamicprog.binomialcoeff;

public class BinomialCoeffWithDP {

	static int[][] intermediateValues;

	private static int binomialCoeffTabulation(int n, int k) {
		intermediateValues = new int[n + 1][k + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, k); j++) {
				if (j == 0 || j == i) {
					intermediateValues[i][j] = 1;
				} else {
					intermediateValues[i][j] = intermediateValues[i - 1][j] + intermediateValues[i - 1][j - 1];
				}
			}
		}

		return intermediateValues[n][k];
	}

	private static int binomialCoeffMemoization(int n, int k) {
		if (intermediateValues[n][k] != 0) {
			return intermediateValues[n][k];
		}
		if (k == 0 || k == n) {
			return 1;
		}
		intermediateValues[n][k] = binomialCoeffMemoization(n - 1, k) + binomialCoeffMemoization(n - 1, k - 1);
		return intermediateValues[n][k];
	}

	public static void main(String[] args) {
		int n = 4, k = 2;
		intermediateValues = new int[n + 1][k + 1];
		System.out.println("****************************** " + binomialCoeffMemoization(n, k)); // Expect 6

		n = 5;
		k = 2;
		intermediateValues = new int[n + 1][k + 1];
		System.out.println("****************************** " + binomialCoeffMemoization(n, k)); // Expect 10

		n = 4;
		k = 2;
		intermediateValues = new int[n + 1][k + 1];
		System.out.println("****************************** " + binomialCoeffTabulation(n, k)); // Expect 6

		n = 5;
		k = 2;
		intermediateValues = new int[n + 1][k + 1];
		System.out.println("****************************** " + binomialCoeffTabulation(n, k)); // Expect 10
	}
}
