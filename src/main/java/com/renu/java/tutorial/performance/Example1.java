package com.renu.java.tutorial.performance;

import java.util.ArrayList;
import java.util.List;

public class Example1 {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        while (true) {
            Customer c = new Customer("Renu");
            customers.add(c);
            if (customers.size() > 10000) {
                for (int i = 0; i < 5000; i++) {
                    customers.remove(0);
                }
            }
        }
    }
}
