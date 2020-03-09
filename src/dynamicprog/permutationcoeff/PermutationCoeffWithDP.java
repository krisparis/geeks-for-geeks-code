package dynamicprog.permutationcoeff;

/**
 * 
 * <p>
 * Permutation refers to the process of arranging all members of a given set to
 * form a sequence.
 * </p>
 * <p>
 * In case of permutation,order of elements is also considered.
 * </p>
 * <p>
 * The coefficient can also be computed recursively using the below recursive
 * formula: P(n, k) = P(n-1, k) + k* P(n-1, k-1)
 * </p>
 */
public class PermutationCoeffWithDP {

	static int[][] values;

	static int permutationCoeff(int n, int k) {

		if (k == 0) {
			return 1;
		}
		if (k > n) {
			return 0;
		}

		values = new int[n + 1][k + 1];
		values[0][0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, k); j++) {
				values[i][j] = j == 0 ? 1 : values[i - 1][j] + j * values[i - 1][j - 1];
			}
		}

		return values[n][k];
	}

	public static void main(String[] args) {
		int n, k;

		/*
		 * P(10, 2) = 90 P(10, 3) = 720 P(10, 0) = 1 P(10, 1) = 10
		 */

		n = 10;
		k = 2;
		// System.out.println("P(" + n + "," + k + ") = " + permutationCoeff(n, k));

		k = 3;
		System.out.println("P(" + n + "," + k + ") =" + permutationCoeff(n, k));

		k = 0;
		// System.out.println("P(" + n + "," + k + ") =" + permutationCoeff(n, k));

		k = 1;
		// System.out.println("P(" + n + "," + k + ") =" + permutationCoeff(n, k));
	}

}
