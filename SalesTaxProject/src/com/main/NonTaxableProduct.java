package com.main;
public class NonTaxableProduct extends Product{

	public NonTaxableProduct(String name, int quantity, boolean imported,double price) {
		super(name, quantity, imported,price);
	}

	@Override
	public int accept(CartVisitor visitor) {
		return visitor.visit(this);
	}

}
