package _09_DP;
import java.util.*;

//force solution, time complexity is not ok
public class _08_countWays_DP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] coins = {1, 5, 10, 25};
            System.out.println(makeChange(n, coins));
        }
        sc.close();
    }


    public static int makeChange(int n, int[] coins){
        int length = coins.length;
        int[][] dp = new int[length + 1][n + 1];
        //init dp matrix
        for (int i = 0; i < length + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = 0;
                for (int k = 0; k <= j / coins[i - 1]; k++) {
                    dp[i][j] += dp[i - 1][j - k * coins[i - 1]];
                }
            }
        }
        return dp[length][n];
    }
}
