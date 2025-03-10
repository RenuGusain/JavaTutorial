package com.renu.java.tutorial.design.pattern.builder.inheritance;

public class Employee extends Person {
    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "position='" + position + '\'' +
                "name='" + getName() + '\'' +
                '}';
    }
}
