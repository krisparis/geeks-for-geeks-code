package dynamicprog.binomialcoeff;

/**
 * <p>
 * Gives the number of ways, disregarding order, that k objects can be chosen
 * from among n objects; more formally, the number of k-element subsets (or
 * k-combinations) of an n-element set.
 * </p>
 * <p>
 * C(n, k) = C(n - 1, k) + C(n - 1, k - 1).
 * </p>
 * <p>
 * C(n, 0) = 1, C(n, n) = 1
 * </p>
 *
 */
public class BinomialCoefficientWithRecursion {

	static int binomialCoeff(int n, int k) {
		if (k == 0 || k == n) {
			return 1;
		}
		return binomialCoeff(n - 1, k) + binomialCoeff(n - 1, k - 1);
	}

	public static void main(String[] args) {
		int n = 4, k = 2;

		n = 5;
		k = 2;
		System.out.println("****************************** " + binomialCoeff(n, k)); // Expect 10
	}

}
