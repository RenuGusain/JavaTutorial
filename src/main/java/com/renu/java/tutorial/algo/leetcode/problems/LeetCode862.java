package com.renu.java.tutorial.algo.leetcode.problems;
//862. Shortest Subarray with Sum at Least K
//https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/
public class LeetCode862 {
    public static void main(String[] args) {
        LeetCode862 code=new LeetCode862();
       int  nums[] = {2,-1,2};
        int k = 3;
        System.out.println( code.shortestSubarray(nums,k));
    }
    public int shortestSubarray(int[] nums, int k) {
        int min=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            int count=0;
            for(int j=i;j<n;j++)
            {
                count=count+nums[j];


                if(count>=k)
                {
                   int tem= j-i+1;
                    System.out.println("tem="+tem);
                 if(min>tem)
                 {
                     min=tem;
                 }
                   break;
                }


            }
        }
        if (min==Integer.MAX_VALUE)return -1;
        return min;

    }
}
