package math.divisibility.bythree;

/**
 * <p>
 * Number is divisible by three if the sum of its digits is divisible by three.
 * </p>
 * <p>
 * <h2>Proof:</h2> Let a0, a1, ..., an be the digits of a number n. So n =
 * a0*10^0 + a1*10^1 + ... + an*10^n
 * </p>
 * <p>
 * If n % 3 = 0. Then (a0*10^0 + a1*10^1 + ... + an*10^n ) % 3 = 0
 * </p>
 * <p>
 * We can see that 10^i % 3 = 1 (i >= 0).
 * <ul>
 * <li>For example: 10 % 3 = 1 or 1 % 3 = 1. Reminder of 10^i % 3 = 1 % 3 =
 * 1</li>
 * </ul>
 * </p>
 * <p>
 * So, Sum = (a0*10^0 + a1*10^1 + ... + an*10^n ) % 3 = 0 Sum = (a0*1 + a1*1 +
 * ... + an*1 ) % 3 = 0 Sum = (a0 + a1 + ... + an ) % 3 = 0
 * </p>
 */
public class CheckLargeNumDivisibleByThree {

	public static void main(String[] args) {
		// 769452 => Yes
		// 123456758933312 => No
		// 3635883959606670431112222 => Yes
		String[] inputs = { "769452", "123456758933312", "3635883959606670431112222" };
		for (String input : inputs) {
			boolean result = isDivisibleByThree(input.toCharArray());
			String resAsString = result ? " YES " : " NO ";
			System.out.println(input + " => " + resAsString);
		}
	}

	private static boolean isDivisibleByThree(char[] digits) {
		int sum = 0;

		for (char c : digits) {
			int digit = c - '0';
			sum += digit;
		}
		return sum % 3 == 0;
	}

}
