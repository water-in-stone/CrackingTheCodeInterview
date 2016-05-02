package _09_DP;
import java.util.*;

/**
 * still use recalling
 */
public class _09_nQueens{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			if (n <= 0) {
				System.exit(-1);
			}
			Integer[] columns = new Integer[n];
            for (int i = 0; i < columns.length; i++){
                columns[i] = -1;
            }
            ArrayList<Integer[]> result = new ArrayList<>();
			placeQueen(0, n, columns, result);
            System.out.println(result.size());
        }
		sc.close();
	}

	public static void placeQueen(int row, int gridSize, Integer[] columns, ArrayList<Integer[]> result){
		if (row == gridSize) {
			//why columns.clone()?
			result.add(columns.clone());
		} else {
			for (int i = 0; i < gridSize; i++) {
				if (checkValid(row, i, columns)) {
					//because one row exist only one queen, so wo use one-dimensional array to
					//storage the permutation
					columns[row] = i;
					placeQueen(row + 1, gridSize, columns, result);
				}
			}
		}
	}

	public static boolean checkValid(int row, int targetColumn, Integer[] columns){
        //check front rows!
		for (int row2 = 0; row2 < row; row2++) {
//		for (int row2 = 0; row2 < columns.length; row2++) {
			int column = columns[row2];

			//check two queens' column
			if (column == targetColumn) {
				return false;
			}

			//check if two queen is in one diagonal
			//the row and column spacing of tow queens
			int columnDistance = Math.abs(column - targetColumn);
			int rowDistance = Math.abs(row - row2);
			if (columnDistance == rowDistance) {
				return false;
			}
		}
		return true;
	}
}
