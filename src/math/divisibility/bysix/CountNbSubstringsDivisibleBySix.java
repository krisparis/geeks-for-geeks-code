package math.divisibility.bysix;

import static math.utils.CharUtils.toInt;
/**
 * <p>
 * Given a string consisting of integers 0 to 9. The task is to count the number
 * of substrings which when convert into integer are divisible by 6. Substring
 * does not contain leading zeroes.
 * </p>
 * <p>
 * A number is divisible by six if it is divisible by two (last digit divisible
 * by two) and also divisible by three (sum of digits divisible by three).
 * </p>
 */
public class CountNbSubstringsDivisibleBySix {

	public static void main(String[] args) {
	}

	private static int countSubstringsDivisibleBySix(char[] digits) {
		int numLength= digits.length;
		
		if (numLength == 1) {
			int digit = toInt(digits[0]);		
			return digit % 6 == 0 ? 1 : 0;
		}
		
		int count = 0;
		for (int i = 0; i < numLength; i ++) {	
			int digit = toInt(digits[i]);			
			if (digit % 2 == 0 && digit % 3 == 0) {
				count ++;
			}
			
			
		}		
		return 0;
	}
	
	private static int countSubstringsFrom () {
		return 0;
	}
	
}
