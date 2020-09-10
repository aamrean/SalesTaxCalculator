package com.main;
import java.util.ArrayList;
import java.util.Scanner;


// This is the Client Class- takes input of products.
public class ShoppingCartClient {
	public static double total=0;
	public static double salesTax=0;
	public static void main(String[] args) {
	//ArrayList to store the products in basket
	ArrayList<Product> productList=new ArrayList<Product>();
	Scanner sc=new Scanner(System.in);
	int quantity=0;
	double price=0;
	ProductFactory factory=new ProductFactory();
	while(sc.hasNext()) {
		String productLine=sc.nextLine();
		//exit means the end of basket
		if(productLine.equals("exit")) {
			sc.close();
			calculateSalesTax(productList);
			displayCart(productList);
			displayFinal(productList);
			System.exit(0);
		}
		String productName="";
		boolean imported=false;
		// get productName, quantity, price and isImported from Each input item
		String[] productDetails=productLine.split(" ");
		 quantity=Integer.parseInt(productDetails[0]);
		 price= Float.parseFloat(productDetails[productDetails.length-1]);
		
		for(int i=1;i<productDetails.length-2;i++) {
			productName+=productDetails[i]+" ";
		}
		
		productName= productName.trim();
		
		if(productName.contains("imported")) {
			imported=true;
		}
		
		Product product=factory.getProduct(productName, quantity, price, imported);
		productList.add(product);
		
	}
	}
	
	//Visit each product and update salestax and price of the product
	public static void calculateSalesTax(ArrayList<Product> products) {
		CartVisitor visitor=new CartVisitorImpl();
		for (Product product : products) {
			product.accept(visitor);
			total=total+product.getPrice();
			salesTax=salesTax+product.getSalesTax();
		}
		salesTax=Double.parseDouble(String.format("%.2f", salesTax));
		total=Double.parseDouble(String.format("%.2f", total));
	}
	
	//Display Final salestax and total
	public static void displayFinal(ArrayList<Product> products) {
		
		System.out.println("Sales Tax:"+ String.format("%.2f", salesTax)+
				" Total:"+ String.format("%.2f", total));
		//return 0;
	}
	
	public static void displayCart(ArrayList<Product> products) {
		for (Product product : products) {
			if(product.isImported())
				System.out.println(product.getQuantity()+
						" imported "+product.getProductName()+
						":"+String.format("%.2f", product.getPrice()));
			else
				System.out.println(product.getQuantity()+
						" "+product.getProductName()+
						":"+String.format("%.2f", product.getPrice()));
		}
	}
}
