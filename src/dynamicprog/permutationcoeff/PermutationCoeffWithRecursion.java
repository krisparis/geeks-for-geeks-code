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
public class PermutationCoeffWithRecursion {

	static int permutationCoeff(int n, int k) {
		System.out.println("==> permutationCoeff(" + n + ", " + k + ")");
		if (k == 0) {
			return 1;
		}
		if (k > n) {
			return 0;
		}
		return permutationCoeff(n - 1, k) + k * permutationCoeff(n - 1, k - 1);
	}

	public static void main(String[] args) {
		int n, k;

		/*
		 * P(10, 2) = 90 P(10, 3) = 720 P(10, 0) = 1 P(10, 1) = 10
		 */

		n = 10;
		k = 2;
		System.out.println("P(" + n + "," + k + ") = " + permutationCoeff(n, k));

		k = 3;
		System.out.println("P(" + n + "," + k + ") =" + permutationCoeff(n, k));

		k = 0;
		System.out.println("P(" + n + "," + k + ") =" + permutationCoeff(n, k));

		k = 1;
		System.out.println("P(" + n + "," + k + ") =" + permutationCoeff(n, k));

	}

}
