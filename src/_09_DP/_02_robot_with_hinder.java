package _09_DP;
import java.util.*;

//warning:using DP to solve it is elegant

public class _02_robot_with_hinder{

	public static void main(String[] args) {
        int[][] map = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,0,1,1},{0,1,1,1},{1,1,1,1},{1,1,1,1}};
        System.out.println(countWays(map, 11, 4));
	}

	public static int countWays(int[][] map, int x, int y) {
        //judege exception
        if (x < 0 || y < 0) {
            System.exit(0);
        }
        if (x == 0 || y == 0) {
            return 1;                
        }            
        int[][] ways = new int[x][y];
        //set first line according to map
        for (int i = 0; i < ways[0].length; i++) {
            if (map[0][i] == 1) {
                ways[0][i] = 1;
            } else {
                for (int j = i; j < ways[0].length; j++) {
                    ways[0][i] = 0;                
                }            
                break;
            }
        }
        //set first column according to map
        for (int i = 0; i < ways.length; i++) {
            if (map[i][0] == 1) {
                ways[i][0] = 1;
            } else {
                for (int j = i; j < ways.length; j++) {
                    ways[j][0] = 0;                
                }            
                break;
            }
        }
        for (int i = 1; i < x; i++) {
        	for (int j = 1; j < y; j++) {
                if (map[i][j] == 1) {
                    ways[i][j] = (ways[i - 1][j] + ways[i][j - 1]) % 1000000007;
                } else {
                    ways[i][j] = 0;                
                }
        	}
        }
        return ways[x - 1][y - 1];
    }
}
