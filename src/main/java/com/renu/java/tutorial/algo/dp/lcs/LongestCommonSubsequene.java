package com.renu.java.tutorial.algo.dp.lcs;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestCommonSubsequene {

    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];
        for (int a[] : dp) {
            Arrays.fill(a, -1);
        }

        return LCSWithRecursion(text1, text2, text1.length(), text2.length(), dp);
    }

    public int LCSWithRecursion(String x, String y, int n, int m, int[][] dp) {
        if (m == 0 || n == 0) return 0;
        if(dp[n][m]!=-1)return dp[n][m];
        if (x.charAt(n - 1) == y.charAt(m - 1)) {
            return dp[n][m] = 1 + LCSWithRecursion(x, y, n - 1, m - 1, dp);
        } else {
            return dp[n][m] = Integer.max(LCSWithRecursion(x, y, n - 1, m, dp),
                    LCSWithRecursion(x, y, n, m - 1, dp));

        }
    }
}

