package gfg.sort;

import java.util.Arrays;

/*
 *  Time complexity : O(n)
 *  Space complexity: n (no extra space)
 *  
 *  Maximum number of swaps in bubble sort.
 *  
 *  1er nombre: n-1 swaps
 *  2nd nombre: n-1 swaps
 *  ...
 *  neme nombre: n-1 swaps
 *  
 *  Donc pire cas = n(n-1) * 
 *  
 *  Meilleur cas = O(n), tableau déjà trié
 *  
 */
public class BubbleSort {
	
	
	static void bubbleSortV1WithUnDefinedBoundForUpperLoop (int arr[]) {
		boolean iterateAgain = true;
		while (iterateAgain) {
			iterateAgain = false;
			for (int i = 0; i < arr.length - 1; i ++) {
				if (arr[i] > arr[i+1]) {
					int tmp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = tmp;
					iterateAgain = true;
				}				
			}	
		}		
	}
	
	static void bubbleSortV2WithTwoLoops(int arr[]) {
		int n = arr.length;
		int nbPass = 1;
		Boolean swapped = null;
		while (nbPass <= n && (swapped == null || swapped)) {
			swapped = false;
			for (int j = 0; j < n - 2; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
					swapped = true;
				}
			}
		}
	}
	// each time greater number placed to current last position (n - i - 1)
	// So no need to scan arr[n - i - 1] value at next iteration
	// because it will necessarly be greater than other values with lower indexes in the array.
	static void bubbleSortOptimized(int arr[]) {
		int n = arr.length;
		boolean swapped = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		int arr[] = {64, 34, 25, 12, 22, 11, 90};		
		// expected results: 11 12 22 25 34 64 90		
		bubbleSortV1WithUnDefinedBoundForUpperLoop(arr);
		System.out.println(Arrays.toString(arr));
		
		int arr2[] = {64, 34, 25, 12, 22, 11, 90};
		bubbleSortV2WithTwoLoops(arr2);
		System.out.println(Arrays.toString(arr2));
		
		int arr3[] = {64, 34, 25, 12, 22, 11, 90};
		bubbleSortOptimized(arr3);
		System.out.println(Arrays.toString(arr2));
	}
	
}
