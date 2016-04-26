package _09_DP;

import java.util.*;

/**
 * every element have two state, which is in subset(represented by binary 1)
 * not in subset (represented by binary 0), so we can express every subset by
 * number. n elements have 2^n subset.
 */
public class _04_Subset {

    public static void main(String[] args) {
        int[] A = {123, 456, 789};
        //using dynamic array
        ArrayList<ArrayList<Integer>> result = getSubsets(A, A.length);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    }

    public static ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
        int max = 1 << n;
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        for (int i = max - 1; i > 0; i--) {
            subsets.add(convertToSet(i, A));
        }
        return subsets;
    }

    /**
     * convert int to set
     *
     * @return [ArrayList]
     */
    public static ArrayList<Integer> convertToSet(int n, int[] A) {
        ArrayList<Integer> subset = new ArrayList<>();
        int index = 0;
        for (int i = n; i > 0; i >>= 1) {
            if ((i & 1) == 1) {
                subset.add(A[index]);
            }
            index++;
        }
        //lambda express in Java 1.8
        subset.sort((Integer a, Integer b) -> b - a);
        return subset;
    }
}