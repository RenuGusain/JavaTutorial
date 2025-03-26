package com.renu.java.tutorial.algo.leetcode.problems;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        Integer maxArea=Integer.MIN_VALUE;
        int n=height.length;
        int li=1;
        int ri=n;
        while (li<ri)
        {
            int left=height[li-1];
            int right=height[ri-1];
            int width=ri-li;

            if(left<right)
            {
                int area=left*width;
                maxArea=Math.max(maxArea,area);
                li++;
            } else if (right<left) {
                int area=right*width;
                maxArea=Math.max(maxArea,area);
                ri--;

            }
            else {
                int area=right*width;
                maxArea=Math.max(maxArea,area);
                ri--;
                li++;

            }
        }
        return maxArea;
    }
}
