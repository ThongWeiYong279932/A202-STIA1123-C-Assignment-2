package assignment2;

import java.util.Scanner;

public class EmployeeManagement extends Finance{			//Part 2.1 Inheritance of class Finance
	private int ordinaryno, executiveno;						//Variables and arrays are privatized to prevent the variables and arrays to be access from other class
	private String[] ordinaryname;
	private String[] executivename;
	private double[] ordinarysalary;
	private double[] executivesalary;
	private double totalordinarysalary, totalexecutivesalary, totalsalary;
	
	
	Scanner scan = new Scanner(System.in);						//Part 1.2 Java pre-defined class of Scanner
	
	EmployeeManagement(){															//Part 1.4 Constructor with no argument
		super();
		System.out.print("Please enter the number of ordinary employee: ");
		this.ordinaryno = scan.nextInt();
		System.out.print("Please enter the number of executive employee: ");
		this.executiveno = scan.nextInt();
		this.ordinaryname = new String[this.ordinaryno];
		this.ordinarysalary = new double[this.ordinaryno];
		this.executivename = new String[this.executiveno];
		this.executivesalary = new double[this.executiveno];
		for(int i = 0; i < this.ordinaryname.length; i++) {
			System.out.print("Please enter ordinary employee " + (i+1) + " name: ");
			this.ordinaryname[i] = scan.next();scan.nextLine();
			System.out.print("Please enter his/her salary: RM");
			this.ordinarysalary[i] = scan.nextDouble();
		}
		for(int j = 0; j < this.executivename.length; j++) {
			System.out.print("Please enter executive employee " + (j+1) + " name: ");
			this.executivename[j] = scan.next();scan.nextLine();
			System.out.print("Please enter his/her salary: RM");
			this.executivesalary[j] = scan.nextDouble();
		}
		setTotalOrdinarySalary(this.ordinarysalary);
		setTotalExecutiveSalary(this.executivesalary);
		setTotalSalary(this.totalordinarysalary, this.totalexecutivesalary);
		getTotalOrdinarySalary();
		getTotalExecutiveSalary();
		getTotalSalary();
		printInfo();
	}
	
	EmployeeManagement(int ordinaryno){														//Part 1.4 Constructor with 1 argument
		super();
		this.ordinaryno = ordinaryno;
		System.out.println("The number of ordinary employees: " + this.ordinaryno);
		System.out.print("Please enter the number of executive employee: ");
		this.executiveno = scan.nextInt();
		this.ordinaryname = new String[this.ordinaryno];
		this.ordinarysalary = new double[this.ordinaryno];
		this.executivename = new String[this.executiveno];
		this.executivesalary = new double[this.executiveno];
		for(int i = 0; i < this.ordinaryname.length; i++) {
			System.out.print("Please enter ordinary employee " + (i+1) + " name: ");
			this.ordinaryname[i] = scan.next();scan.nextLine();
			System.out.print("Please enter his/her salary: RM");
			this.ordinarysalary[i] = scan.nextDouble();
		}
		for(int j = 0; j < this.executivename.length; j++) {
			System.out.print("Please enter executive employee " + (j+1) + " name: ");
			this.executivename[j] = scan.next();scan.nextLine();
			System.out.print("Please enter his/her salary: RM");
			this.executivesalary[j] = scan.nextDouble();
		}
		setTotalOrdinarySalary(this.ordinarysalary);
		setTotalExecutiveSalary(this.executivesalary);
		setTotalSalary(this.totalordinarysalary, this.totalexecutivesalary);
		getTotalOrdinarySalary();
		getTotalExecutiveSalary();
		getTotalSalary();
		printInfo();
	}
	
	EmployeeManagement(int executiveno, String[] executivename){						//Part 1.4 Constructor with 2 argument
		super();
		this.executiveno = executiveno;
		this.executivename = executivename;
		System.out.print("Please enter the number of ordinary employee: ");
		this.ordinaryno = scan.nextInt();
		System.out.println("The number of executive employees: " + executiveno);
		this.ordinaryname = new String[ordinaryno];
		this.ordinarysalary = new double[this.ordinaryno];
		this.executivesalary = new double[this.executiveno];
		for(int i = 0; i < this.ordinaryname.length; i++) {
			System.out.print("Please enter ordinary employee " + (i+1) + " name: ");
			this.ordinaryname[i] = scan.next();scan.nextLine();
			System.out.print("Please enter his/her salary: RM");
			this.ordinarysalary[i] = scan.nextDouble();
		}
		for(int j = 0; j < this.executivename.length; j++) {
			System.out.print("Please enter executive " + executivename[j] + "'s salary: RM");
			this.executivesalary[j] = scan.nextDouble();
		}
		setTotalOrdinarySalary(this.ordinarysalary);
		setTotalExecutiveSalary(this.executivesalary);
		setTotalSalary(this.totalordinarysalary, this.totalexecutivesalary);
		getTotalOrdinarySalary();
		getTotalExecutiveSalary();
		getTotalSalary();
		printInfo();
	}
	
	void setTotalOrdinarySalary(double[] ordinarysalary) {		//Part 2.3 Encapsulation, Setter method
		for (int i = 0; i < ordinarysalary.length; i++) {
			this.totalordinarysalary += ordinarysalary[i];
		}
	}
	
	void setTotalExecutiveSalary(double[] executivesalary) {	//Part 2.3 Encapsulation, Setter method
		for (int i = 0; i < executivesalary.length; i++) {
			this.totalexecutivesalary += executivesalary[i];
		}
	}
	
	void setTotalSalary(double totalordinarysalary, double totalexecutivesalary) {		//Part 2.3 Encapsulation, Setter method
		this.totalsalary = totalordinarysalary + totalexecutivesalary;
	}
	
	double getTotalOrdinarySalary() {		//Part 2.3 Encapsulation, Getter method
		return this.totalordinarysalary;
	}
	
	double getTotalExecutiveSalary() {		//Part 2.3 Encapsulation, Getter method
		return this.totalexecutivesalary;
	}
	
	double getTotalSalary() {				//Part 2.3 Encapsulation, Getter method
		return this.totalsalary;
	}
	
	public void printInfo() {		//Part 2.2 Polymorphism of method printInfo
		System.out.println();
		System.out.println("Employees Details");
		System.out.println();
		System.out.println("Number of ordinary employee: " + this.ordinaryno);
		for (int i = 0; i < this.ordinaryname.length; i++) {
				System.out.println();
				System.out.println("Employee " + (i+1));
				System.out.println("Name: " + this.ordinaryname[i]);
				System.out.printf("Salary: RM%.2f%n",this.ordinarysalary[i]);
		}
		System.out.println();
		System.out.println("Number of executive employee: " + this.executiveno);
		for (int j = 0; j < this.executivename.length; j++) {
				System.out.println();
				System.out.println("Executive " + (j+1));
				System.out.println("Name: " + this.executivename[j]);
				System.out.printf("Salary: RM%.2f%n",this.executivesalary[j]);
		}
		System.out.println();
		System.out.printf("Total salary for ordinary employee: RM%.2f%n",this.totalordinarysalary);
		System.out.printf("Total salary for executive employee: RM%.2f%n",this.totalexecutivesalary);
		System.out.printf("Total salary for all employee: RM%.2f%n",this.totalsalary);
	}
}
