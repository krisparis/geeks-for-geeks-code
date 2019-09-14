package math.divisibility.bythree;

/**
 * <p>Greatest integer value is 2^31-1 = 2147483647. Because the int data type is a
 * 32-bit signed two's complement integer.
 * </p>
 * <p>
 * Greatest integer that is a power of 3 is 3^19 = 1162261467.
 * </p>
 * <p>
 * Let x be an integer. If 3^19 % x = 0 then x is a power of 3. Otherwise it is
 * not.
 *</p>
 */
public class CheckIsAPowerOfThree {

	private static int MAX_POWER_OF_THREE = 1162261467;

	public static void main(String[] args) {
		// 3 => Yes
		// 6 => No
		// 9 => Yes
		// 10 => No
		int[] inputs = { 3, 6, 9, 10 };
		for (int input : inputs) {
			boolean powerOfThree = MAX_POWER_OF_THREE % input == 0;
			System.out.println(input + " => " + (powerOfThree ? "Yes" : "No"));
		}
	}
}
