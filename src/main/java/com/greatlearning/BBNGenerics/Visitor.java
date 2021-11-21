package com.greatlearning.BBNGenerics;

public class Visitor extends User {
	
	//Default Constructor
	public Visitor() {
		super();
		this.setType("Visitor");
	}
		
	//Parameterized Constructor
	public Visitor(String name, String email, String phoneNumber) {
		super(name, email, phoneNumber);
		this.setType("Visitor");
	}

}
