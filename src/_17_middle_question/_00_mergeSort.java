package _17_middle_question;

import java.util.*;

public class _00_mergeSort {

    public static int[] helper;

    public static void main(String[] args) {
        int[] A = {12, 3, 6, 5, 9, 10};
//        int[] A2 = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        mergeSort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }

    public static void mergeSort(int[] A) {
        int n = A.length;
        helper = new int[n];
        mergeSort(A, 0, n - 1);
    }

    public static void mergeSort(int[] array, int low, int high){
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    public static void merge(int[] array, int low, int mid, int high){
        //copy value from origin array
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int left = low;
        int right = mid + 1;
        int cur = low;
        while (left <= mid && right <= high) {
            if (helper[left] <= helper[right]) {
                array[cur] = helper[left];
                left++;
            } else {
                //当右边数组的元素小于左边元素时，将右边元素复制回原来的数组
                array[cur] = helper[right];
                right++;
            }
            cur++;
        }

        /**
         * 很重要！将剩余的左边的元素复制回去，在这里右边元素已经全部搞定了
         */
        int remain = mid - left;
        for (int i = 0; i <= remain; i++) {
            array[cur + i] = helper[left + i];
        }
    }


}




