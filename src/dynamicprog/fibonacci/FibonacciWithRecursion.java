package dynamicprog.fibonacci;

public class FibonacciWithRecursion {

	private static int fibo(int n) {
		if (n == 0) {
			return 0;
		} else if (n <= 2) {
			return 1;
		} else {
			return fibo(n - 1) + fibo(n - 2);
		}
	}

	public static void main(String[] args) {
		int n = 9;
		System.out.println(fibo(n)); // Expected output for n = 9: 34
	}

}
