package assignment2;

import java.util.Scanner;

public abstract class Finance implements Payment{			//Part 2.4 Abstraction //Part 2.5 Implementation of Interface Payment
private double sales, costofgoods, operatingExpense, tax, grossProfit, operatingIncome, netIncome, investmentIncome, retainIncome;	//Variables are privatized to prevent the variables to be access from other class
	
	Scanner scan = new Scanner(System.in);							//Part 1.2 Java per-defined class of Scanner
	
	Finance(){																						//Part 1.4 Constructor with no argument
		super();
		System.out.print("Please enter this month's sales: RM");
		this.sales = scan.nextDouble();
		System.out.print("Please enter this month's cost of goods: RM");
		this.costofgoods = scan.nextDouble();
		System.out.print("Please enter this month's operating expenses: RM");
		this.operatingExpense = scan.nextDouble();
		System.out.print("Please enter this month's tax expenses: RM");
		this.tax = scan.nextDouble();
		setGrossProfit(this.sales, this.costofgoods);
		setOperatingIncome(this.grossProfit, this.operatingExpense);
		setNetIncome(this.operatingIncome, this.tax);
		getGrossProfit();
		getOperatingIncome();
		getNetIncome();
		printInfo(this.sales);
		getPayment();
	}
	
	Finance(double sales){																			//Part 1.4 Constructor with 1 argument
		super();
		this.sales = sales;
		System.out.printf("This month's sales: RM%.2f%n",this.sales);
		System.out.print("Please enter this month's cost of goods: RM");
		this.costofgoods = scan.nextDouble();
		System.out.print("Please enter this month's operating expenses: RM");
		this.operatingExpense = scan.nextDouble();
		System.out.print("Please enter this month's tax expenses: RM");
		this.tax = scan.nextDouble();
		setGrossProfit(this.sales, this.costofgoods);
		setOperatingIncome(this.grossProfit, this.operatingExpense);
		setNetIncome(this.operatingIncome, this.tax);
		getGrossProfit();
		getOperatingIncome();
		getNetIncome();
		printInfo(this.sales);
		getPayment();
	}
	
	Finance(double sales, double costofgoods){														//Part 1.4 Constructor with 2 argument
		super();
		this.sales = sales;
		this.costofgoods = costofgoods;
		System.out.printf("This month's sales: RM%.2f%n",this.sales);
		System.out.printf("This month's cost of goods: RM%.2f%n",this.costofgoods);
		System.out.print("Please enter this month's operating expenses: RM");
		this.operatingExpense = scan.nextDouble();
		System.out.print("Please enter this month's tax expenses: RM");
		this.tax = scan.nextDouble();
		setGrossProfit(this.sales, this.costofgoods);
		setOperatingIncome(this.grossProfit, this.operatingExpense);
		setNetIncome(this.operatingIncome, this.tax);
		getGrossProfit();
		getOperatingIncome();
		getNetIncome();
		printInfo(this.sales);
		getPayment();
	}
	
	void setGrossProfit(double sales, double costofgoods) {					//Part 2.3 Encapsulation, Setter method
		this.grossProfit = sales - costofgoods;									//gross profit = sales - cost of goods
	}
	
	void setOperatingIncome(double grossprofit, double operatingexpense) {	//Part 2.3 Encapsulation, Setter method
		this.operatingIncome = grossprofit - operatingexpense;					//operating income = gross profit - operating expenses
	}
	
	void setNetIncome(double operatingincome, double tax) {		//Part 2.3 Encapsulation, Setter method
		this.netIncome =  operatingincome - tax;					//net income = operating income - taxes
	}
	
	double getGrossProfit() {		//Part 2.3 Encapsulation, Getter method
		return this.grossProfit;
	}
	
	double getOperatingIncome() {	//Part 2.3 Encapsulation, Getter method
		return this.operatingIncome;
	}
	
	double getNetIncome() {			//Part 2.3 Encapsulation, Getter method
		return this.netIncome;
	}
	
	public void printInfo(double sales) {	//Part 2.2 Polymorphism of method printInfo
		System.out.println();
		System.out.println("Financial Statement");
		System.out.printf("Sales: RM%.2f%n",sales);
		System.out.printf("Cost of goods: RM%.2f%n",this.costofgoods);
		System.out.printf("Gross Profit: RM%.2f%n",this.grossProfit);
		System.out.printf("Operating Expense: RM%.2f%n",this.operatingExpense);
		System.out.printf("Operating Income: RM%.2f%n",this.operatingIncome);
		System.out.printf("Taxes expense: RM%.2f%n",this.tax);
		System.out.printf("Net Income: RM%.2f%n",this.netIncome);
	}
	public abstract void printInfo();		//Part 2.4 Abstract method
	
	public void getPayment() {				//Part 2.5 Implementation of method in Interface Payment
		System.out.print("Please enter the amount of income you want to use for future investment: RM");
		this.investmentIncome = scan.nextDouble();
		while(this.investmentIncome > this.netIncome) {
			System.out.println("Sorry! Income For Investment cannot be bigger than Net Income!");
			System.out.print("Please enter the amount of income you want to use for future investment: RM");
			this.investmentIncome = scan.nextDouble();
		}
		System.out.println("Operation Success");
		System.out.printf("Net Income: RM%.2f%n",this.netIncome);
		System.out.printf("Income kept for future investment: RM%.2f%n",this.investmentIncome);
		this.retainIncome = this.netIncome - this.investmentIncome;
		System.out.printf("Remaining Income: RM%.2f%n",this.retainIncome);
		System.out.println();
	}
}
