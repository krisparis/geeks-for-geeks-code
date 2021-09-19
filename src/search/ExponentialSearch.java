package gfg.search;

public class ExponentialSearch {

   public static int exponentialSearch (int[] arr, int x) {
	   if (arr == null || arr.length == 0) {
		   return -1;
	   } else if (arr.length == 1) {
		   return arr[0] == x ? 0 : -1;
	   } else if (arr[0] == x) {
		   return 0;
	   }
	   
	   // Find range.
	   int n = arr.length;
	   int i = 1;
	   while (i < n && arr[i] <= x) {
		   i *= 2;
	   }
	   
	   // Binary Search between i/2 and i.
	   int startIndex = i/2;
	   int endIndex = i;
	   while (startIndex < endIndex) {
		   int mid = startIndex + (endIndex - startIndex) / 2;
		   if (arr[mid] == x) {
			   return mid;
		   } else if (arr[mid] < x) {
			   startIndex = mid + 1;
		   } else {
			   endIndex = mid - 1;
		   }
		   
	   }
	   return -1;
   }	
	
	public static void main(String[] args) {
		int arr[] = {2, 3, 4, 10, 40};
        int x = 10;
        int index = exponentialSearch(arr, x);
        if (index == -1) {
            System.out.println("Not found !!!");        	
        } else {
        	System.out.println("Found Index: " + index);  
        }
	}

}
