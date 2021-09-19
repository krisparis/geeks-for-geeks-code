package gfg.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SelectionSort { 
	
	/*
	 * Time complexity:
	 * 
	 * Best/average/worst Case: n * (n - 1) = O(n^2)
	 * 
	 * Space complexity : 
	 * Version 1: n + n = 2n
	 * Version 2: n (no extra space) 
	 * 
	 */

	public static void selectionSortWithSwap(int arr[]) {		
		int n = arr.length;		
		for (int i = 0; i < n; i ++) {
			int minIndex = i;
			
			for (int j = i+1; j<n; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}	
			// Swap elements
			int tmp = arr[i];
			arr[i] =  arr[minIndex];
			arr[minIndex] = tmp;
		}
	}
	
	
	public static int[] selectionSort(int arr[]) {
		List<Integer> sortedList = new ArrayList<>();		
		List<Integer> remainings = Arrays.stream(arr).boxed().collect(Collectors.toList());
		
		if (arr == null || arr.length == 0) {
			return arr;
		}
				
		while (remainings.size() > 0) {			
			int min  = remainings.get(0);
			int index = 0;
			for (int i = 1; i < remainings.size(); i ++) {
				int tmp =  remainings.get(i);
				if (min > tmp) {
					min = tmp;
					index = i;
				}
			}
			remainings.remove(index);
			
			int sortedListSize = sortedList.size();
			if (sortedListSize == 0) {
				sortedList.add(min);
				continue;
			}
			index = 0;
			while (index < sortedListSize && sortedList.get(index) <= min ) {
				index ++;
			}			
			sortedList.add(index, min);			
		}		
		return sortedList.stream().mapToInt(i->i).toArray();	
	}
	
	
	public static void main(String[] args) {
		int arr[] = { 64, 25, 12, 22, 11 };
		int sorted[] = selectionSort(arr);
		// SelectionSort.
		// Expected result: 11 12 22 25 64
		System.out.println(Arrays.toString(sorted));
		
		selectionSortWithSwap(arr);
		System.out.println("Selection sort by Swap");
		System.out.println(Arrays.toString(arr));
		
	}

}
