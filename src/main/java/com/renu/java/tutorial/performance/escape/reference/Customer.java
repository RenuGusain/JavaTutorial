package com.renu.java.tutorial.performance.escape.reference;

public class Customer {
	private String name;

	public String getName() {
		return name;
	}

	public Customer(String name) {
		this.name = name;
	}
	
		public String toString() {
		return name;
	}
	
}
