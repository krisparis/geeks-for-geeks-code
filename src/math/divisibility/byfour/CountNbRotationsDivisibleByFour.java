package math.divisibility.byfour;

/**
 * A number is divisible by four if its last two digits makes a number divisible
 * by four. So we look for consecutive pairs of digits in the given number and
 * count one more rotation when a each pair divisible by four.
 *
 */
public class CountNbRotationsDivisibleByFour {

	public static void main(String[] args) {
		/**
		 * 
		 * <p>
		 * Input: 8. <br>
		 * Output: 1
		 * </p>
		 * <p>
		 * Input: 20. <br>
		 * Output: 1. <br>
		 * Rotation: 20 is divisible by 4, 02 is not divisible by 4
		 * </p>
		 * 
		 * <p>
		 * Input : 13502. <br>
		 * Output : 0. <br>
		 * No rotation is divisible by 4
		 * </p>
		 * 
		 * <p>
		 * Input : 43292816. <br>
		 * Output : 5. <br>
		 * 5 rotations are : 43292816, 16432928, 81643292 92816432, 32928164
		 * </p>
		 */
		String[] inputs = { "8", "20", "13502", "43292816" };
		for (String input : inputs) {
			int result = countRotations(input.toCharArray());
			System.out.println(input + " => " + result);
		}

	}

	private static int countRotations(char[] digits) {
		int numLength = digits.length;
		// Empty String.
		if (numLength == 0) {
			return 0;
		}
		// Single Digit.
		if (numLength == 1) {
			int singleDigit = digits[0] - '0';
			return singleDigit % 4 == 0 ? 1 : 0;
		} else { // Two digits or more.
			int nbRotations = 0;
			for (int index = 0; index < numLength - 1; index++) {
				if (isNumberFromIndexesDivisibleByFour(index, index + 1, digits)) {
					nbRotations++;
				}
			}
			// Last case: rotation ending with first digit.
			if (isNumberFromIndexesDivisibleByFour(numLength - 1, 0, digits)) {
				nbRotations++;
			}
			return nbRotations;
		}
	}

	private static boolean isNumberFromIndexesDivisibleByFour(int indexOfTensDigit, int indexOfUnitsDigit, char[] num) {
		int tens = toInt(num[indexOfTensDigit]) * 10;
		int units = toInt(num[indexOfUnitsDigit]);
		return (tens + units) % 4 == 0;
	}

	private static int toInt(char digit) {
		return digit - '0';
	}
}
