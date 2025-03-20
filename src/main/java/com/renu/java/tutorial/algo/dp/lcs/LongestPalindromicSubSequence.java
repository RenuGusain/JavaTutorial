package com.renu.java.tutorial.algo.dp.lcs;

public class LongestPalindromicSubSequence {
    public int longestPalindromeSubseq(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        int result = lcs(s, reversed, s.length(), reversed.length());
        return result;

    }

    int lcs(String a, String b, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m ][n ];
    }
}
