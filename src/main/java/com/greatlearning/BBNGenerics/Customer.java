package com.greatlearning.BBNGenerics;

public class Customer extends User {
	
	//Default Constructor
	public Customer() {
		super();
		this.setType("Customer");
	}
	
	//Parameterized Constructor
	public Customer(String name, String email, String phoneNumber) {
		super(name, email, phoneNumber);
		this.setType("Customer");
	}

}
