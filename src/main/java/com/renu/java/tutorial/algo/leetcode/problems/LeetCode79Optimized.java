package com.renu.java.tutorial.algo.leetcode.problems;

public class LeetCode79Optimized {
    public boolean exist(char[][] board, String word) {
        final int r = board.length;
        final int c = board[0].length;
        if (word.length() > r * c) return false;
        boolean visited[][] = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (solve(board, i, j, word, visited, 0, r, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean solve(char[][] board, int i, int j, String word, boolean[][] visited, int k, int n, int m) {
        if (word.length() == k) return true;
        if (i ==n || j == m) return false;
        if (i < 0 || j < 0) return false;
        if (visited[i][j]) return false;


        if (word.charAt(k) == board[i][j]) {
            visited[i][j] = true;
            if (solve(board, i + 1, j, word, visited, k + 1, n, m) ||
                    solve(board, i - 1, j, word, visited, k + 1, n, m) ||
                    solve(board, i, j + 1, word, visited, k + 1, n, m) ||
                    solve(board, i, j - 1, word, visited, k + 1, n, m))
                return true;
            visited[i][j] = false;


        }
        return false;

    }


}
