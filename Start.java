package sample;


import java.util.Scanner;
import java.util.ArrayList;

import sample.ItemType;
import sample.Machine;
import sample.Recycle;

public class Start{
	
	static String Username;
    static String Password;
    static Machine machine = new Machine();
	
	public static void main (String[] args) {
		
		Username = "admin";
		Password = "admin";
		
		int choice = 0;
		
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		Scanner input3 = new Scanner(System.in);
		Scanner login = new Scanner(System.in);
		Scanner pass = new Scanner(System.in);
		
		
		System.out.print(" ----------------------------------------"
				   + "\n	Welcome to recycling system  "
				   + "\n ---------------------------------------"
				   + "\n\nPress 0 to login as admin"
				   + "\nPress 1 to recycle items"
				   + "\nPress 2 to clear recycle items list"
				   + "\nPress 3 to print receipt"
				   + "\nChoose: ");
		
		choice = input.nextInt();
		
		switch (choice) {
			
		
			case 0:
				System.out.println("Enter Username : ");
			    String username = login.nextLine();
			    System.out.println("Enter Password : ");
			    String password = pass.nextLine();
			    if (username.equals(Username) && password.equals(Password)) {
			    	System.out.println("Access Granted! Welcome!");
			    	adminPage();
			    }else {
			        System.out.println("Invalid Username or Password!");
			        main(args);
			    }
			break;
			case 1:
				System.out.println("Which item would you like to recycle?");
				machine.showTypeList();
				System.out.println("Input type name: ");
				String typeName = input2.nextLine();
				System.out.println("How many kgs?");
				double weight = input.nextInt();
				machine.addRecycleItem(typeName, weight);
				main(args);
				break;
			case 2:
				machine.clearRecycleItemList();
				System.out.println("Machine has been emptied!");
				main(args);
				break;
				
			case 3: 
				machine.printReceipt();
				break;
			default:
	    		System.out.println("Wrong option! Please try again.");
	    		main(args);
	    		
				
		}
		
		}

	
	
	public static void adminPage() {
		
		
		
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		Scanner input3 = new Scanner(System.in);
	
		
		int adminChoice = 0;
		
		
		
	    
	    	System.out.println(
	    			"\nPress 1 to add new item type"
	    			+ "\nPress 2 to see existing item types "
	    			+ "\nPress 3 to clear item type list "
	    			+ "\nPress 4 to log out");
	    	adminChoice = input.nextInt();
	    	switch (adminChoice) {
	    	case 1:
	    		System.out.println("Input item type name: ");
				String Name = input2.nextLine();
				System.out.println("Input new item type price:");
				double Price = input.nextInt();
				System.out.println("Input new item type weight:");
				double Weight = input.nextInt();
				machine.newItemType(Name, Price, Weight);
				adminPage();
				break;
	    	case 2:
	    		machine.showTypeList();
	    		adminPage();
				break;
	    	case 3:
	    		machine.clearItemTypeList();
	    		System.out.println("The machine is now empty!");
	    		adminPage();
				break;
	    	case 4:
	    		System.out.println("You've been successfully logged out");
	    		main(null);
	    		break;
	    	default:
	    		System.out.println("Wrong option! Please try again.");
	    		adminPage();
	    		
	    	}
	    
		
		
	}

		
		
}
	



