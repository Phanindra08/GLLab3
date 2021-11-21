package com.greatlearning.BBNGenerics;

public class Employee extends User {
	
	//Default Constructor
	public Employee() {
		super();
		this.setType("Employee");
	}
		
	//Parameterized Constructor
	public Employee(String name, String email, String phoneNumber) {
		super(name, email, phoneNumber);
		this.setType("Employee");
	}

}
