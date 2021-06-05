package assignment2;

import java.util.Scanner;

public class InventoryManagement extends Finance {			//Part 2.1 Inheritance of class Finance
	private String[] name = new String[100];					//Variables and arrays are privatized to prevent access from other class
	private int[] amount = new int[100];
	private double[]value = new double[100];
	private double[] totalperproduct = new double[100];
	private char respond;
	private double totalinventory;
	
	Scanner scan = new Scanner(System.in);						//Part 1.2 Java pre-defined class of Scanner
	
	InventoryManagement(){										//Part 1.4 Constructor with no argument
		super();
		int i=0;
		do {
			System.out.print("Please enter the name of products in the inventory: ");
			this.name[i]= scan.next();scan.nextLine();
			System.out.print("Please enter the amount of products in the inventory: ");
			this.amount[i] = scan.nextInt();
			System.out.print("Please enter the value per products in the inventory: RM");
			this.value[i] = scan.nextDouble();
			i++;
			System.out.print("Is there any other products in the inventory? (y-yes n-no): ");
			respond = scan.next().charAt(0);
			while(respond != 'y' && respond != 'n') {
				System.out.println("Wrong input! Please enter y for yes or n for no only!");
				System.out.print("Is there any other products in the inventory? (y-yes n-no): ");
				respond = scan.next().charAt(0);
			}
		}while(respond == 'y' && i < this.name.length);
		setTotalValuePerProduct(this.amount, this.value);
		setTotalInventory(this.totalperproduct);
		getTotalValuePerProduct();
		getTotalInventory();
		printInfo();
	}
	
	InventoryManagement(String[] name){						//Part 1.4 Constructor with 1 argument
		super();
		this.name = name;
		for(int i = 0; i < this.name.length; i++) {
			System.out.print("Please enter the amount of " + this.name[i] + " in the inventory: ");
			this.amount[i] = scan.nextInt();
			System.out.print("Please enter the value per " + this.name[i] + " in the inventory: RM");
			this.value[i] = scan.nextDouble();
		}
		setTotalValuePerProduct(this.amount, this.value);
		setTotalInventory(this.totalperproduct);
		getTotalValuePerProduct();
		getTotalInventory();
		printInfo();
	}
	
	InventoryManagement(String[] name, double[] value){		//Part 1.4 Constructor with 2 argument
		super();
		this.name = name;
		this.value = value;
		this.amount = new int[this.name.length];
		for (int i = 0; i < this.name.length; i++) {
			System.out.print("Please enter amount of " + this.name[i] + " in the inventory: ");
			this.amount[i] = scan.nextInt();
		}
		setTotalValuePerProduct(this.amount, this.value);
		setTotalInventory(this.totalperproduct);
		getTotalValuePerProduct();
		getTotalInventory();
		printInfo();
	}
	
	void setTotalValuePerProduct(int[]amount, double[] value) {		//Part 2.3 Encapsulation, Setter method
		this.totalperproduct = new double[amount.length];
		for(int i = 0; i < amount.length; i++) {
			this.totalperproduct[i] = amount[i] * value[i];
		}
	}
	
	void setTotalInventory(double[] totalperproduct) {				//Part 2.3 Encapsulation, Setter method
		for (int i = 0; i < totalperproduct.length; i++) {
			this.totalinventory += totalperproduct[i];
		}
	}
	
	double[] getTotalValuePerProduct() {			//Part 2.3 Encapsulation, Getter method
		return this.totalperproduct;
	}
	
	double getTotalInventory() {			//Part 2.3 Encapsulation, Getter method
		return this.totalinventory;
	}
	public void printInfo() {		//Part 2.2 Polymorphism of method printInfo
		System.out.println();
		System.out.println("Inventory");
			for(int i = 0; i < this.name.length; i++) {
				if(this.name[i] != null) {
					System.out.println();
					System.out.println("Inventory product " + (i+1) + ": " + this.name[i]);
					System.out.println("Amount of product: " + this.amount[i]);
					System.out.printf("Value per product: RM%.2f%n",this.value[i]);
					System.out.printf("Total value for product: RM%.2f%n",this.totalperproduct[i]);
				}
			}
			System.out.println();
			System.out.printf("Total Inventory: RM%.2f%n",this.totalinventory);
	}
}
