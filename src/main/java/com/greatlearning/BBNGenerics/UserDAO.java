package com.greatlearning.BBNGenerics;

import java.util.ArrayList;
import java.util.List;

public class UserDAO<T> {
	
	private List<T> users = new ArrayList<>();

	//Get a T Object from List
	public T getUser(String email) {
		User userObject;
		for(T user : users) {
			if(user instanceof User) {
				userObject= (User)user;
				if(userObject.getEmail().equals(email)) {
					return user;
				}
			}
		}
		return null;
	}
	
	//Adding a created user to a List
	public boolean create(T user) {
		return users.add(user);
	}
	
	//Removing user from a list
	public boolean remove(T user) {
		return users.remove(user);
	}
	
	//Update details of the user
	public boolean update(T user, String[] modifiedValues, int choiceOfUsertomodify) {
		User userObject = (User)user;
		boolean flag = false;
		if(choiceOfUsertomodify == 1 || choiceOfUsertomodify == 3) {
			userObject.setName(modifiedValues[0]);
			flag = true;
		}
		if(choiceOfUsertomodify == 2 || (choiceOfUsertomodify == 3 && flag)) {
			flag = false;
			userObject.setPhoneNumber(modifiedValues[1]);
			flag = true;
		}
		return flag;
	}
	
	//Displaying all the users
	public void display() {
		if(users.size() == 0)
			System.out.println("No users to display.");
		else {
			System.out.println("Displaying all the users:");
			for (T user : users) {
				System.out.println(user);
				System.out.println();
			}
		}
	}

}
