 // package _09_DP;
import java.util.*;

/**
 * using DP to solve it 
 * consider state transition equation
 * 1...
 * 2...
 * 3...
 */
public class _02_robot_using_DP{

	public static void main(String[] args) {
		int[][] map ={{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,0,1,1},{0,1,1,1},{1,1,1,1},{1,1,1,1}};
        System.out.println(countWays(map, 11, 4));
	}

	public static int countWays(int[][] map, int x, int y) {
		int[][] dp = new int[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (map[i][j] != 1) continue;
				if(i == 0 && j == 0) dp[i][j] = 1;
				if(i != 0 && j == 0) dp[i][j] = dp[i - 1][j];
				if(j != 0 && i == 0) dp[i][j] = dp[i][j - 1];
				if(i > 0 && j > 0){
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];					
				}
			}
        } 
        for (int i = 0; i < dp.length; i++) {
        	for (int j = 0; j < dp[i].length; j++) {
        		System.out.print(dp[i][j] + " ");
        	}
        	System.out.println(" ");
        }
        return dp[x - 1][y - 1];       
    }
}
