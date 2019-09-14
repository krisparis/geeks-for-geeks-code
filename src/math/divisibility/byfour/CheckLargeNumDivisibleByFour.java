package math.divisibility.byfour;

/**
 * <p>
 * Number is divisible by four if the sum of its last two digits is divisible by
 * four.
 * </p>
 * <p>
 * <h2>Proof:</h2> Let a0, a1, ..., an be the digits of a number n. So n =
 * a0*10^0 + a1*10^1 + ... + an*10^n
 * </p>
 * 
 * <p>
 * If n % 4 = 0. Then (a0*10^0 + a1*10^1 + ... + an*10^n ) % 4 = 0
 * </p>
 * <p>
 * For i >= 2, 10^i % 4 = 0 because 4 * 25 = 100 = 10^2. So (a0*10^0 + a1*10^1 +
 * ... + an*10^n ) % 4 = a0*10^0 + a1*10^1 = a0 + a1*10
 * </p>
 * 
 * <p>
 * So if (a0 + a1*10 ) % 4 = 0 then n is divisible by zero
 * </p>
 */
public class CheckLargeNumDivisibleByFour {

	public static void main(String[] args) {
		// 0 => YES
		// 2 => NO
		// 4 => YES
		// 64 => YES
		// 444 => YES
		// 1124 => YES
		// 1234567589333862 => NO
		// 363588395960667043875487 => NO
		String[] inputs = { "0", "2", "4", "64", "444", "1124", "1234567589333862", "363588395960667043875487" };
		for (String input : inputs) {
			boolean result = isDivisibleByFour(input.toCharArray());
			String resAsString = result ? " YES " : " NO ";
			System.out.println(input + " => " + resAsString);
		}
	}

	private static boolean isDivisibleByFour(char[] digits) {
		int n = digits.length;

		// Empty string.
		if (n == 0) {
			return false;
		}
		int lastDigit = digits[n - 1] - '0';
		// Single Digit.
		if (n == 1) {
			return lastDigit % 4 == 0;
		} else { // Two digits or more.
			int sndLastDigit = digits[n - 2] - '0';
			return (lastDigit + sndLastDigit * 10) % 4 == 0;
		}
	}

}
