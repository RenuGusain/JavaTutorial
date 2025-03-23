package com.renu.java.tutorial.algo.leetcode.problems;

import java.util.*;

public class LeetCode2014 {
    public static void main(String[] args) {
        LeetCode2014 ob=new LeetCode2014();
       String result= ob.longestSubsequenceRepeatedK("bbabbabbbbabaababab",3);
        System.out.println(result);
    }
    public String longestSubsequenceRepeatedK(String s, int k) {
      int len=s.length();
        Map<Character,Integer>frequency=new HashMap<>();
        List<Character>candidates=new ArrayList<>();


        for(int i=0;i<len;i++)
        {
            Character c=s.charAt(i);
            frequency.merge(s.charAt(i),1,Integer::sum);
            if(frequency.get(c)==k)
            {
                candidates.add(c);
            }
        }

        Queue<String>queue=new LinkedList<>();
        queue.offer("");
        String best="";
       while (!queue.isEmpty())
       {
           System.out.println(queue);
           String current=queue.poll();
           for (Character c:candidates)
           {

               String newSeq=current+c;
               if(isRepeating(newSeq,s,k))
               {
                   queue.offer(newSeq);
                   if (newSeq.length() > best.length()||
                           (newSeq.length() == best.length() && newSeq.compareTo(best) > 0))
                   {
                       best=newSeq;
                   }
               }

           }
       }
        return best;



    }

    private boolean isRepeating(String sub, String s, int k) {
        String repeatedSub = sub.repeat(k);
        int index = 0;
        for (char c : s.toCharArray()) {
            if (index < repeatedSub.length() && c == repeatedSub.charAt(index)) {
                index++;
            }
            if (index == repeatedSub.length()) return true;
        }
        return false;
    }
}
