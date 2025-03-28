package com.renu.java.tutorial.algo.leetcode.problems;

public class LeetCode122 {
    public static void main(String[] args) {
        int prices[]={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
         final int size=prices.length;
        int profit=0;
        int previous=prices[0];
        for(int i=1;i<size;i++)
        {
            int current=prices[i];
            if(previous<current)
            {
                profit=profit+(current-previous);
            }

                previous=current;


        }
        return profit;


    }
}
