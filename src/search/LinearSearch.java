package gfg.search;

public class LinearSearch {

	// The time complexity of the below algorithm is O(n)
	static int findIndexOf(int search, int[] array) {
		int i = 0;
		int result = -1;
		while (i < array.length && result == -1) {
			if (search == array[i]) {
				result = i;
			}
			i++;
		}
		return result;
	}

	/*
	 * if element Found at last  O(n) to O(1)
	 * if element Not found O(n) to O(n/2)
	 */
	static int findIndexOfV2(int search, int[] array) {
		int i = 0;
		int j = array.length - 1;
		int result = -1;		
		while (i <=  j && result == -1) {
			if (search == array[i]) {
				result = i;
			} else if  (search == array[j]) {
				result = j;
			}
			i++;
			j --;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] array1 = { 10, 20, 80, 30, 60, 50, 110, 100, 130, 170 };
		int res1 = findIndexOfV2(110, array1); // Expected: 6
		System.out.println("Index of '110' is :" + res1);
		int[] array2 = { 10, 20, 80, 30, 60, 50, 110, 100, 130, 170 };
		int res2 = findIndexOfV2(175, array2);
		System.out.println("Index of '175' is :" + res2); // Expected: -1
	}
}
