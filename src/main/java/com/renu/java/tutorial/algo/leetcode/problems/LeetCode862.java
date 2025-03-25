package com.renu.java.tutorial.algo.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

//862. Shortest Subarray with Sum at Least K
//https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/
public class LeetCode862 {
    public static void main(String[] args) {
        LeetCode862 code = new LeetCode862();
        int nums[] = {-28,81,-20,28,-29};


        int k = 89;
        System.out.println(code.shortestSubarray(nums, k));
    }

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1]; // Prefix sum array
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        Arrays.stream(prefixSum).forEach(ele-> System.out.print(ele+", "));
        System.out.println();

        Deque<Integer> queue = new ArrayDeque<>();
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            // Maintain the queue for the shortest valid subarray
            while (!queue.isEmpty() && prefixSum[i] - prefixSum[queue.getFirst()] >= k) {

                minLength = Math.min(minLength, i - queue.pollFirst());
                System.out.println("min length="+minLength);
            }

            // Maintain a monotonically increasing deque
            while (!queue.isEmpty() && prefixSum[i] <= prefixSum[queue.getLast()]) {
                queue.pollLast();
            }
            System.out.println("i= "+i);



            queue.addLast(i);
            queue.forEach(ele-> System.out.print(ele+","));
            System.out.println();
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
