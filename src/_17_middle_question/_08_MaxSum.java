package _17_middle_question;

import java.util.*;

/**
 * greed[i] represent the max value ending with A[i]
 */
public class _08_MaxSum{

	public static void main(String[] args) {
//		int[] A = {1, 2, 3, -6, 1, 3, 4};
		int[] A = {-1, -2, -3};
		System.out.println(getMaxSum(A, A.length));
	}

	public static int getMaxSum(int[] A, int n) {
        int[] greed = new int[n];
        int max = A[0];
        greed[0] = A[0];
        for (int i = 1; i < A.length; i++) {
        	if (greed[i - 1] >= 0) {
        		greed[i] = greed[i - 1] + A[i];
        	} else {
        		greed[i] = A[i];
        	}
        	if (max <= greed[i]) {
        		max = greed[i];
        	}
        }
        for (int i = 0; i < greed.length; i++) {
        	System.out.print(greed[i] + " ");
        }
        System.out.println();
        return max;
    }
}
