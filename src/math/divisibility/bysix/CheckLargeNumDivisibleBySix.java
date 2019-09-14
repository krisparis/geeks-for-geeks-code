package math.divisibility.bysix;

/**
 * <p>
 * Number is divisible by six if it is divisible by three and two.
 * </p>
 * <p>
 * A number is divisible by two it its last digit is divisible by two
 * </p>
 * <p>
 * A number is divisible by three it the sum of its digits is divisible by
 * three.
 * </p>
 */
public class CheckLargeNumDivisibleBySix {

	public static void main(String[] args) {
//      Input  : n = 2112
//		Output : Yes
//
//		Input : n = 1124
//		Output : No
//
//		Input  : n = 363588395960667043875487
//		Output : No
//		
//      Input  : n = 1332
//		Output : Yes

		String[] inputs = { "2112", "1124", "363588395960667043875487", "1332" };
		for (String input : inputs) {
			String res = isDivisibleBySix(input.toCharArray()) ? "Yes" : "No";
			System.out.println(input + " ==> " + res);
		}
	}

	private static boolean isDivisibleBySix(char[] digits) {
		int numLength = digits.length;
		if (numLength == 1) {
			return toInt(digits[0]) % 6 == 0;
		}
		return isDivisibleByTwo(digits) && isDivisibleByThree(digits);
	}

	private static boolean isDivisibleByTwo(char[] digits) {
		return toInt(digits[digits.length - 1]) % 2 == 0;
	}

	private static boolean isDivisibleByThree(char[] digits) {
		int sumOfDigits = 0;
		for (int i = 0; i < digits.length; i++) {
			sumOfDigits += toInt(digits[i]);
		}
		return sumOfDigits % 3 == 0;
	}

	private static int toInt(char digit) {
		return digit - '0';
	}
}
