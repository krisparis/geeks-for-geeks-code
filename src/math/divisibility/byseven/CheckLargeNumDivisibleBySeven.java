package math.divisibility.byseven;

import static math.utils.CharUtils.toInt;

/**
 * 
 * <p>
 * Let n be a number such as n = a0 * 1 + a1 * 10 + ... + ar * 10 ^n
 * </p>
 * <p>
 * n is divisible by 7 if (a0a1a2) - (a3a4a5) + (a6a7a8) + ... is divisible by
 * 7.
 * </p>
 * <p>
 * <h2>Proof</h2>
 * <ul>
 * <li>1000 % 7 = (-1) % 7</li>
 * <li>n, with r+1 digits, can be written as (a0a1a2) * 1000^0 + (a3a4a5) * 1000
 * + (a6a 74a8) * (1000*1000) + ... + ((ar-2) * (ar-1) * ar) * (1000 ^ (r+1)
 * )</li>
 * <li>So n % 7 = (a0a1a2) * (-1) + (a3a4a5) * + ... + (an-2an-1ar) * (-1)^
 * (r+1)</li>
 * </ul>
 * </p>
 */
public class CheckLargeNumDivisibleBySeven {

	public static void main(String[] digits) {
		// 8955795758 => Yes
		// 100000000000 => No
		// 7 => Yes
		// -7000 => Yes

		String[] inputs = { "8955795758", "100000000000", "7", "-7000" };

		for (String input : inputs) {
			String res = isDivisibleBySeven(input) ? "Yes" : "No";
			System.out.println(input + " => " + res);
		}
	}

	private static boolean isDivisibleBySeven(String num) {
		if (num.startsWith("-")) {
			num = num.substring(1);
		}

		String paddedNum = padLeftWithRequiredZeros(num);
		int numLength = paddedNum.length();

		int sumOfTriplets = 0;
		for (int i = 0; i <= numLength - 3; i += 3) {
			int triplet = toInt(paddedNum.charAt(i)) * 100 + toInt(paddedNum.charAt(i + 1)) * 10
					+ toInt(paddedNum.charAt(i + 2));
			triplet *= Math.pow(-1, numLength - (i + 3));
			sumOfTriplets += triplet;
		}
		return sumOfTriplets % 7 == 0;
	}

	private static String padLeftWithRequiredZeros(String num) {
		int n = num.length();

		// Append required 0s at the beginning.
		if (n % 3 == 1) {
			num = "00" + num;
		}
		if (n % 3 == 2) {
			num = "0" + num;
		}
		return num;
	}
}
