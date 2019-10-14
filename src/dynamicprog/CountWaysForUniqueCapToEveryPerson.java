package dynamicprog;

/**
 * <p>
 * 100 different types of caps.
 * </p>
 * <p>
 * there are ‘n’ persons each having a collection of a variable number of caps
 * </p>
 * <p>
 * count the total number of arrangements or ways such that none of them is
 * wearing the same type of cap
 * </p>
 * <p>
 * Constraints: 1 <= n <= 10
 * </p>
 * <p>
 * Number of ways could be large, so output modulo 1000000007.
 * </p>
 * 
 *
 */
public class CountWaysForUniqueCapToEveryPerson {

	static int allmask;
	
	
	static int dp[][] = new int[1025][101];

	public static void main(String[] args) {
		String[] collectionPerPerson = { "5 100 1", "2", "5 100" };
		int n = 10;

		// In binary numeral system, (1 << n) is written with one "1" and then n "0"s.
		// So (1 << n) - 1 is n "1"
		// For instance, (1 << 2) is 100 (4 in decimal form) and [(1 << 2) - 1] is 11 (3
		// in decimal form).
		int allmask = (1 << n) - 1;
		System.out.println("allmask: " + allmask);
	}

	private static void countWays(String[] collectionPerPerson) {

	}

}
