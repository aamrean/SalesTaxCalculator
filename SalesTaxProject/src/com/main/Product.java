package com.main;
public abstract class Product {
	
	private String productName;
	private int quantity;
	private boolean imported;
	private double price;
	private double salesTax;
	
	public double getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(double salesTax) {
		this.salesTax = salesTax;
	}

	public Product(String name,int quantity, boolean imported,double price) {
		this.productName=name;
		this.quantity=quantity;
		this.imported=imported;
		this.price=price;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public boolean isImported() {
		return imported;
	}
	
	public void setImported(boolean imported) {
		this.imported = imported;
	}
	
	public abstract int accept(CartVisitor visitor);
	
}
