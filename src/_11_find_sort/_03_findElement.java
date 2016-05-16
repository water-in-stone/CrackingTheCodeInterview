package _11_find_sort;

/**
 * Created by Young on 2016/5/16.
 * wang645788@gmail.com
 */
public class _03_findElement {
    public static void main(String[] args) {
    	int[] arr = {6, 1, 2, 3, 4, 5};
    	System.out.println(findElement(arr, 6, 5));
    }

    public static int findElement(int[] A, int n, int x){
    	int low1 = 0, low2 = 0, high1 = n - 1, high2 = n -1;
    	int index = -1;
    	if (n < 3) {
    		for (int i = 0; i < n; i++) {
    			if (A[i] == x) {
    				index = i;
    				break;
    			}
    		}
    		return index;
    	}
    	for (int i = 1; i < n; i++) {
    		if (i == n - 1) {
    			low2 = 0;
    			high1 = n - 1;
    			break;
    		}
    		if (getDirection(A[i - 1], A[i]) != getDirection(A[i], A[i + 1])) {
    			low2 = i + 1;
    			high1 = i;
                break;
    		}
    	}
    	index = binarySearch(A, low1, high1, x);
    	if (index == -1) {
    		index = binarySearch(A, low2, high2, x);
    	}
    	return index;
    }

    public static boolean getDirection(int a, int b){
    	return a < b;
    }

    //array is ascended. Using recursion
    public static int binarySearch(int[] a, int low, int high, int x) {
    	//judge ascend or descend
        if (low > high) {
            return -1;
        }
    	boolean isDescend = a[low] > a[high];
        int middle = (low + high) / 2;
        if (x < a[middle]) {
            return isDescend ? binarySearch(a, middle + 1, high, x) : binarySearch(a, low, middle - 1, x);
        } else if (a[middle] < x) {
            return isDescend ? binarySearch(a, low, middle - 1, x) : binarySearch(a, middle + 1, high, x);
        } else {
            return middle;
        }
    }
}
