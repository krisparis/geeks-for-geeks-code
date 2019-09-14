package math.divisibility.byfour;

/**
 * <p>
 * Given a string consisting of integers 0 to 9. The task is to count the number
 * of substrings which when converted into integer are divisible by 4. Substring
 * may contain leading zeroes.
 * </p>
 * 
 * <p>
 * A number is divisible by four if its last two digits are divisible by four.
 * </p>
 * 
 */
public class CountNbSubstringsDivisibleByFour {

	public static void main(String[] args) {
		// "124"
		// Output : 4
		// Substrings divisible by 4 are "12", "4", "24", "124"

		// Input : "04"
		// Output : 3
		// Substring divisible by 4 are "0", "4", "04"
		String[] inputs = { "124", "04" };

		for (int i = 0; i < inputs.length; i++) {
			int nbSubstrings = countSubstringsDivisibleByFour(inputs[i].toCharArray());
			System.out.println(inputs[i] + " ==> " + nbSubstrings);
		}
	}

	private static int countSubstringsDivisibleByFour(char[] digits) {
		int numLength = digits.length;

		int nbSubstringsDivByFour = 0;
		// Count every single digit divisible by four.
		for (int i = 0; i < numLength; i++) {
			int digit = toInt(digits[i]);
			if (digit % 4 == 0) {
				nbSubstringsDivByFour++;
			}
		}

		// Look for every pair of digits divisible by four.
		for (int i = 1; i < numLength; i++) {
			int lastDigit = toInt(digits[i]);
			int sndLastDigit = toInt(digits[i - 1]);

			// If the pair is divisible by four
			if ((sndLastDigit * 10 + lastDigit) % 4 == 0) {
				// Increment by the number of substrings endings with the pair of digits.			
				nbSubstringsDivByFour += i;
			}
		}
		return nbSubstringsDivByFour;
	}

	private static int toInt(char digit) {
		return digit - '0';
	}

}
