package com.renu.java.tutorial.algo.leetcode.problems;

import java.util.Arrays;
import java.util.List;

public class LeetCode79 {
    public static void main(String[] args) {
        LeetCode79 problme = new LeetCode79();
        char board[][] = {{'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}};

        String word = "aaaaaaaaaaaaa";
        System.out.println("output:" + problme.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        final int r = board.length;
        final int c = board[0].length;
        boolean visited[][] = new boolean[r][c];


        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                Position position = new Position(i, j);


                boolean result = backtrack(board, word, visited, position);
                visited[i][j] = false;
                if (result) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean backtrack(char[][] board, String word, boolean[][] visited, Position currentPosition) {
        System.out.println(currentPosition);
        if (word.isEmpty()) {
            return true;
        }


        if (visited[currentPosition.row][currentPosition.col]) {
            //   System.out.println("Visitied");
            return false;
        }


        visited[currentPosition.row][currentPosition.col] = true;
        char currentLetter = word.charAt(0);
        if (!(board[currentPosition.row][currentPosition.col] == currentLetter)) {
            visited[currentPosition.row][currentPosition.col] = false;
            return false;
        }
        String remainingString = word.substring(1);
        //  System.out.println("remainingString:"+remainingString+" Length="+remainingString.length());
        if (remainingString.isEmpty()) {
            return true;
        }

        for (Direction dir : Direction.values()) {

            int newRow = currentPosition.row + dir.getRowChange();
            int newCol = currentPosition.col + dir.getColChange();

            Position position = new Position(newRow, newCol);
            if (!isInValid(position, board.length, board[0].length)) {

                boolean result = backtrack(board, remainingString, visited, position);
                //   System.out.println("String inside loop="+remainingString+" Length="+remainingString.length());
                if (result) return true;


            }


        }
        visited[currentPosition.row][currentPosition.col] = false;
        if (word.isBlank()) {
            return true;
        }
        return false;
    }

    public boolean isInValid(Position position, int n, int m) {
        if ((position.row >= n) || (position.col >= m)) {
            return true;
        }
        if (position.row < 0 || position.col < 0) {
            return true;
        }
        return false;
    }
}

class Position {
    int row;
    int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "Position{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}

enum Direction {
    LEFT(0, -1),
    RIGHT(0, 1),
    UP(-1, 0),
    DOWN(1, 0);
    private final int rowChange;
    private final int colChange;

    Direction(int rowChange, int colChange) {
        this.rowChange = rowChange;
        this.colChange = colChange;
    }

    public int getRowChange() {
        return rowChange;
    }


    public int getColChange() {
        return colChange;
    }
}


