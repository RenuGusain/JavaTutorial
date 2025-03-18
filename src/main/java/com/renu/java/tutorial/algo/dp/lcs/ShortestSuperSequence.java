package com.renu.java.tutorial.algo.dp.lcs;

public class ShortestSuperSequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        StringBuilder sb = new StringBuilder("");
        int m = str1.length();
        int n = str2.length();
        int[][] dp = getLCSLenght(str1, str2, m, n);
//Print the SCS
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else {

                if (dp[i - 1][j] > dp[i][j - 1]) {
                    sb.append(str1.charAt(i - 1));

                    i--;

                } else {
                    sb.append(str2.charAt(j - 1));
                    j--;
                }
            }
        }
        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }
        return sb.reverse().toString();
    }

    private  int[][] getLCSLenght(String str1, String str2, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
                }

            }
        }
        return dp;
    }

}
