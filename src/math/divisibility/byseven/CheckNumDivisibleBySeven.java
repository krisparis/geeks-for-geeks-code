package math.divisibility.byseven;

/**
 * <p>
 * A number of the form 10 * a + b is divisible by 7 if a - 2*b is divisible by
 * 7.
 * </p>
 * <p>
 * <h2>Proof</h2>
 * <ul>
 * <li>2 * (10a + b) = 20a + 2b = 21a - a + 2b</li>
 * <li>(21a - a + 2b) % 7 = 0 (- a + 2b) % 7 = (a - 2b) % 7</li>
 * </ul>
 * </p>
 * 
 * <p>
 * Using modulo operator is not allowed, floating point arithmetic is also not allowed..
 * </p>
 *
 */
public class CheckNumDivisibleBySeven {
	public static void main(String[] args) {
		// 616, 371
		int[] inputs = { 616, 371 };

		for (int input : inputs) {
			System.out.println(input + " => " + isDivisibleBySeven(input));
		}

	}

	private static boolean isDivisibleBySeven(int num) {
		if (num < 0) {
			return isDivisibleBySeven(-num);
		}
		if (num == 0 || num == 7) {
			return true;
		}
		if (num < 10) {
			return false;
		}
		int a = num / 10;
		int b = num - a * 10;
		return isDivisibleBySeven(a - 2 * b);
	}

}
