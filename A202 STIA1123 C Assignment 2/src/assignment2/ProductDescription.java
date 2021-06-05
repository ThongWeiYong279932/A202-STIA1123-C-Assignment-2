package assignment2;

import java.util.Scanner;

public class ProductDescription extends GroceryStoreBusiness {			//Part 2.1 Inheritance of class GroceryStoreBusiness
	private String[] name = new String[100];				//Variables and arrays are privatized to prevent the variables and arrays to be access from other class
	private double[] price = new double[100];
	private char respond;
	
	Scanner scan = new Scanner(System.in);										//Part 1.2 Java pre-defined class of Scanner
	
	ProductDescription(){																	//Part 1.4 Constructor with no argument
		super();
		int i = 0;
		do {
			System.out.print("Please enter the product name: ");
			this.name[i] = scan.next();scan.nextLine();
			System.out.print("Please enter the price per kg of the product: RM");
			this.price[i] = scan.nextDouble();
			i++;
			System.out.print("Is there any other product? (y-yes, n-no): ");
			respond = scan.next().charAt(0);
			while(respond != 'y' && respond != 'n') {
				System.out.println("Wrong input! Please enter y for yes and n for no only!");
				System.out.print("Is there any other product? (y-yes, n-no): ");
				respond = scan.next().charAt(0);
			}
		} while (respond == 'y' && i < this.name.length);
		printInfo();
	}
	
	ProductDescription(String[] name){													//Part 1.4 Constructor with 1 argument
		super();
		this.name = name;
		for (int i = 0; i < name.length; i++) {
			System.out.print("Please enter the price per kg of " + this.name[i] + ": RM");
			this.price[i] = scan.nextDouble();			
		}
		printInfo();
	}
	
	ProductDescription(String[] name, double[] price){									//Part 1.4 Constructor with 2 argument
		super();
		this.name = name;
		this.price = price;
		printInfo();
	}
	
	public void printInfo() {						//Part 2.2 Polymorphism of method printInfo
		System.out.println();
		System.out.println("Products Details");
		for (int i = 0; i < this.name.length; i++) {
			if (name[i] != null) {
				System.out.println();
				System.out.println("Product " + (i+1) + ": " + this.name[i]);
				System.out.printf("Price per kg: RM%.2f%n",this.price[i]);
			}
		}
	}
}
