package com.main;


public class TaxableProduct extends Product{
	
	public TaxableProduct(String name, int quantity, boolean imported,double price) {
		super(name, quantity, imported,price);
	}

	@Override
	public int accept(CartVisitor visitor) {
		return visitor.visit(this);
	}

}
