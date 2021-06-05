package assignment2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] productname = {"Cabbage", "Tomato", "Corn", "Mango", "Watermelon", "Dragon Fruit"};
		double[] price = {3.30, 4.00, 4.50, 6.00, 3.00, 4.00};
		String[] method = {"Advertisement", "Promotion Events"};
		double[] cost = {2500, 1500};
		String[] executivename = {"Adam", "Amelia", "Theresa", "Antonio"};
		
			
		System.out.println();
		System.out.println("Products for grocery store #1");
		GroceryStoreBusiness b1 = new ProductDescription();
		
		System.out.println();
		System.out.println("Products for grocery store #2");
		GroceryStoreBusiness b2 = new ProductDescription(productname);
		
		System.out.println();
		System.out.println("Products for grocery store #3");
		GroceryStoreBusiness b3 = new ProductDescription(productname, price);
		
		System.out.println();
		System.out.println("Finance for January");
		Finance c1 = new Marketing();
		
		System.out.println();
		System.out.println("Finance for February");
		Finance c2 = new Marketing(method);
		
		System.out.println();
		System.out.println("Finance for March");
		Finance c3 = new Marketing(method, cost);
		
		System.out.println();
		System.out.println("Finance for April");
		Finance d1 = new EmployeeManagement();
		
		System.out.println();
		System.out.println("Finance for May");
		Finance d2 = new EmployeeManagement(6);
		
		System.out.println();
		System.out.println("Finance for June");
		Finance d3 = new EmployeeManagement(4, executivename);
		
		System.out.println();
		System.out.println("Finance for July");
		Finance e1 = new InventoryManagement();
		
		System.out.println();
		System.out.println("Finance for August");
		Finance e2 = new InventoryManagement(productname);
		
		System.out.println();
		System.out.println("Finance for September");
		Finance e3 = new InventoryManagement(productname, price);
		
		System.out.println();
		System.out.println("Customer #1");
		GroceryStoreBusiness g1 = new Customer();
		
		System.out.println();
		System.out.println("Customer #2");
		GroceryStoreBusiness g2 = new Customer(price);
		
		System.out.println();
		System.out.println("Customer #3");
		GroceryStoreBusiness g3 = new Customer(productname, price);
		
	}

}
