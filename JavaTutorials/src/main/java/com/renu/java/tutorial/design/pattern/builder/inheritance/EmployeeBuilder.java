package com.renu.java.tutorial.design.pattern.builder.inheritance;

public class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    protected String position;
    public EmployeeBuilder setPosition(String position)
    {
        this.position=position;
        return this;
    }
    public Employee build()
    {
        Employee e=new Employee();
        e.setName(this.name);
        e.setPosition(this.position);
        return e;
    }

    @Override
    protected EmployeeBuilder getSelf() {
        return this;
    }
}
