package dynamicprog.fibonacci;

public class FibonacciWithDP {

	private static int[] fibResults;

	private static int fiboWithMemoization(int n) {
		if (n <= 1) {
			return n;
		} else if (fibResults[n] != 0) {
			return fibResults[n];
		}
		fibResults[n] = fiboWithMemoization(n - 1) + fiboWithMemoization(n - 2);
		return fibResults[n];
	}

	private static int fiboWithTabulation(int n) {
		for (int i = 2; i <= n; i++) {
			fibResults[i] = fibResults[i - 1] + fibResults[i - 2];
		}
		return fibResults[n];
	}

	private static void clearFiboArray() {
		for (int i = 2; i < fibResults.length; i++) {
			fibResults[i] = 0;
		}
	}

	public static void main(String[] args) {
		int n = 9;
		fibResults = new int[n + 1];

		fibResults[0] = 0;
		fibResults[1] = 1;

		System.out.println(fiboWithMemoization(9));
		clearFiboArray();
		System.out.println(fiboWithTabulation(9));
	}

}
