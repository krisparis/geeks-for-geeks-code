package math.divisibility.bysix;

import static math.utils.CharUtils.toInt;

/**
 * 
 * <p>
 * Given a number N, remove exactly one digit to make the number divisible by 6
 * (make it the largest possible). Print the position that has to be removed, If
 * not possible then print -1.
 * </p>
 *
 */
public class RemoveDigitsToMakeNumDivisibleBySix {

	public static void main(String[] args) {
//		Input: 123
//		Output: 3 
//		Explanation: Remove 3rd position element and 
//		hence the number is 12, which is divisible
//		by 6 and is the greatest possible.

//		Input: 134
//		Output: -1
//		Explanation: Not possible to remove any and 
//		make it divisible by 6.
//
//		Input: 4510222
//		Output: 1 
//		Explanation: Remove either 4 or 1 to make it 
//		divisible by 6. The numbers after removing 4
//		and 1 are 510222 and 450222 respectively.
//		So, remove 1st position to make it the
//		greatest possible.
		String[] inputs = { "123", "134", "4510222" };

		for (String input : inputs) {
			int res = findIndexOfRemoval(input.toCharArray());
			System.out.println(input + " ==> " + res);
		}
	}

	private static int findIndexOfRemoval(char[] digits) {
		if (isDivisibleBySix(digits)) {
			return -1;
		}
		int sumModThree = calculateSumModThree(digits);

		int lastDigit = toInt(digits[digits.length - 1]);
		// Is last digit divisible by two
		if (!isDivisibleByTwo(lastDigit)) {
			int sndLastDigit = toInt(digits[digits.length - 2]);
			if (!isDivisibleByTwo(sndLastDigit) || ((sumModThree - lastDigit) % 3 != 0)) {
				// removing last digit was not enough.
				return -1;
			}
			// Last digit is the one to remove.
			return digits.length;
		}

		int i = digits.length - 2, minIndexRemoval = -1;
		while (i >= 0) {
			int digit = toInt(digits[i]);

			boolean newNumDivisibleByThree = (sumModThree - digit) % 3 == 0;
			if (newNumDivisibleByThree) {
				minIndexRemoval = i;
			}
			i--;
		}
		// Return index value starting from 1.
		return minIndexRemoval != -1 ? minIndexRemoval + 1 : -1;
	}

	private static boolean isDivisibleBySix(char[] digits) {
		int lastDigit = toInt(digits[digits.length - 1]);
		if (lastDigit % 2 != 0) {
			return false;
		}

		int sumOfDigits = 0;
		for (int i = 0; i < digits.length; i++) {
			sumOfDigits += toInt(digits[i]);
		}
		return sumOfDigits % 3 == 0;
	}

	private static boolean isDivisibleByTwo(int digit) {
		return digit % 2 == 0;
	}

	private static int calculateSumModThree(char[] digits) {
		int sumOfDigits = 0;
		for (int i = 0; i < digits.length; i++) {
			sumOfDigits += toInt(digits[i]);
		}
		return sumOfDigits % 3;
	}

}
