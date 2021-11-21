package com.greatlearning.BBNGenerics;

import java.util.Objects;

public class User {
	
	private String name;
	private String email; //Used as Primary Key
	private String phoneNumber;
	private String type;
	
	//Default Constructor
	public User() {
		super();
		this.name = "";
		this.email = "";
		this.phoneNumber = "";
	}
	
	//Parameterized Constructor
	public User(String name, String email, String phoneNumber) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	//Getters and Setters for the attributes
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "\tThe User name is " + this.name 
				+ ".\n\tThe contact details of the user are:\n\t\t"
				+"Email Id: " + this.email 
				+ ".\n\t\tPhone Number: " + this.phoneNumber 
				+ ".\n\tThe user is of type " + this.type + ".";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, name, phoneNumber, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(type, other.type);
	}
	

}
