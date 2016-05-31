package _17_middle_question;

import java.util.*;

public class _10_FindPair{

	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 5};
		System.out.println(countPairs(A, A.length, 6));
	}

	public static int countPairs(int[] A, int n, int sum) {
        /**
         * time complexity is O(n*n), if we want to speed it, we can sort the array
         * and use left and right pointer to find pair
         */
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (A[i] + A[j] == sum) {
					count++;
				}
			}
		}
		return count;
    }
}
