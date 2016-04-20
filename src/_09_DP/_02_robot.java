 // package _09_DP;
import java.util.*;

/**
 * 1、依然是用递归来计算
 * 2、对于输入i, j 计算ways[i, j - 1] + ways[i - 1, j]
 */
public class _02_robot{

	public static void main(String[] args) {
		System.out.println(countWays(3, 3));
	}

	public static int countWays(int x, int y) {
        if (x < 0 || y < 0) {
            System.exit(0);
        }
        if (x == 0 || y == 0) {
            return 1;                
        }            
        int[][] ways = new int[x][y];
        //set first line 1
        for (int i = 1; i < ways[0].length; i++) {
            ways[0][i] = 1;
        }
        //set first column 1
        for (int i = 1; i < ways.length; i++) {
            ways[i][0] = 1;
        }
        for (int i = 1; i < x; i++) {
        	for (int j = 1; j < y; j++) {
                ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
        	}
        }
        return ways[x - 1][y - 1];
    }
}
