package com.renu.java.tutorial.performance;

import java.util.ArrayList;
import java.util.List;

public class GarbageCollectionExample {
    public static void main(String[] args) throws InterruptedException {

        Runtime runtime=Runtime.getRuntime();
        long availableMemory=runtime.freeMemory();
        System.out.println("Free momory at start "+availableMemory/1048576 +"MB");
        List<Customer>customers=new ArrayList<>();
        for(int i=0;i<1000000;i++)
        {
            customers.add(new Customer("Renu "));
        }
         availableMemory=runtime.freeMemory();
        System.out.println("Available memory when customer created "+availableMemory/1048576+"MB");
        customers=new ArrayList<>();
        availableMemory=runtime.freeMemory();
        System.out.println("Available memory when customer not loger refrenced "+availableMemory/1048576+"MB");
        Thread.sleep(10000);
        availableMemory=runtime.freeMemory();
        System.out.println("Memory after 1 sec:  "+availableMemory/1048576+"MB");
        System.gc();
        availableMemory=runtime.freeMemory();
        System.out.println("Memory after gc:  "+availableMemory/1048576+"MB");




    }
}
class Customer
{
    private String name;

    public Customer(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }
}
