package assignment2;

import java.util.Scanner;

public class Customer extends GroceryStoreBusiness implements Payment{			//Part 2.1 Inheritance of class GroceryStoreBusiness //Part 2.5 Implementing Interface of Payment
	private String name;					//Variables and arrays are privatized to prevent access from other class
	private int amount;
	private double price;
	private double totalprice;
	private double payment;
	private double change;
	private double[] totalpriceperitem = new double[100];
	
	Scanner scan = new Scanner(System.in);		//Part 1.2 Java pre-defined class of Scanner
	
	Customer(){									//Part 1.4 Constructor with no argument
		super();
		System.out.print("Please enter the name of product you want: ");
		this.name = scan.nextLine();
		if(this.name.equalsIgnoreCase("Cabbage")) {
			this.price = 3.3;
		}
		else if(this.name.equalsIgnoreCase("Tomato")) {
			this.price = 4.0;
		}
		else if(this.name.equalsIgnoreCase("Corn")) {
			this.price = 4.5;
		}
		else if(this.name.equalsIgnoreCase("Mango")) {
			this.price = 6.0;
		}
		else if(this.name.equalsIgnoreCase("Watermelon")) {
			this.price = 3.0;
		}
		else if(this.name.equalsIgnoreCase("Dragon Fruit")) {
			this.price = 4.0;
		}
		else {
			System.out.println("Sorry, the product that you enter is not provided in our store");
		}
		System.out.printf("Price: RM%.2f%n",this.price);
		System.out.print("Please enter the amount of product that you want: ");
		this.amount = scan.nextInt();
		setTotalPrice(this.amount, this.price);
		printInfo();
		getPayment();
	}
	
	Customer(double[] price){					//Part 1.4 Constructor with 1 argument
		super();
		System.out.print("Please enter the name of product you want: ");
		this.name = scan.nextLine();
		if(this.name.equalsIgnoreCase("Cabbage")) {
			this.price = price[0];
		}
		else if(this.name.equalsIgnoreCase("Tomato")) {
			this.price = price[1];
		}
		else if(this.name.equalsIgnoreCase("Corn")) {
			this.price = price[2];
		}
		else if(this.name.equalsIgnoreCase("Mango")) {
			this.price = price[3];
		}
		else if(this.name.equalsIgnoreCase("Watermelon")) {
			this.price = price[4];
		}
		else if(this.name.equalsIgnoreCase("Dragon Fruit")) {
			this.price = price[5];
		}
		else {
			System.out.println("Sorry, the product that you enter is not provided in our store");
		}
		System.out.printf("Price: RM%.2f%n",this.price);
		System.out.print("Please enter the amount of product that you want: ");
		this.amount = scan.nextInt();
		setTotalPrice(this.amount, this.price);
		printInfo();
		getPayment();
	}
	
	Customer(String[] name, double[] price){				//Part 1.4 Constructor with 2 argument
		super();
		int[] amount = new int[price.length];
		for(int i = 0; i < name.length; i++) {
			System.out.print("Please enter the amount that you want for " + name[i] + " : ");
			amount[i] = scan.nextInt();
		}
		setTotalPricePerItem(amount, price);
		setTotalPrice(this.totalpriceperitem);
		this.totalpriceperitem = getTotalPricePerItem();
		this.totalprice = getTotalPrice();
		printInfo(name, amount, price, this.totalpriceperitem, this.totalprice);
		getPayment();
	}

	void setTotalPrice(int amount, double price) {			//Part 2.3 Encapsulation, Setter method
		this.totalprice = amount*price;
	}
	
	void setTotalPrice(double[] totalpriceperitem) {		//Part 2.3 Encapsulation, Setter method
		for(int i = 0; i < totalpriceperitem.length; i++) {
			this.totalprice += totalpriceperitem[i];
		}
	}
	
	void setTotalPricePerItem(int[] amount, double[] price) {		//Part 2.3 Encapsulation, Setter method
		for(int i = 0; i<price.length; i++) {
			this.totalpriceperitem[i] = amount[i] * price[i];
		}
	}
	
	double getTotalPrice() {		//Part 2.3 Encapsulation, Getter method
		return this.totalprice;
	}
	
	double[] getTotalPricePerItem() {	//Part 2.3 Encapsulation, Getter method
		return this.totalpriceperitem;
	}
	
	public void printInfo() {		//Part 2.2 Polymorphism of method printInfo
		System.out.println();
		System.out.println("Bill");
		System.out.println("Product name: " + this.name);
		System.out.println("Product amount: " + this.amount);
		System.out.printf("Product price: RM%.2f%n",this.price);
		System.out.println();
		System.out.printf("Total Charge: RM%.2f%n",this.totalprice);
	}
	
	void printInfo(String[] name, int[] amount, double[] price, double[] totalpriceperitem, double totalprice) {		//Part 2.2 Polymorphism of method printInfo
		System.out.println();
		System.out.println("Bill");
		for(int i = 0; i < name.length; i++) {
			System.out.println();
			System.out.println("Product name: " + name[i]);
			System.out.println("Product amount: " + amount[i]);
			System.out.printf("Product price: RM%.2f%n",price[i]);
			System.out.printf("Total Price for product: RM%.2f%n",totalpriceperitem[i]);
		}
		System.out.println();
		System.out.printf("Total Charge: RM%.2f%n",totalprice);
	}
	
	public void getPayment() {										//Part 2.5 Implementing Method of Interface
		System.out.print("Please enter your payment amount: RM");
		this.payment = scan.nextDouble();
		while(this.payment < this.totalprice) {
			System.out.println("Sorry! the payment you've made is not enough!");
			System.out.printf("Your total charge = RM%.2f%n",this.totalprice);
			System.out.print("Please enter your payment amount: RM");
			this.payment = scan.nextDouble();
		}
		System.out.println("Payment Success");
		System.out.printf("Your Charge: RM%.2f%n",this.totalprice);
		System.out.printf("Your Payment: RM%.2f%n",this.payment);
		this.change = this.payment - this.totalprice;
		System.out.printf("Your Change: RM%.2f%n",this.change);
	}
}
