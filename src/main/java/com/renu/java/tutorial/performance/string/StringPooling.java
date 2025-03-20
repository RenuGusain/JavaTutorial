package com.renu.java.tutorial.performance.string;

import java.util.ArrayList;
import java.util.List;

public class StringPooling {
    public static void main(String[] args) {
        List<String>a=new ArrayList<>();
        for(int i=1;i<10000000;i++)
        {
           String s=String.valueOf(i);
          a.add(s);
        }

    }
}
