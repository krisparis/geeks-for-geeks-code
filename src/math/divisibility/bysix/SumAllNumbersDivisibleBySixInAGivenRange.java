package math.divisibility.bysix;

/**
 *
 * <p>
 * Let's say we want to calculate the sum of all numbers divisible by six in a
 * given range [L, R] where L and R are two numbers such as L <= R.
 * </p>
 * 
 * <p>
 * <h2>Naive approach</h2>
 * One possibility could be to loop from L to R and sum all numbers which are
 * divisible by six. But if [L,R] is very large, computation might take a long
 * time.
 * </p>
 * <p>
 * <h2>Efficient approach</h2>
 * <ul>
 * <li>Consider the sum of all numbers divisible by 6, from 6 to R included.</li>
 * <li>From 6 to R, there are [floor(R/6)] numbers divisible by 6. Next we assume R/6 = [floor(R/6)]</li>
 * <li>The greatest number divisible by 6 and not superior to R is R/6</li>
 * <li>Therefore the sum of this arithmetic series is sumR = (R/6) * ((R/6)*6 + 6 )/2 = (R/6) * ((R/6 + 1)*6)/2  </li>
 * </ul>
 * 
 * We then calculate a similar sum for all all numbers divisible by 6, from 6 to (L-1) included.
 * We get sumLMinusOne =  [(L-1) /6] * [ ((L-1)/6 + 1)*6]/2
 * </p>
 *
 */
public class SumAllNumbersDivisibleBySixInAGivenRange {
	
	public static void main(String[] args) {
//		Input : 1 20
//		Output : 36 
//		Explanation: 6 + 12 + 18 = 36 
		int rangeMin = 1;
		int rangeMax = 20;
		int res = calculateSum(rangeMin, rangeMax);	 
		System.out.println("[RangeMin: " + rangeMin + ", RangeMax: " + rangeMax +"] ==> " + res);		
//		Input : 5 7  
//		Output : 6
//		Explanation: 6 is the only divisible number 
//		in range 5-7
		rangeMin = 5;
		rangeMax = 7;
		res = calculateSum(rangeMin, rangeMax);	 
		System.out.println("[RangeMin: " + rangeMin + ", RangeMax: " + rangeMax +"] ==> " + res);
		
	}
	
	private static int  calculateSum (int rangeMin, int rangeMax) {
		int sumR = (rangeMax/6) * ((rangeMax/6 + 1)*6)/2 ;
		int sumLMinusOne =  ((rangeMin-1) /6) * ( ((rangeMin-1)/6 + 1)*6)/2;
		
		return sumR - sumLMinusOne;
	}
	
}
