package com.renu.java.tutorial.algo.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LeetCode92 {
    public static void main(String[] args) {

    }


    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            Deque<Integer> stack = new ArrayDeque<>();
            ListNode current = head;
            int count = 1;
            ListNode leftNode = null;
            while (count <= right) {
                if (count >= left) {
                    if (leftNode == null) {
                        leftNode = current;
                    }
                    stack.push(current.val);
                }
                count++;
                current = current.next;

            }
            count = left;
            while (count <= right) {
                leftNode.val = stack.pop();
                leftNode = leftNode.next;
                count++;


            }
            return head;
        }
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

