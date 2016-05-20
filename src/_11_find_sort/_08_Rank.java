package _11_find_sort;

/**
 * we can use a array to storage all the number, and make the array sorted,
 * then we can use binary search to get rank, but when want to insert
 * number, the performance is so bad. so we use BST to solve it.
 * BST = ordered Vector + List.
 */
public class _08_Rank {

    public static Node root;

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7};
        int[] result = getRankOfNumber(A, 7);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] getRankOfNumber(int[] A, int n) {
        int[] result = new int[n];
        for (int i = 0; i < A.length; i++) {
            result[i] = getRank(A[i]);
        }
        return result;
    }

    public static int getRank(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            root.insert(val);
        }
        return root.getRank(val);
    }
}

class Node {

    Node left, right;
    int val;
    //the number of left child;
    int leftSize = 0;

    Node(int val) {
        this.val = val;
    }

    public void insert(int n) {
        if (n <= val) {
            if (left == null) {
                left = new Node(n);
            } else {
                left.insert(n);
            }
            leftSize++;
        } else {
            if (right == null) {
                right = new Node(n);
            } else {
                right.insert(n);
            }
        }

    }

    public int getRank(int n) {
        if (n == val) {
            return leftSize;
        } else if (n < val) {
            return left.getRank(n);
        } else {
            //plus left size and current Node
            return leftSize + 1 + right.getRank(n);
        }
    }
}

