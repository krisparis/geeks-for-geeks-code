package math.divisibility.bysix;

/**
 * Let a1, a2, a3 three consecutive even numbers.
 * 
 * <p>
 * Let's prove at least one of them is divisible by six.
 * </p>
 * <p>
 * So we have:
 * <ul>
 * <li>a3 = a2 + 2 AND a3 = a1 + 4</li>
 * <li>a2 = a1 + 2</li>
 * </ul>
 * </p>
 * <p>
 * a1, a2, a3 are all divisible by two since there are even. So if at least one
 * of them is also divisible by three then this number is divisible by six.
 * </p>
 * 
 * <p>
 * <h2>Proof</h2>
 * <ul>
 * <li>Let's suppose a1 is not divisible by three and therefore not divisible by
 * six.</li>
 * <li>Then a1 % 3 = 1 or a1 % 3 = 2.</li>
 * <li>Furthermore we have 2 % 3 = 2 and 4 % 3 = 1</li>
 * <li>So if a1 % 3 = 1 then a2 % 3 = (a1 + 2) % 3 = (1 + 2) % 3 = 3 % 3 = 0.
 * <b>So a2 is divisible by 3 and so by 6.</b></li>
 * <li>So if a1 % 3 = 2 then a3 % 3 = (a1 + 4) % 3 = (2 + 1) % 3 = 3 % 3 = 0.
 * <b>So a3 is divisible by 3 and so by 6.</b></li>
 * </ul>
 * 
 * </p>
 *
 */
public class ProveAtLeastOneOfThreeConsecutiveEvenNumbersIsDivisibleBySix {

}
