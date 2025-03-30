package com.renu.java.tutorial.algo.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode17 {
    private static final String[] LETTERS = {
            "",    "",    "abc", "def",  // 0,1,2,3
            "ghi", "jkl", "mno", "pqrs", // 4,5,6,7
            "tuv", "wxyz"                // 8,9
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();

        List<String> result = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder sb, List<String> result) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String letters = LETTERS[digits.charAt(index) - '0']; // Direct array lookup
        for (char c : letters.toCharArray()) {
            sb.append(c);
            backtrack(digits, index + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1); // Backtrack
        }
    }
}
