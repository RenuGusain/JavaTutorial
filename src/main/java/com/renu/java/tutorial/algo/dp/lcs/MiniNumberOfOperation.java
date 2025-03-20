package com.renu.java.tutorial.algo.dp.lcs;

public class MiniNumberOfOperation {
    // 583. Delete Operation for Two Strings
    public static void main(String[] args) {

        System.out.println(minDistance("jeap", "pea"));

    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                } else {
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }

}
