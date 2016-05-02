package _09_DP;
import java.util.*;

//comprehend DP
public class _08_countWays_DP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();

            System.out.println(makeChange(n));
        }
        sc.close();
    }


    public static int makeChange(int sum){
        int[] coins = {1, 5, 10, 25};
        int length = 4;
        int[][] dp = new int[length + 1][sum + 1];
        //init dp matrix
        for (int i = 0; i < length + 1; i++) {
            dp[i][0] = 1;
        }

        // iteration: dp[i][j] = sum(dp[i-1][j - k*coins[i-1]])
        // k = 0, 1, 2, ... , j / coins[i-1]
        for (int i = 1; i <= length; i++) {
            //start from index 1
            for (int j = 1; j <= sum; j++) {
                for (int k = 0; k <= j / coins[i - 1]; k++) {
                    dp[i][j] += dp[i - 1][j - k * coins[i - 1]] % 1000000007;
                }
            }
        }

        return dp[length][sum];
    }
}
