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
 * <p>For example 300 is an ugly number.</p>
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
public class UglyNumberMethod1 {

    /*This function divides a by greatest 
    divisible power of b*/	
	static int maxDivide(int a, int b) {
		while (a % b == 0) {
			a = a / b;
		}
		return a;
	}
	
    /* Function to check if a number  
    is ugly or not */
	static boolean isUgly (int no) {
        no = maxDivide(no, 2);
        System.out.println("After maxDivide with 2: " + no);
        no = maxDivide(no, 3);
        System.out.println("After maxDivide with 3: " + no);        
        no = maxDivide(no, 5); 
        System.out.println("After maxDivide with 5: " + no);
          
        return (no == 1)? true : false; 
	}
	
    /* Function to get the nth ugly  
    number*/
	static int getNthUglyNoWithMethod1() {
		return 0;
	}
	
	public static void main(String[] args) {
		int n = 300;
		boolean result = isUgly(n);
		System.out.println("IsUgly ("+n+"): " + result);
		
	}

}
