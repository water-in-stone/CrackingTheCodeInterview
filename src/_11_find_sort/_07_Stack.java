package _11_find_sort;

import java.util.*;

/**
 * Created by Young on 2016/5/16.
 * wang645788@gmail.com
 */
public class _07_Stack {
    public static void main(String[] args) {
//        int[] men = {6, 1, 3, 4, 2, 20, 10, 11};
        int[] men = {13, 14, 10, 11, 12};
        System.out.println(getHeight(men, men.length));
    }

    public static int getHeight(int[] men, int n) {
        int[] dp = new int[n];// 到 i位置时候的最长递增子序列的长度
        dp[0] = 1;
        int longest = 0;
        for (int i = 1; i < n; i++) {
            int subLongest = 0;
            int subIndex = 0;
            // 找出 i 前面的 0-i-1个元素中 以 i个元素结束的递增子序列的最长的值
            while (subIndex < i) {
                if (men[subIndex] <= men[i])
                    //和以第 i-1、 i-2.....元素结尾的递增子序列值进行比较
                    subLongest = subLongest > dp[subIndex] ? subLongest : dp[subIndex];
                subIndex++;
            }
            dp[i] = subLongest + 1;
            longest = longest > dp[i] ? longest : dp[i];
        }
        return longest;
    }


}
