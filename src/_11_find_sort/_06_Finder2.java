 package _11_find_sort;

/**
 * diagonal number is always bigger than the sub matrix, so we could move
 * col or row to find the given number
 * Created by Young on 2016/5/16.
 * wang645788@gmail.com
 */
public class _06_Finder2 {
    public static void main(String[] args) {
    	int[][] mat = {{1, 2, 10}, {6, 9, 12}, {10, 11, 17}, {14, 20, 21}};
    	int[] result  = findElement(mat, 4, 3, 21);
    	System.out.println(result[0]);
    	System.out.println(result[1]);
    }

    public static int[] findElement(int[][] mat, int n, int m, int x) {
    	int row = 0;
        int col = m - 1;
        int[] result = new int[2];
        while (col >= 0 && row <= n){
            if (mat[row][col] == x) {
                result[0] = row;
                result[1] = col;
                return result;
            } else if (mat[row][col] > x) {
                col--;
            } else {
                row++;
            }
        }
        return result;
    }
}
