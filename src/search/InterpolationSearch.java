package gfg.search;

public class InterpolationSearch {
	/*
	 * 
	 * 
	 * On a un tableau trié arr[] avec des valeurs supposées uniformement distribuees.
	 * 
	 * Un tableau uniformément distribué est un tableau où chaque valeur apparait autant de fois que les autres.
	 * Ex: [1, 2, 3, 4] est uniformément distribué
	 * 
	 * 
	 * On pose l'equation pour chaque élément du tableau v = m*i + c.
	 * Avec i un index dans le tableau, v la valeur correspondant à l'index i dans le tableau, c: une constante.
	 * 
	 * 
	 * lo    ==> Premier index dans arr[]
	 * hi    ==> Dernier index dans arr[]
	 * x     ==> Element recherché
	 * pos   ==> L'index correspondant à x
	 * 
	 * Ainsi
	 * arr[lo] = m * lo + c  (1)
	 * arr[hi] = m * hi + c  (2)
	 * x = m * pos + c       (3)
	 * 
	 * arr[hi] - arr[lo] = m* (hi - lo)                                            (2) - (1)
	 * x - arr[lo] = m*(pos - lo)                                                  (3) - (1)
	 * (x-arr[lo])*(hi-lo) = m*(pos - lo) * (hi-lo)                                [(3) - (1)]*(hi-lo)
	 * [ (x-arr[lo])*(hi-lo) / (arr[hi]-arr[Lo]) ] = pos - lo                      [(3) - (1)]*(hi-lo)
	 * lo + [ (x-arr[lo])*(hi-lo) / (arr[hi]-arr[lo]) ] = pos                      lo + [(3) - (1)]*(hi-lo)
	 */
	
	/*
	 * Analyse complexité:
	 * 
	 * Complexité en temps:
	 * 
	 * Pire cas:
	 * 
	 * Cas general: O(loglogn)
	 * 
	 * 
	 * 
	 */
	
	
	private static int estimatePos (int[] arr, int x, int lo, int hi) {		
		return  lo +  (x-arr[lo])*(hi-lo) / (arr[hi]-arr[lo]) ;
	}
	
	public static int interpolationSearchIterative (int[] arr, int x) {
		if (arr == null || arr.length == 0) {
			return -1;
		} else if (arr.length == 1) {
			return arr[0];
		}
		
		int lo= 0;
		int hi = arr.length - 1;
		
		while (lo <= hi) {
			int pos = estimatePos(arr, x, lo, hi);
			// System.out.println("pos: " + pos + ", arr[pos]: " + arr[pos] + ", lo: " + lo + ", hi: " + hi);

			if (arr[pos] == x) {
				return x;
			} else if (arr[pos] < x) {
				lo = pos + 1;
			} else if (arr[pos] > x) {
				hi = pos - 1;
			}
		}		
		return -1;
	}
	
	public static int interpolationSearchRecursive (int[] arr, int x, int lo, int hi) {
		if (arr == null || arr.length == 0 || lo > hi) {
			return -1;
		} else if (lo == hi) {
			return arr[lo];
		}
		
		int pos = estimatePos(arr, x, lo, hi);
		if (arr[pos] == x) {
			return x;
		} else if (arr[pos] < x) {
			return interpolationSearchRecursive(arr, x, pos + 1, hi);
		} else  {
			return interpolationSearchRecursive(arr, x, lo, pos - 1);
		}		
	}
	
	
	public static void main(String[] args) {
        int arr[] = { 10, 12, 13, 16, 18, 19, 20, 21,
                      22, 23, 24, 33, 35, 42, 47 };
  
        // Element recherche
        int x = 18;
        int index = interpolationSearchIterative(arr, x);
        if (index == -1) {
        	System.out.println("Version iterative. Not Found !!!");
        } else {
        	System.out.println("Version iterative. Index trouvé: " + index);
        }        
        int indexV2 = interpolationSearchRecursive(arr, x, 0, arr.length - 1);
        if (indexV2 == -1) {
        	System.out.println("Version recursive. Not Found !!!");
        } else {
        	System.out.println("Version recursive. Index trouvé: " + indexV2);
        }        
	}
}
