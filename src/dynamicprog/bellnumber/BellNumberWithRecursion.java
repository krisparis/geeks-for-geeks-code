package dynamicprog.bellnumber;

public class BellNumberWithRecursion {

	static int stirlingNoSndKind(int n, int k) {
		// Base cases
		if (n == 0 || k == 0 || k > n) {
			return 0;
		}
		if (k == 1 || k == n) {
			return 1;
		}
		return k * stirlingNoSndKind(n - 1, k) + stirlingNoSndKind(n - 1, k - 1);
	}

	static int bellNumber(int n) {
		int sumOfStirlingNo = 0;
		for (int k = 1; k <= n; k++) {
			sumOfStirlingNo += stirlingNoSndKind(n, k);
		}
		return sumOfStirlingNo;
	}

	public static void main(String[] args) {
		// B0 = 1, B1 = 1, B2 = 2, B3 = 5, B4 = 15, B5 = 52, B6 = 203, B7 = 877
		for (int i = 0; i <= 7; i++) {
			System.out.println("B" + i + " = " + bellNumber(i));
		}
	}

}
