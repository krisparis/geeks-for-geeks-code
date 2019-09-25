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
		// 1128 => Yes
		// 1124 => No
		// 363588395960667043875487 => No
		String[] inputs = { "1128", "1124", "363588395960667043875487" };

		for (String input: inputs) {
			System.out.println(input + " ==> " + isDivisibleByEight(input.toCharArray()));
		}		
	}

	private static boolean isDivisibleByEight(char[] digits) {
		int endingTriplet = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			endingTriplet += toInt(digits[i]) * Math.pow(10, digits.length - 1 - i);
		}

		return endingTriplet % 8 == 0;
	}

}
