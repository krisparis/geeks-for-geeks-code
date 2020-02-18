package dynamicprog.catalan;

/**
 * <p>
 * In combinatorial mathematics, the Catalan numbers form a sequence of natural
 * numbers that occur in various counting problems, often involving
 * recursively-defined object
 * </p>
 *
 * <p>
 * The first few Catalan numbers for n = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42,
 * 132, 429, 1430, 4862.
 * </p>
 *
 * <h3>Formula</h3>
 * <p>
 * 
 * <ul>
 * <li>Cn+1​=C0​Cn​+C1​Cn−1​+⋯+Cn​C0​</li>
 * <li>C0 = 1</li>
 * </ul>
 * 
 * Cn = (2n)! / ((n + 1)!n!)
 * 
 * </p>
 */
public class FindNthCatalanNoWithRecursion {

	private static int catalan(int n) {
		if (n <= 1) {
			return 1;
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += catalan(i) * catalan(n - 1 - i);
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(catalan(9)); // Expected output 4862 for input 9.
	}

}
