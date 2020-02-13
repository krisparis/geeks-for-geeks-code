package dynamicprog.uglynumber;

/**
 * <h1>Ugly Numbers</h1>
 * <p>
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
 * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By
 * convention, 1 is included.
 * </p>
 * 
 * <h2>Method 1</h2>
 * <p>
 * Loop for all positive integers until ugly number count is equal to n, if an
 * integer is ugly then increment ugly number count.
 * </p>
 * <p>
 * To check if a number is ugly, divide the number by greatest divisible powers
 * of 2, 3 and 5, if the number becomes 1 then it is an ugly number otherwise
 * not.
 * </p>
 * 
 * <p>
 * For example 300 is an ugly number.
 * </p>
 * 
 * <h2>Greatest divisible power (GDP)</h2>
 * 
 * <p>
 * Let N be the number we want to check if it is an ugly number or not.
 * </p>
 * <p>
 * So GDP k of 2 is the power of 2 such that N % (2^k)=0 and there doesn’t exist
 * any p>k such that N%(2^p)=0
 * </p>
 * 
 * <p>
 * for example, n=24.GDP of 2 is 3, because 24%(2^3)=0
 * </p>
 * 
 */
public class UglyNumberMethod2 {

	private static int[] uglyNumbers;

	private static int calculateNthUglyNumber(int n) {				
		uglyNumbers = new int[n];		
		uglyNumbers[0] = 1;
		int i2 = 0, i3 = 0, i5 = 0;
		int nextMultipleOfTwo = 2;
		int nextMultipleOfThree = 3;
		int nextMultipleOfFive = 5;
		
		int uglyNumbersCount = 0;		
		while (uglyNumbersCount < n - 1) {
		
			System.out.println("nextUglyNumberMultipleOfTwo: " + nextMultipleOfTwo +
					", nextUglyNumberMultipleOfThree: " + nextMultipleOfThree
					+", nextUglyNumberMultipleOfFive: " + nextMultipleOfFive);
			
			// Which one is the minimum
			int minUglyNumber = Math.min(nextMultipleOfTwo,
					Math.min(nextMultipleOfThree, nextMultipleOfFive));
			
			if (minUglyNumber != uglyNumbers[uglyNumbersCount]) {
				uglyNumbersCount ++;
				uglyNumbers[uglyNumbersCount] = minUglyNumber;				
			}
			
			
			if (minUglyNumber == nextMultipleOfTwo) {
				i2 = i2+1;
				nextMultipleOfTwo = uglyNumbers[i2] * 2;
			} else if (minUglyNumber == nextMultipleOfThree) {
				i3 = i3+1;
				nextMultipleOfThree = uglyNumbers[i3] * 3;				
			} else if (minUglyNumber == nextMultipleOfFive) {
				i5 = i5+1;
				nextMultipleOfFive = uglyNumbers[i5] * 5;
			}
			System.out.println("i2: " + i2 + ", i3: " + i3 + ", i5: " + i5);
			System.out.println("===========================================");
		}
		
		return uglyNumbers[n - 1];
	}

	public static void main(String[] args) {
		int n = 11;
		int nthUglyNumber = calculateNthUglyNumber(n);
		System.out.println(n+"th ugly number is: " + nthUglyNumber); // Expected result for 150 is 5832.		
	}
}
