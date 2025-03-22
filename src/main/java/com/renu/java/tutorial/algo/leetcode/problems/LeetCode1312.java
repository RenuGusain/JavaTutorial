package com.renu.java.tutorial.algo.leetcode.problems;

public class LeetCode1312 {
    public int minInsertions(String s) {
        int l = s.length();
        String reverse=new StringBuilder(s).reverse().toString();
        int lcs=lcs(s,reverse);
        return l-lcs;


    }

    public int lcs(String a, String b) {
        int l1 = a.length();
        int l2 = b.length();
        int t[][] = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                {
                    t[i][j]=t[i-1][j-1]+1;
                }
                else {
                    t[i][j]=Integer.max(t[i][j-1],t[i-1][j]);
                }

            }
        }
        return t[l1][l2];
    }
}
