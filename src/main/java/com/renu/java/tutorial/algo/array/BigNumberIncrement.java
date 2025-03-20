package com.renu.java.tutorial.algo.array;

import java.util.ArrayList;
import java.util.List;

public class BigNumberIncrement {
    public static void main(String[] args) {
        int a[]={9,9,9};
        int n=a.length;
        List<Integer>result=new ArrayList<>();
        int c=0;
        int lstDigit=(a[n-1]+1)%10;
        c=(a[n-1]+1)/10;
        result.add(lstDigit);
        for(int i=n-2;i>=0;i--)
        {
            int current=(a[i]+c)%10;
            c=(a[i]+c)/10;
            result.add(current);

        }
        if(c!=0)
        {
            result.add(c);
        }
        StringBuilder op=new StringBuilder();
        for (int i=result.size()-1;i>=0;i--)
        {
            op.append(result.get(i));

        }
        System.out.println("Increment of number= "+op.toString());
    }
}
