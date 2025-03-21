package com.renu.java.tutorial.algo.leetcode.problems;

public class ZigzagConversion {
    public static void main(String[] args) {
        System.out.println(convert("A", 1));

    }

    public static String convert(String s, int numRows) {
        if(numRows<2)
        {
            return s;
        }
        int dist1=numRows*2-2;
        int dist2=2;
        int length=s.length();
        int current=0;
        StringBuilder sb=new StringBuilder();
        while (current<length)
        {
            sb.append(s.charAt(current));
            current=current+dist1;
        }
        dist1=dist1-2;
      for(int i=1;i<numRows-1;i++)
      {
          current=i;
          boolean flag=true;
          while (current<length)
          {
              sb.append(s.charAt(current));
              if(flag)
              {
                  current=current+dist1;

              }
              else
              {
                  current=current+dist2;
              }
              flag=flag?false:true;


          }
          dist1=dist1-2;
          dist2=dist2+2;

      }
      current=numRows-1;
        while (current<length)
        {
            sb.append(s.charAt(current));
            current=current+dist2;
        }
        return sb.toString();


    }

}
