package com.renu.java.tutorial.algo.leetcode.problems;

import java.util.*;

public class LeetCode212 {


    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                node = node.children.computeIfAbsent(ch, c -> new TrieNode());
            }
            node.word = word;  // Mark the end of the word
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {

        Set<String> result = new HashSet<>();
        TrieNode root = buildTrie(words);

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        // Explore every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, i, j, root, result, visited);
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, Set<String> result, boolean[][] visited) {
        int rows = board.length;
        int cols = board[0].length;

        // Boundary or already visited
        if (i < 0 || j < 0 || i >= rows || j >= cols || visited[i][j]) return;

        char ch = board[i][j];
        if (!node.children.containsKey(ch)) return;

        visited[i][j] = true;
        node = node.children.get(ch);

        if (node.word != null) {
            result.add(node.word);  // Found a valid word
            // Optional: set node.word = null to avoid duplicates
        }

        // Explore in 4 directions
        dfs(board, i + 1, j, node, result, visited);
        dfs(board, i - 1, j, node, result, visited);
        dfs(board, i, j + 1, node, result, visited);
        dfs(board, i, j - 1, node, result, visited);

        visited[i][j] = false;  // Backtrack
    }

    static class TrieNode {
        TrieNode root;

        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;


    }
}
