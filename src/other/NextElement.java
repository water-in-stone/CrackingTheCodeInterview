package other;
/**
 * search from bottom to top
 */

import java.util.*;

public class NextElement {

    public static void main(String[] args) {
        int[] A = {11, 13, 10, 5, 12, 21, 3};
        int[] array = findNext(A, A.length);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static int[] findNext(int[] A, int n) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] result = new int[n];
        stack.push(-1);
        for (int i = n - 1; i >= 0; i--) {
            int val = stack.peek();
            while (val != -1 && val <= A[i]) {
                stack.pop();
                val = stack.peek();
            }
            result[i] = val;
            stack.push(A[i]);
        }
        return result;
    }

}