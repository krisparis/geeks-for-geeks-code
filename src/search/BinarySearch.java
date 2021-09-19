package gfg.search;

public class BinarySearch {

   // Recommendations. Calcul de Index médian:
   // 1) int mid = (start + end) / 2. ==> Si start et end sont des nombres très grands. start + end peut dépasser MAX_INT_VALUE
   // 2) int mid = start + (end - start) / 2. Ici mid ne pourra jamais dépasser end. Donc probleme enleve

  // Complexite
  // Time complexity.
  // Par recurrence:
  // T(n) = T(n/2) + K => K = nombre fixe d'opérations constantes avant appel de fonctions récursives.
  // Comme K est une constante, donc K = O(1) donc asymptotiquement T(n) = T(n/2) + 1
  // T(n) = 1 + (1 + T(n/4) )  = 2 + T(n/4) = 2 + (1 + T(n/8)) = 3 + T(n/8) = ... = k + T (n / 2^logK) =
  // log n + T (n / 2^logn) = log n + T(1) = log n + 1 = O(log n)
	
  // Par Master Theorem.
  // T(n) = aT(n/b) + f(n)
  // Si f(n) = Θ(n^d), where d ≥ 0, ALORS
  // T(n) = Θ(n^d) if a < b^d,
  // T(n) = Θ(n^dlog n) if a = b^d,
  // T(n) = Θ(nlogb^a) if a > b^d.
  //
  // Ici T(n) = T(n/2) + 1 = aT(n/b) + f(n) avec a = 1, b = 2 et f(n) = 1
  // donc f(n) = Θ(n^0) = Θ(1), donc d = 0.
  // a = b^d = 1
  // donc T(n) = Θ(n^dlog n) = T(n) = Θ(log n)
  
	
	
	
	
	
	
	static int findIndexOfByIteration(int search, int[] array) {
		boolean found = false;
		int result = -1;
		int start = 0;
		int end = array.length - 1;
				
		while (!found && start <= end) {
			int middleIndex =  start + (end - start) / 2;
			int midValue = array[middleIndex];
			//System.out.println("turn: "+ turn+ " start: " + start + ", end: " + end + ", midIndex: " +middleIndex + " midValue: " + midValue);
			if (search == midValue) {
				found = true;
				result = middleIndex;
			} else if (search < midValue) {
				end = middleIndex - 1;
			} else {
				start = middleIndex + 1;
			}
		}
		return result;
	}

	static int findIndexOfByRec(int search, int[] array, int start, int end) {
		if (start > end) {
			return -1;
		}
		int middleIndex = start + (end - start) / 2; 
		int midValue = array[middleIndex];
		if (search == midValue) {
			return middleIndex;
		} else if (search < midValue) {
			return findIndexOfByRec(search, array, start, middleIndex - 1);
		} else {
			return findIndexOfByRec(search, array, middleIndex + 1, end);
		}
	}
	
	
	
	public static void main(String[] args) {
		int[] sortedArray = { 2, 5, 8, 12, 23, 38, 56, 72, 91 };
		int res_i = findIndexOfByIteration(23, sortedArray);
		System.out.println("(Iterative) Result is: " + res_i); // Expected: 4
		int res_i_1 = findIndexOfByIteration(100, sortedArray);
		System.out.println("(Iterative) Result is: " + res_i_1); // Expected: -1
		
		int res_r = findIndexOfByRec(23, sortedArray, 0, sortedArray.length -1);
		System.out.println("(Recursive) Result is: " + res_r); // Expected: 4
		int res_r_2 = findIndexOfByRec(100, sortedArray, 0, sortedArray.length -1);
		System.out.println("(Recursive) Result is: " + res_r_2); // Expected: 4		
	}

}
