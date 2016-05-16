package _11_find_sort;

/**
 * it still is binary search, all I do is to add two conditions
 * Created by Young on 2016/5/16.
 * wang645788@gmail.com
 */
public class _03_findElement_beauty {
    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 3, 4, 5};
        System.out.println(findElement(arr, 6, 2));
    }

    public static int findElement(int[] A, int n, int x){
        int low = 0;
        int high = n - 1;
        int middle;
        //join several situation
        while(low <= high){
            middle = (low +  high) / 2;
            if (A[middle] == x) {
                return middle;
            }
            //another judge
            if (A[middle] < x) {
                //judge by A[middle] and A[low] and x
                if (A[middle] < A[low] && x > A[high]) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            } else {
                if (A[middle] > A[low] && x < A[low]) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            }
        }
        return -1;
    }
}
