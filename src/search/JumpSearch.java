package gfg.search;

public class JumpSearch {
	
	static int jumpSearch(int arr[], int x) {
		if (arr == null) {
			return -1;
		}		
		int n = arr.length;
		int m = (int) Math.floor(Math.sqrt(n));
		
		boolean foundGreater = false;
		int step = n/m;
		int index = 0;
		
		while (!foundGreater && index < arr.length - 1) {
			if (arr[index] ==  x) {
				return index;
			} else if (arr[index] >  x) {
				foundGreater = true;
			} else {
				index += step;	
			}
		}
		
		boolean found = false;
		int maxIndex = index;
		index = maxIndex - step;
		while (!found && index < maxIndex) {
			found = arr[index] == x;
			index ++;
		}
		 return found ? --index : -1;		
	}
	
	/*
	 Complexite en temps
	 CAS OPTIMAL
	 n = nombre d'elements
	 m = sqrt (n)
	 Premiere boucle, au pire n/m = sqrt (n) iterations
	 Deuxieme boucle sqrt (n) iterations au pire
	 Total = 2 * sqrt (n) iterations ==> O(sqrt (n))
	
	 Auxiliary Space : O(1)
	
	 PIRE CAS
	 n = nombre d'elements
	 m = 1 (ou resp. m = n)
	 Donc n/m = n (resp. 1)
	 Premiere boucle, au pire n/m = n iterations (resp 1)
	 Deuxième boucle au pire 1 iteration (resp n)
	
	 Donc complexite au pire: O(n)
	
	
	 Donc complexite Cjs jumpSearch est O(log n) <= Cjs <= O(n). En effet  log n <= Sqrt(n)
	 
	 Binary Search est meilleur que jumpSearch dans le cas courant.
	 
	 Mais il peut y avoir des cas où JumpSearch est meilleur.
	 
	 Ex: Si l'élément recherché x est le plus petit élément du tableau (ou plus petit que le plus petit élément du tableau),
	 quelque soit la taille du tableau.
	 
	 Dans ce cas JumpSearch aura deux opérations donc O(1).
	 Et Binary Search va divisé (log n) fois.
	 */
	
	
	static int jumpSearchV2(int arr[], int x) {
		if (arr == null) {
			return -1;
		}		
		int n = arr.length;
		int m = (int) Math.floor(Math.sqrt(n));
		int step = n/m;
		int blockEndIndex = 0;
		
		// Find block
		while (blockEndIndex <arr.length - 1 && arr[blockEndIndex] < x) {
			blockEndIndex += step;
		}
		if (arr[blockEndIndex] == x) {
			return blockEndIndex;
		}
		
		int index = blockEndIndex - step;
		while (index < blockEndIndex && arr[index] != x) {
			index ++;
		}
		return index < blockEndIndex ? index : -1;
	}	
	
	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610 };
		int x = 55;

		// Find the index of 'x' using Jump Search
		int index = jumpSearchV2(arr, x);

		// Print the index where 'x' is located
		System.out.println("\nNumber " + x + " is at index " + index);
	}
}
