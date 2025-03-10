package com.renu.java.tutorial.design.pattern.builder.inheritance;

public class BuilderDemoWithInheritance {
    public static void main(String[] args) {
        Employee employee=new EmployeeBuilder().setName("Renu").setPosition("SSE3").build();
        System.out.println("employee=="+employee.toString());
        Person person=new PersonBuilder<>().setName("Renu").build();
        System.out.println(person);
    }
}
