package com.renu.java.tutorial.algo.leetcode.problems;

import java.util.Arrays;

public class LeetCode80 {
    public static void main(String[] args) {
        int nums[] ={0,0,1,1,1,1,2,3,3};
        removeDuplicates(nums);

    }
    public static int removeDuplicates(int[] nums) {
        int l = 0; // Slow pointer for the position to place elements
        int count = 1; // Track occurrences of the current element

        for (int r = 1; r < nums.length; r++) {
            if (nums[r] == nums[r - 1]) {
                count++; // Increment count if it's the same as the previous
            } else {
                count = 1; // Reset count for a new number
            }

            if (count <= 2) { // Allow at most 2 occurrences
                l++;
                nums[l] = nums[r]; // Move valid elements forward
            }

            // Debugging output
            System.out.println("i=" + r + ", l=" + l + ", count=" + count + ", current=" + nums[r]);
            Arrays.stream(nums).forEach(w -> System.out.print(w + ","));
            System.out.println();
        }

        return l + 1; // The new length of the array
    }
}
