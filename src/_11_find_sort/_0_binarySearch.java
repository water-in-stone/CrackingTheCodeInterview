package _11_find_sort;

import java.util.*;

public class _0_binarySearch {

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6, 8, 10, 13, 16, 30, 55, 66, 84};
        int i = binarySearch(a, 13);
        if (i == -1) {
            System.out.println("not found");
        } else {
            System.out.println("index is " + i);
        }
    }

    public static int binarySearch(int[] a, int x) {
        return binarySearch(a, 0, a.length - 1, x);
    }

    //array is ascended
    public static int binarySearch(int[] a, int low, int high, int x) {
        if (low > high) {
            return -1;
        }
        int middle = (low + high) / 2;
        int result = -1;
        if (x < a[middle]) {
            result = binarySearch(a, low, middle - 1, x);
        } else if (a[middle] < x) {
            result = binarySearch(a, middle + 1, high, x);
        } else {
            result = middle;
        }
        return result;
    }
}

