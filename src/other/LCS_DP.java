package other;
import java.util.*;

/**
 * solved with DP
 */
public class LCS_DP{

	private static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s1 = sc.nextLine();
			String s2 = sc.nextLine();
			System.out.println(getLCS_DP(s1, s2));
		}
		sc.close();
	}

    /**
     * 这里，我们使用dp[i][j]表示 以x[i]和y[j]结尾的最长公共子串的长度，因为要求子串连续，
     * 所以对于X[i]与Y[j]来讲，
     * 它们要么与之前的公共子串构成新的公共子串；要么就是不构成公共子串。故状态转移方程
     * X[i] == Y[j]，dp[i][j] = dp[i-1][j-1] + 1
     * X[i] != Y[j]，dp[i][j] = 0
     * 对于初始化，i==0或者j==0，如果X[i] == Y[j]，dp[i][j] = 1；否则dp[i][j] = 0。
     * @param s1
     * @param s2
     * @return 最长子串
     */
	public static String getLCS_DP(String s1, String s2){
		int length1 = s1.length();
		int length2 = s2.length();
		int maxLength = 0;
		int index = 0;
		dp = new int[length1][length2];
		for (int i = 0; i < length1; i++) {
			for (int j = 0; j < length2; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					if (i > 0 && j > 0) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					}
					if (i == 0 || j == 0) {
						dp[i][j] = 1;
					}
                    //保存最大长度时字符串的下标
					if (maxLength < dp[i][j]) {
						maxLength = dp[i][j];
						index = length1 - maxLength;
					}
				}
			}
		}
		if (maxLength == 0) {
			return "";
		} else {
			return s1.substring(index, index + maxLength);
		}
	}

}
