package assignment2;

import java.util.Scanner;

public abstract class GroceryStoreBusiness {		//Part 2.4 Abstraction
	private String product, location, phoneno;												//Variables are privatized to prevent the variables to be access from other class
	
	Scanner scan = new Scanner(System.in);											//Part 1.2 Java pre-defined class of Scanner
	
	GroceryStoreBusiness(){															//Part 1.4 Constructor with no argument
		System.out.print("Please enter the products sold in the grocery store: ");
		product = scan.nextLine();
		System.out.print("Please enter the location of grocery store: ");
		location = scan.nextLine();
		System.out.print("Please enter the phone no of grocery store: ");
		phoneno = scan.nextLine();
		printInfo(product, location, phoneno);
	}
	
	GroceryStoreBusiness(String product){											//Part 1.4 Constructor with 1 argument
		System.out.println("Products sold: " + product);
		System.out.print("Please enter the location of grocery store: ");
		location = scan.nextLine();
		System.out.print("Please enter the phone no of grocery store: ");
		phoneno = scan.nextLine();
		printInfo(product, location, phoneno);
	}
	
	GroceryStoreBusiness(String product, String location){							//Part 1.4 Constructor with 2 argument
		System.out.println("Product sold: " + product);
		System.out.println("Location: " + location);
		System.out.print("Please enter the phone no of grocery store: ");
		phoneno = scan.nextLine();
		printInfo(product, location, phoneno);
	}
	
	public void printInfo(String product, String location, String phoneno) {						//Part 1.3 Method for user-defined class for printing out details of grocery store
		System.out.println();
		System.out.println("Grocery Store Details");
		System.out.println("Products Sold: " + product);
		System.out.println("Store Location: " + location);
		System.out.println("Phone number: " + phoneno);
	}
	
	public abstract void printInfo();		//Part 2.4 Abstract method
}
