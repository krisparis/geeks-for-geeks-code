package math.divisibility.byeight;

import static math.utils.CharUtils.toInt;

/**
 * <p>
 * A number is divisible by eight if its last three digits make a number
 * divisible by eight.
 * </p>
 * <p>
 * <h2>Proof</h2>
 * <ul>
 * <li>For any i >= 4, 10^i % 8 = 0.</li>
 * <li>So let n be a number such as n = a0*10^0 + a1*10^1 + a2*10^2 + ... +
 * an*10^n</li>
 * <li>So n% 8 = (a0*10^0 + a1*10^1 + a2*10^2 + ... + an*10^n) % 8 = (a0*10^0 +
 * a1*10^1 + a2*10^2) % 8</li>
 * <li>So if the number made of the digits a2a1a0 is divisible by 8 then n is
 * divisible by 8.</li>
 * </ul>
 * </p>
 */
public class CheckLargeNumDivisibleByEight {

	public static void main(String[] args) {
		// 8 => Yes
		// 16 => Yes
		// 1128 => Yes
		// 1124 => No
		// 363588395960667043875487 => No
		String[] inputs = { "8", "16", "1128", "1124", "363588395960667043875487" };

		for (String input : inputs) {
			System.out.println(input + " ==> " + isDivisibleByEight(input.toCharArray()));
		}
	}

	private static boolean isDivisibleByEight(char[] digits) {
		int numLength = digits.length;

		if (numLength == 1) {
			return toInt(digits[0]) % 8 == 0;
		} else if (numLength == 2) {
			return (toInt(digits[0]) * 10 + toInt(digits[1])) % 8 == 0;
		} else {
			int units = toInt(digits[numLength - 1]);
			int tens = toInt(digits[numLength - 2]);
			int cents = toInt(digits[numLength - 3]);
			return (cents * 100 + tens * 10 + units) % 8 == 0;
		}
	}

}
