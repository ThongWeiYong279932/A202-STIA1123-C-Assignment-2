package assignment2;

import java.util.Scanner;

public class Marketing extends Finance{				//Part 2.1 Inheritance of class Finance
	private String[] method = new String[100];		//Variables and arrays are privatized to prevent the variables and arrays to be access from other class
	private double[] cost = new double [100];
	private char respond;
	private double totalcost;
	
	Scanner scan = new Scanner(System.in);												//Part 1.2 Java pre-defined class of Scanner
	
	Marketing(){																		//Part 1.4 Constructor with no argument
		super();
		int i = 0;
		do {
			System.out.print("Please enter the marketing method: ");
			this.method[i] = scan.next();scan.nextLine();
			System.out.print("Please enter the cost of the marketing method: RM");
			this.cost[i] = scan.nextDouble();
			i++;
			System.out.print("Is there any other marketing method? (y-yes, n-no): ");
			respond = scan.next().charAt(0);
			while(respond != 'y' && respond != 'n') {
				System.out.println("Wrong input! Please enter y for yes and n for no only!");
				System.out.print("Is there any other marketing method? (y-yes, n-no): ");
				respond = scan.next().charAt(0);
			}
		} while (respond == 'y' && i < this.method.length);
		setTotalCost(this.cost);
		getTotalCost();
		printInfo();
	}
	
	Marketing(String[] method){														//Part 1.4 Constructor with 1 argument
		super();
		this.method = method;
		for (int i = 0; i < this.method.length; i++) {
			System.out.print("Please enter the cost of " + this.method[i] + ": RM");
			this.cost[i] = scan.nextDouble();			
		}
		setTotalCost(this.cost);
		getTotalCost();
		printInfo();
	}
	
	Marketing(String[] method, double[] cost){										//Part 1.4 Constructor with 2 argument
		super();
		this.method = method;
		this.cost = cost;
		setTotalCost(this.cost);
		getTotalCost();
		printInfo();
	}
	
	void setTotalCost(double[] cost) {						///Part 2.3 Encapsulation, Setter method
		for (int i = 0; i < cost.length; i++) {
			this.totalcost += cost[i];
		}
	}
	
	double getTotalCost() {			//Part 2.3 Encapsulation, Getter method
		return this.totalcost;
	}
	
	public void printInfo() {					//Part 2.2 Polymorphism of method printInfo
		System.out.println();
		System.out.println("Marketing Details");
		for (int i = 0; i < this.method.length; i++) {
			if (method[i] != null) {
				System.out.println("Marketing method " + (i+1) + ": " + this.method[i]);
				System.out.printf("Cost of marketing method: RM%.2f%n",this.cost[i]);
			}
		}
		System.out.printf("Total marketing cost: RM%.2f%n",this.totalcost);
	}
}
