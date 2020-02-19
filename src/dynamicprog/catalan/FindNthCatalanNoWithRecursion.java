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
public class FindNthCatalanNoWithDP {

	private static int[] calculatedNumbers;

	private static int catalanWithTabulation(int n) {
		if (n <= 1) {
			return 1;
		}
		calculatedNumbers[0] = 1;
		calculatedNumbers[1] = 1;

		for (int i = 2; i <= n; i++) {
			int sum = 0;
			for (int j = 0; j < i; j++) {
				sum += calculatedNumbers[j] * calculatedNumbers[i - 1 - j];
			}
			calculatedNumbers[i] = sum;
		}
		return calculatedNumbers[n];
	}

	private static int catalanWithMemoization(int n) {
		if (n <= 1) {
			return 1;
		}
		if (calculatedNumbers[n] != 0) {
			return calculatedNumbers[n];
		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += catalanWithMemoization(i) * catalanWithMemoization(n - 1 - i);
		}
		calculatedNumbers[n] = sum;
		return sum;
	}

	public static void main(String[] args) {
		int n = 9;
		calculatedNumbers = new int[n + 1];
		System.out.println("With memoization " + catalanWithMemoization(n)); // Expected output 4862 for input 9.

		calculatedNumbers = new int[n + 1];
		System.out.println("With tabulation " + catalanWithTabulation(n)); // Expected output 4862 for input 9.
	}

}
