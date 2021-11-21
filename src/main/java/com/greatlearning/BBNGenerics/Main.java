package com.greatlearning.BBNGenerics;

import java.util.Scanner;

public class Main {

	private static Scanner scan;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UserDAO<User> userDAO = new UserDAO<>();
		User user;
		String email = null;
		scan = new Scanner(System.in);
		char charToContinue = ' ';
		int choice = 0;
		do {
			System.out.println("1.Create\t2.Update\n3.Delete\t4.Display");
			System.out.print("Enter a number of your choice from above options:");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				if(userDAO.create(createUser(userDAO))) {
					System.out.println("User added Successfully.");
				} else {
					System.out.println("Failure to add user.");
				}
				break;
			case 2:
				if (updateUserDetails(userDAO))
					System.out.println("User Details got updated.");
				else
					System.out.println("User Details did not get updated.");
				break;
			case 3:
				System.out.print("Enter your Email Id:");
				scan.nextLine();
				email = scan.nextLine();
				user = userDAO.getUser(email);
				if (user != null)
					System.out.println(userDAO.remove(user) ? "The user has been successfully removed."
							: "Removing of the user failed.");
				else
					System.out.println("User with the email " + email + " does not exist.");
				break;
			case 4:
				scan.nextLine();
				userDAO.display();
				break;
			default:
				scan.nextLine();
				System.out.println("Enter a number between 1 to 4.");
				break;
			}
			System.out.println("Press enter to break.\nAny other key to continue.");
			charToContinue = scan.nextLine().charAt(0);
		} while (charToContinue != 'b');
		scan.close();
		System.out.println("Thank You for visiting the bank.");
	}

	public static User createUser(UserDAO<User> userDAO) {
		User user = null;
		int choiceOfUsertoCreate = 0;
		String email = "", name = "", phoneNumber = "";
		boolean userExists = false;
		System.out.println("1.Customer\t2.Employee\n3.Visitor");
		System.out.print("Select the choice of which user you want to create:");
		choiceOfUsertoCreate = scan.nextInt();
		scan.nextLine();
		if (choiceOfUsertoCreate >= 1 && choiceOfUsertoCreate <= 3) {
			do {
				System.out.print("Enter the email of the user:");
				email = scan.nextLine();
				userExists = userDAO.getUser(email) != null;
				if (userExists)
					System.out.println("A user with this email already exists. Please enter another email.");
			} while (userExists);
			System.out.print("Enter the name of the user:");
			name = scan.nextLine();
			System.out.print("Enter the phone number of the user:");
			phoneNumber = scan.nextLine();
			switch (choiceOfUsertoCreate) {
			case 1:
				user = new Customer(name, email, phoneNumber);
				break;
			case 2:
				user = new Employee(name, email, phoneNumber);
				break;
			case 3:
				user = new Visitor(name, email, phoneNumber);
				break;
			}
		} else {
			System.out.println("Enter a number between 1 to 3.");
		}
		return user;
	}

	public static boolean updateUserDetails(UserDAO<User> userDAO) {
		User user = null;
		String[] modifiedValues = { "", "" };
		int choiceOfUsertomodify = 0;
		String email = "";
		scan.nextLine();
		do {
			System.out.print("Enter the email of the user:");
			email = scan.nextLine();
			user = userDAO.getUser(email);
			if (user == null)
				System.out.println("There are no users with this email id. Please enter valid email.");
		} while (user == null);
		System.out.println("1.To modify name\t2.To modify phone number\n3.To modify both name and phone number.");
		System.out.print("Select the choice of the details you want to modify:");
		choiceOfUsertomodify = scan.nextInt();
		scan.nextLine();
		switch (choiceOfUsertomodify) {
		case 1:
			System.out.print("Enter the name of the user to be updated:");
			modifiedValues[0] = scan.nextLine();
			break;
		case 2:
			System.out.print("Enter the phone number of the user:");
			modifiedValues[1] = scan.nextLine();
			break;
		case 3:
			System.out.print("Enter the name of the user to be updated:");
			modifiedValues[0] = scan.nextLine();
			System.out.print("Enter the phone number of the user:");
			modifiedValues[1] = scan.nextLine();
			break;
		default:
			System.out.println("Enter a number between 1 to 3.");
			break;
		}
		return userDAO.update(user, modifiedValues, choiceOfUsertomodify);
	}

}
