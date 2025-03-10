package com.renu.java.tutorial.design.principles.solid.ocp;

public interface Specification<T> {
    public boolean isSatisfied(T item);

}
