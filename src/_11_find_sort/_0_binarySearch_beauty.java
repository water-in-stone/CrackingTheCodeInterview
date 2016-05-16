package _11_find_sort;

/**
 * Created by Young on 2016/5/16.
 * wang645788@gmail.com
 */
public class _0_binarySearch_beauty {
    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6, 8, 10, 13, 16, 30, 55, 66, 84};
        int i = binarySearchIterator(a, 13);
        if (i == -1) {
            System.out.println("not found");
        } else {
            System.out.println("index is " + i);
        }
    }

    public static int binarySearch(int[] a, int x) {
        return binarySearch(a, 0, a.length - 1, x);
    }

    //array is ascended. Using recursion
    public static int binarySearch(int[] a, int low, int high, int x) {
        if (low > high) {
            return -1;
        }
        int middle = (low + high) / 2;
        if (x < a[middle]) {
            return binarySearch(a, low, middle - 1, x);
        } else if (a[middle] < x) {
            return binarySearch(a, middle + 1, high, x);
        } else {
            return middle;
        }
    }

    //array is ascended. Using iterator
    public static int binarySearchIterator(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        int middle;
        while (low <= high) {
            middle = (low + high) / 2;
            if (x < a[middle]) {
                high = middle - 1;
            } else if (x > a[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
