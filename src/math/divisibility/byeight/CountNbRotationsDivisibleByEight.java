package math.divisibility.byeight;

import static math.utils.CharUtils.toInt;

public class CountNbRotationsDivisibleByEight {

	public static void main(String[] args) {
		// 8 => 1
		// 40 => 1
		// 13502 => 0
		// 43262488612 => 4

		String[] inputs = { "8", "40", "13502", "43262488612" };

		for (String input : inputs) {
			System.out.println(input + " => " + countRotations(input.toCharArray()));
		}
	}

	private static int countRotations(char[] digits) {
		int numLength = digits.length;
		if (numLength == 0) {
			return 0;
		}
		if (numLength == 1) {
			return toInt(digits[0]) % 8 == 0 ? 1 : 0;
		} else if (numLength == 2) { // two-digit numbers
			int fstPair = toInt(digits[1]) * 10 + toInt(digits[0]);
			int sndPair = toInt(digits[0]) * 10 + toInt(digits[1]);

			int nbRotations = 0;
			if (fstPair % 8 == 0) {
				nbRotations++;
			}
			if (sndPair % 8 == 0) {
				nbRotations++;
			}
			return nbRotations;
		} else {
			int count = 0;
			int cents, tens, units;
			for (int index = 0; index <= numLength - 3; index++) {
				cents = toInt(digits[index]);
				tens = toInt(digits[index + 1]);
				units = toInt(digits[index + 2]);
				if (isDivisibleByEight(cents, tens, units)) {
					count++;
				}
			}

			cents = toInt(digits[numLength - 2]);
			tens = toInt(digits[numLength - 1]);
			units = toInt(digits[0]);
			if (isDivisibleByEight(cents, tens, units)) {
				count++;
			}

			cents = toInt(digits[numLength - 1]);
			tens = toInt(digits[0]);
			units = toInt(digits[1]);
			if (isDivisibleByEight(cents, tens, units)) {
				count++;
			}

			return count;
		}
	}

	private static boolean isDivisibleByEight(int cents, int tens, int units) {
		return (cents * 100 + tens * 10 + units) % 8 == 0;
	}

}
