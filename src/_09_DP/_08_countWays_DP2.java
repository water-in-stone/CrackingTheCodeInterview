package _09_DP;
import java.util.*;

public class _08_countWays_DP2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(makeChange(n));
        }
        sc.close();
    }

    //transform recursion to iteration, P233 shows how iteration exists
    public static int makeChange(int sum){
        int[] coins = {1, 5, 10, 25};
        int[] dp = new int[100001];       
        dp[0] = 1;
        for(int i = 0;i < 4;++i) {
            for (int j = coins[i]; j <= sum; ++j) {
                dp[j] = (dp[j] + dp[j - coins[i]]) % 1000000007;
            }
        }
        return dp[sum];
    }
}
