package com.renu.java.tutorial.algo.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetCode18 {
    public static void main(String[] args) {
        leetCode18 obj=new leetCode18();
        int nums[]={2,2,2,2};
        int target=8;
        List<List<Integer>> result = obj.fourSum(nums, target);
        result.forEach((a)-> {System.out.print(a);
            System.out.println();
        });


    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>result=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,0,new ArrayList<>(),result,0,target);
        return result;



    }

    private void backtrack(int[] nums, int index, List<Integer> tempList, List<List<Integer>> result, long sum, int target) {
        if (tempList.size() == 4) {
            if (sum == target) {
                result.add(new ArrayList<>(tempList));
            }
            return;
        }
        if (index >= nums.length) return;

        for (int i = index; i < nums.length; i++) {
            // Skip duplicate elements to avoid redundant results
            if (i > index && nums[i] == nums[i - 1]) continue;

            tempList.add(nums[i]);
            backtrack(nums, i + 1, tempList, result, sum + nums[i], target);
            tempList.remove(tempList.size() - 1); // Backtrack step
        }
    }
}
