package gfg.sort;

import java.util.Arrays;

public class InsertionSort {

	/*
	 * Parcourir le tableau.
	 * Lorsque le précédent P est plus grand que element courant C.
	 * 
	 * Alors rechercher en arriere jusqu'à ce que C soit supérieur à une des positions précédentes.
	 * Décaler d'une position vers la droite, tous les éléments parcourus en arrière et supérieurs à C.
	 * Insérer C à la position trouvée.
	 * 
	 * 
	 * Time Complexity:
	 * Parcours de n elements, retour arriere jusqu'à n-1 places
	 * Donc O(n^2)
	 * 
	 * Best Case: O(n) --> exemple si le tableau est deja trié
	 * 
	 * Space Complexity: n elements, no extra space
	 * 
	 */
	
	static void insertionSortV1(int arr[]) {
		int n = arr.length;		
		int i = 1;
		boolean sortNeeded = true;
		
		while (i <= n - 1 || sortNeeded) {
			sortNeeded = false;
			while (i > 0 && arr[i-1] > arr[i]) {
				int tmp = arr[i];
				arr[i] = arr[i-1];
				arr[i-1] = tmp;
				i --;
				sortNeeded = true;
			}
			if (sortNeeded) {
				i = 1;
			} else {
				i ++;	
			}
		}		
	}
	
	static void insertionSortV2 (int arr[]) {
		for (int i = 0; i < arr.length; i ++ ) {
			int keyValue = arr[i];
			int j = i - 1;
						
			while (j>= 0 && arr[j] > keyValue) {
				arr[j+1] = arr[j];
				j --;
			}
			arr[j+1] = keyValue;			
		}
	}
		
	public static void main(String[] args) {
		 int arr[] = { 12, 11, 13, 5, 6 };
		 // Expected results: 5 6 11 12 13
		 insertionSortV1(arr);
		 System.out.println(Arrays.toString(arr));
		 
		 int arr2[] = { 12, 11, 13, 5, 6 };
		 insertionSortV2(arr2);
		 System.out.println(Arrays.toString(arr2));
	}
	
}
